package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends ChatUtil{
	//final area
	private static final String IP_ADRESS = "127.0.0.1";
	private static final int PORT = 9999;
	public static final String SYSTEM = "CLIENT";
	public static final String COMMAND_ADD = "ADD:";
	public static final String COMMAND_MSG = "MSG:";
	public static final String COMMAND_EXT = "EXT:";
	public static final String COMMAND_MEMS = "MEMS:";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		PrintWriter pw = null;
		Thread readThread = null;
		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
			//2. socket 생성
			socket = new Socket();
			
			//3. 연결
			socket.connect(new InetSocketAddress(IP_ADRESS, PORT));
			//4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true);
			
			//5. join 프로토콜, 닉네임 입력과 채팅방 입력
			systemLog("SYSTEM","닉네임>>");
			String nickName = scanner.nextLine();
			if(!checkIdFormat(nickName))
			{
				systemLog("SYSTEM","이름 입력 포맷이 잘못 되었습니다. (공백이 포함되어있습니다.)");
				return;
			}
			systemLog("SYSTEM","채팅방 비밀번호>>");
			String password = scanner.nextLine();
			
			pw.println(COMMAND_ADD+nickName+"@"+password);
			
			//6. ChatClientReceiveThread 시작
			readThread = new ChatClientThread(socket);
			readThread.start();
			
			//7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input)) {
					//8. quit 프로토콜 처리
					pw.println(COMMAND_EXT);
					break;
				}else if ("mems".equals(input)){
					pw.println(COMMAND_MEMS);
				}
				else {
					//9. 메시지 처리
					pw.println(COMMAND_MSG+input);
				}
			}
			
		}catch(Exception e) {
			systemLog("Exception",e.toString());
			pw.println("EXT");
		}finally {
			if(readThread != null) {
				readThread.interrupt();
			}
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
				if(pw != null) {
					pw.close();
				}
			} catch (IOException e) {
				systemLog("IOException",e.toString());
			}
		}
	}

	public static boolean checkIdFormat(String id) {
		
		if(id == "" || id.isEmpty() || id.replace(String.valueOf(" "), "").length() == 0)
		{
			return false;
		}
		return true;
	}
}
