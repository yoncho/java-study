package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			//1. ServerSocket Create
			ServerSocket serverSocket = new ServerSocket();
			
			
			//2. ServerSocket Binding
			// Socket에 InetSocketAddress(IPAddress + port)를 바인딩 한다.
			// IPAddress: 0.0.0.0 = 특정 호스트 IP에 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10); //10 <- backLog, threadHold?
			
			//3. Accept
			Socket socket = serverSocket.accept(); //Blocking <- 풀어주려면 client를 만들어서 connect를 해야함.
			
			
			
		} catch (IOException e) {
			System.out.println("[server] Error: " + e);
		}
		
	}

}
