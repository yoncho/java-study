package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
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
			//1. 기반 스트림 (표준입력. stdin, System.in)
			FileInputStream fis = new FileInputStream(f);
			
			//2. 보조 스트림1 (bytes -> char) 
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			//3. 보조 스트림2 (chars |\n| -> string)
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index == 0) {//name
						System.out.print(token+ ":");
					} else if(index == 1 || index == 2) { //phone number
						System.out.print(token + "-");
					} else {
						System.out.print(token);
					}
					index++;
				}
				System.out.println("");
			}
			
		}catch(UnsupportedEncodingException e) {
			System.out.println("Error : " + e);
		}catch(IOException e) {
			System.out.println("Error : " + e);
		}finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
