package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("phone.txt");
		if(!f.exists())
		{
			System.out.println("File Not Found");
			return;
		}
		
		System.out.println("===========파일정보===========");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.length() + "bytes");
		Long timestamp = f.lastModified();
		Date d =  new Date(timestamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		System.out.println(sdf.format(d));

		System.out.println("===========전화번호============");
		
		Scanner scanner = new Scanner(f);
		
		String line = null;
		//Scanner는 tokenizer가 이미 있음.
		while(scanner.hasNextLine()) {
			String name = scanner.next();
			String phone1 = scanner.next();
			String phone2 = scanner.next();
			String phone3 = scanner.next();
			
			System.out.println(name + ":" + phone1+"-"+phone2+"-"+phone3);
		}
		scanner.close();
		
	}

}
