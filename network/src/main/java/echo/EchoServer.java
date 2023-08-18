package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
				
				try {
					InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
						String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
						int remoteHostPort = remoteInetSocketAddress.getPort(); 
						
						log("connected by client [" + remoteHostAddress +
								":" + remoteHostPort + "]");
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
		System.out.println("[EchoServer] " + message);
	}

}
