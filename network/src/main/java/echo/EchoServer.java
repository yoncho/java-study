package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT = 8000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10); // 10은 요청큐 
			// option 10은 accept하고 read할때까지 시간이 걸리는데. 그 사이 또 요청이 들어올 수 있는데. 그 요청을 queue에 넣어놓고 accept되고나서 queue에 쌓인
			// 요청들을 선행으로 수행한다..!! backLog (accept하고 connect까지 시간동안 들어오는 요청을 잠시 저장해두는 곳)
			log("starts...[port:"+PORT+"]");
			
			//1개의 thread
			while(true) {
				Socket socket = serverSocket.accept(); 

				new EchoRequestHandler(socket).start();
			}
			
			
			
		} catch (IOException e) {
			log("Server Socket Error: " + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[EchoServer#"+ Thread.currentThread().getId() +"] " + message);
	}

}
