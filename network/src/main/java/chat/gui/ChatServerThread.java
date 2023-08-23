package chat.gui;

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
	private boolean isRunnable = true;
	private final String ALL_USER = "/ALL";
	
	public ChatServerThread(Socket socket, List<ClientInfo> clientInfoList) {
		this.socket = socket;
		this.clientInfoList = clientInfoList;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
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
				 *     (1) /WHISPER user_name message
				 *    	/WHISPER yoncho hello 하게되면 yoncho라는 client에게 hello메시지를 귓속말로 전송.
				 *  3) /QUIT = 퇴장
				 *  4) /MEMS = 현재 채팅방의 사용자 목록 표시
				 *  '/'가 붙은 명령어의 경우 SYSTEM_COMMAND로 분류. ChatUtil에 정의된 COMMAND 확인!
				 * */
				String[] tokens = request.split(":");
				if ((ChatServer.COMMAND_ADD).equals(tokens[0])) {
					String[] addTokens = tokens[1].split("@");
					
					if(!checkPassWord(addTokens[1])) {
						//Password wrong!!
						pw.println(ChatServer.COMMAND_ADD_FAIL);
						break;
					}
					doJoin(addTokens[0], pw);
				}else if(ChatServer.COMMAND_MSG.equals(tokens[0])) {
					message = tokens[1];
					doMessage(ALL_USER, message);
				}else if(ChatServer.SYSTEM_COMMAND_WHISPER.equals(tokens[0])) {
					String[] whipserData = tokens[1].split("/");
					doMessage(whipserData[0], "(귓속말) " +whipserData[1]);
					String ack = ChatServer.SYSTEM_COMMAND_WHISPER_OK + ":("+ whipserData[0]+"=>"+whipserData[1]+")"; 
					this.client.getPrintWriter().println(ack);
				}else if(ChatServer.SYSTEM_COMMAND_QUIT.equals(tokens[0])) {
					doQuit(pw);
					break;
				}else if (ChatServer.SYSTEM_COMMAND_MEMS.equals(tokens[0])) {
					systemNotifyClienList(); //현재 서버에 연결되어있는 Client목록 표시
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
				if(socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.systemLog("Exception", e.toString());
			}
		}
	}

	private boolean checkPassWord(String password) {
		return ChatServer.PASSWORD.equals(password) ? true:false;
	}

	private void doJoin(String nickName,PrintWriter pw) {
		this.client = new ClientInfo(nickName, Thread.currentThread().getId(),pw);
		String data = "MSG:" + client.getNickName() + "님이 입장했습니다.";
		broadCast(ALL_USER,data);
		addClient(client);
		String ack = "ADD:OK";
		//ACK
		pw.println(ack);
	}
	
	private void doMessage(String target, String message) {
		String broadCaseMessage = "MSG:["+ this.client.getNickName() + "] " + message;
		broadCast(target, broadCaseMessage);
	}

	private void doQuit(PrintWriter pw) {
		String data = "MSG:" + this.client.getNickName() + "님이 퇴장 하였습니다.";
		removeClient(this.client);
		broadCast(ALL_USER, data);
		if(clientInfoList.isEmpty())
		{
			System.out.println("채팅방에 아무도 없습니다.");
			isRunnable = false;
		}
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
	private void broadCast(String target, String data) {
		synchronized (clientInfoList) {
			for(ClientInfo client : clientInfoList) {
				if(target == ALL_USER || (target != ALL_USER && client.getNickName().equals(target)))
				{
					client.getPrintWriter().println(data);
				}
			}
		}
	}
	
	public void systemNotifyClienList() {
		broadCast(ALL_USER, "SYSTEM:=====현재 채팅방 사용자 목록 =====");
		for(ClientInfo client : clientInfoList) {
			broadCast(ALL_USER, "SYSTEM:" + client.getNickName());
		}
		broadCast(ALL_USER, "SYSTEM:===========================");
	}
}
