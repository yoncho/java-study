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
				if("MSG".equals(tokens[0])) {
					String message = tokens[1];
					System.out.println(message);
				}else if("SYSTEM".equals(tokens[0])) {
					System.out.println("SYSTEM:" + tokens[1]);
				}else {
					System.out.println("SYSTEM: 정의되지 않은 명령어 입니다. (" + line+")");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
