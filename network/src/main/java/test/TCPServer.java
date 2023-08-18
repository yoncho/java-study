package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. ServerSocket Create
			serverSocket = new ServerSocket();
			
			
			//2. ServerSocket Binding
			// Socket에 InetSocketAddress(IPAddress + port)를 바인딩 한다.
			// IPAddress: 0.0.0.0 = 특정 호스트 IP에 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10); //10 <- backLog, threadHold?
			//3. Accept
			Socket socket = serverSocket.accept(); //Blocking <- 풀어주려면 client를 만들어서 connect를 해야함.
			
			try {
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remoteHostPort = remoteInetSocketAddress.getPort(); 
				
				System.out.println("[server] connected by client [" + remoteHostAddress +
						":" + remoteHostPort + "]");

				//4. IOStream 
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true)
				{
					//5. Receive Data 
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // Blocking 
						
					if(readByteCount == -1) {
						//1. 명시적 server close 함 (정상 종료) : 클라이언트가 정상적으로 종료
						System.out.println("[server] closed by client");
						break;
					}
					
					// Pirint Data
					String encodeData = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received : " + encodeData);
				
					
					//6. Write Data
					os.write(encodeData.getBytes("utf-8"));
					
				}
				
			}catch(SocketException e) {
				System.out.println("[server] suddenly closed by client");
			}catch(IOException e) {
				System.out.println("[server] Socket Error: " + e);
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
			
			
		} catch (IOException e) {
			System.out.println("[server] Server Socket Error: " + e);
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

}
