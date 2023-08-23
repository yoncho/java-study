package chat.gui;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends ChatUtil{
	//Info
	private static final String IP_ADRESS = "0.0.0.0";
	private static final int PORT = 5556;
	public static final String SYSTEM = "SERVER";
	public static final String PASSWORD = "1234";

	//Command
	public static final String COMMAND_ADD = "ADD";
	public static final String COMMAND_ADD_OK = "ADD:OK";
	public static final String COMMAND_ADD_FAIL = "ADD:FAIL";
	public static final String COMMAND_MSG = "MSG";
	public static final String COMMAND_SYSTEM = "SYSTEM";
	public static final String SYSTEM_COMMAND_QUIT = "/QUIT";
	public static final String SYSTEM_COMMAND_MEMS = "/MEMS";
	public static final String SYSTEM_COMMAND_WHISPER = "/WHISPER"; //귓속말
	public static final String SYSTEM_COMMAND_WHISPER_OK = "WHISPER_OK"; 
	public static final String SYSTEM_COMMAND_WHISPER_FAIL = "WHISPER_FAIL";
	public static List<ClientInfo> clientInfoList;
	
	public static void main(String[] args) {
		//0. 
		ServerSocket serverSocket = null;
		int backLog = 10;
		try {
			//1. Create Server Socket
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP_ADRESS, PORT),backLog);
			systemLog(SYSTEM, "Waiting for connect " + IP_ADRESS + ":" + PORT);
			//#clientInfoList Init
			clientInfoList = new ArrayList<>();
			
			while(true) {
				Socket socket = serverSocket.accept();
				
				new ChatServerThread(socket, clientInfoList).start();
			}
			
		} catch (IOException e) {
			systemLog("IOEception", e.toString());
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				systemLog("IOEception", e.toString());
			}
		}
		
		
	}

}
