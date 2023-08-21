package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread{
	private Socket socket;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		
			while(true) 
			{
				String line = br.readLine();
				if(line == null) {
					break;
				}
				
				String[] tokens = line.split(":");
				if("ADD:OK".equals(line)){
					System.out.println("채팅방에 입장했습니다 : )");
				}else if("ADD:FAIL".equals(line)) {
					System.out.println("채팅방 입장에 실패했습니다. :(");
					break;
				}else if("MSG".equals(tokens[0])) {
					String message = tokens.length == 1 ? "":tokens[1];
					System.out.println(message);
				}else if("SYSTEM".equals(tokens[0])) {
					System.out.println("SYSTEM:" + tokens[1]);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
