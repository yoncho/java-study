package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName;
	private List<ClientInfo> clientInfoList;
	private ClientInfo client;
	
	public ChatServerThread(Socket socket, List<ClientInfo> clientInfoList) {
		this.socket = socket;
		this.clientInfoList = clientInfoList;
	}
	

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			boolean isRunnable = true;
			
			//1. Host Info
			InetSocketAddress iSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String hostAddress = iSocketAddress.getAddress().getHostAddress();
			//2. IO
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			//3. Request
			while(isRunnable) {
				String request = br.readLine();
				String message = null;
				if(request == null) {
					ChatServer.systemLog(ChatServer.SYSTEM,  "클라이언트로 부터 연결이 끊김");
					break;
				}
				
				/* 4. Protocol
				 * *본 작업에서 통신 프로토콜은 아래와 같다.
				 * 모든 메시지는 '명령어:메시지' 구조로 한다.
				 * 명령어 : 
				 * 	1) ADD = 사용자 추가
				 * 	ex) ADD:user-name
				 *   return ADD:OK 
				 *   return ADD:FAIL  
				 *  2) MSG = 메시지 전송
				 *  ex) MSG:hello world!
				 *  Option)
				 *     (1) TO- = 상대 언급
				 *    	MSG:TO-username/hello !
				 *  3) EXT = 퇴장
				 *  4) MEMS = 현재 채팅방의 사용자 목록 표시
				 * */
				String[] tokens = request.split(":");
				if ("ADD".equals(tokens[0])) {
					String[] addTokens = tokens[1].split("@");
					
					if(!checkPassWord(addTokens[1])) {
						//Password wrong!!
						pw.println("ADD:FAIL");
						break;
					}
					doJoin(addTokens[0], pw);
				}else if("MSG".equals(tokens[0])) {
					//Client의 입력이 Enter인 경우 빈 개행 출력 
					message = tokens.length == 1 ? "" : tokens[1];
					
					doMessage(message);
				}else if("EXT".equals(tokens[0])) {
					doQuit(pw);
					break;
				}else if ("MEMS".equals(tokens[0])) {
					notifyClienList(); //현재 서버에 연결되어있는 Client목록 표시
				}else {
					ChatServer.systemLog(ChatServer.SYSTEM, "ERROR : 정의되지 않은 명령어 입력 (" + tokens[0] +")");
				}
			}
		} catch (UnsupportedEncodingException e) {
			ChatServer.systemLog("UnsupportedEncodingException", e.toString());
		} catch (IOException e) {
			ChatServer.systemLog("IOException", e.toString());
		} catch (Exception e) {
			ChatServer.systemLog("Exception", e.toString());
		}finally {
			try {
				if(br != null) {
					br.close();
				}
				if(pw != null) {
					pw.close();
				}
			} catch (IOException e) {
				ChatServer.systemLog("Exception", e.toString());
			}
		}
	}

	private boolean checkPassWord(String password) {
		return ChatServer.PASSWORD.equals(password) ? true:false;
	}

	public void doJoin(String nickName,PrintWriter pw) {
		this.client = new ClientInfo(nickName, Thread.currentThread().getId(),pw);
		addClient(client);
		String ack = "ADD:OK";
		
		String data = "MSG:" + client.getNickName() + "님이 참여했습니다.";
		broadCast(data, true);
		
		//ACK
		pw.println(ack);
	}
	
	private void doMessage(String message) {
		String broadCaseMessage = "MSG:("+ this.client.getNickName() + ") " + message;
		broadCast(broadCaseMessage, false);
	}

	private void doQuit(PrintWriter pw) {
		String data = "MSG:" + this.client.getNickName() + "님이 퇴장 하였습니다.";
		removeClient(this.client);
		broadCast(data, true);
	}

	private void removeClient(ClientInfo client) {
		synchronized(clientInfoList){
			clientInfoList.remove(clientInfoList.indexOf(client));
		}
	}
	
	public void addClient(ClientInfo client) {
		synchronized (clientInfoList) {
			clientInfoList.add(client);
		}
	}
	
	//exceptSelf는 현재 스레드와 연결된 client를 제외하고 다른 client에게만 전송하는 옵션.
	private void broadCast(String data, Boolean exceptSelf) {
		synchronized (clientInfoList) {
			for(ClientInfo client : clientInfoList) {
				if((this.client).equals(client) && exceptSelf)
				{
					continue;
				}
				client.getPrintWriter().println(data);
			}
		}
	}
	
	public void notifyClienList() {
		broadCast("SYSTEM:현재 채팅방 사용자 목록 ==========", false);
		for(ClientInfo user : clientInfoList) {
			broadCast("SYSTEM:" + user.getNickName(), false);
		}
		broadCast("SYSTEM:===========================", false);
	}
}
