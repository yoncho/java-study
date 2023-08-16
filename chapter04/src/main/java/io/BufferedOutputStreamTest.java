package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림
			FileOutputStream fis = new FileOutputStream("hello.txt");
			
			// 보조 스트림
			bos = new BufferedOutputStream(fis);
			//사용법: bos = new BufferedOutputStream(new FileOutputStream("helloo.txt"));
			
			//for(int i = 'a'; i<= 'z'; i++)
			for(int i = 97; i <= 122; i++) {
				bos.write(i);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found:  " + e);
		} catch (IOException e) {
			System.out.println("File Not Found:  " + e);
		} finally {
			try {
				if(bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
