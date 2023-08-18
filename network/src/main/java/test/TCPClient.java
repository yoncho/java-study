package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.01";
	private static final int SERVER_PORT = 5000;
	
	public static void main(String[] args) {
		Socket socket = null;
		try {
			//1. Socket Create
			socket = new Socket();
			
			//2. Server Connect
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			//3. Receive IO Stream 
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. Write Data
			String data = "hello 안녕";
			os.write(data.getBytes("utf-8"));
			
			//5. Receive Data
			byte[] buffer = new byte[256];
			
			int readByteCount = is.read(buffer); // Blocking
			
			if(readByteCount == -1)
			{
				// 서버가 정상적으로 close() 됨.
				System.out.println("[client] closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[client] received : " + data);
			
		}catch (SocketException e) {
			System.out.println("[client] suddenly close by server");
		} catch (IOException e) {
			System.out.println("[client] error : " + e);
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
