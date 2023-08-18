package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.01";
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // true - autoflush / file io는 false로 해야함.
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			scanner = new Scanner(System.in);//키보드 연결
			
			while(true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				String data = br.readLine();
				
				if(data == null)
				{
					// 서버가 정상적으로 close() 됨.
					log("closed by server");
					break;
				}
				
				log("<<" + data);
			}
			
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
	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}
}
