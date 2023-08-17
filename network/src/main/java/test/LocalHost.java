package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		
		try {
			InetAddress inetAddress =  InetAddress.getLocalHost(); //현재 pc의 ip정보
			String hostname = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();
			
			System.out.println(hostname) ;
			System.out.println(hostIpAddress);
			
			byte[] ipAddress = inetAddress.getAddress();
			
			for(byte byteData : ipAddress) {
				System.out.println(byteData & 0x000000ff);
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
