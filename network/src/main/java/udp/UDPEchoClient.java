package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.01";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		DatagramSocket socket = null;
		
		try {
			//1. Scanner Create
			scanner = new Scanner(System.in);
			
			//2. Socket Create
			socket = new DatagramSocket();
			
			while(true) {
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				//3. Data Send
				byte[] sndData = line.getBytes("utf-8");
				DatagramPacket sndPacket = new DatagramPacket(
						sndData, 
						sndData.length,
						new InetSocketAddress(SERVER_IP, UDPEchoServer.PORT));
				socket.send(sndPacket);
				
				//4. Data Read
				DatagramPacket rcvPacket = new DatagramPacket(new byte[UDPEchoServer.BUFFER_SIZE], UDPEchoServer.BUFFER_SIZE);
				
				socket.receive(rcvPacket); //blocking...
				byte[] rcvData = rcvPacket.getData();
				int offSet = rcvPacket.getLength();
				String message = new String(rcvData, 0, offSet, "UTF-8");
				System.out.println("<" + message);
			}
			
					
		}catch (SocketException e) {
			System.out.println("[UDP Echo Client] error : " + e);
		}catch (IOException e) {
			System.out.println("[UDP Echo Client] error : " + e);
		}finally {
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
		
	}
	private static void log(String message) {
		System.out.println(message);
	}
}
