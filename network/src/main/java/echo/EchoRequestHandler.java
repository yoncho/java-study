package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket = null;
	
	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = remoteInetSocketAddress.getPort(); 
		
		log("connected by client [" + remoteHostAddress +
				":" + remoteHostPort + "]");
		try{
			//중요함...!! stream 사용방법!!
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // true - autoflush / file io는 false로 해야함.
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while(true)
			{
				String data = br.readLine();
				
				if(data == null) {
					log("closed by client");
					break;
				}
				
				log("received : " + data);
				pw.println(data);
			}
			
		}catch(SocketException e) {
			log("suddenly closed by client");
		}catch(IOException e) {
			log("Socket Error: " + e);
		}
		finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void log(String message) {
		System.out.println("[EchoServer#"+ getId() +"] " + message);
	}
}
