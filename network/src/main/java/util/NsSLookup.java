package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NsSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			while(true)
			{
				System.out.print(">> ");
				String line = scanner.nextLine();
				
				//escape
				if("quit".equals(line)) {
					break;
				}
				InetAddress[] inds = InetAddress.getAllByName(line);
				
				for(InetAddress i : inds) {
					System.out.println(line + ":"+ i.getHostAddress());
				}
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}

}
