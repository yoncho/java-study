package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("hello.txt");
			
			int data = fs.read();
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
			System.out.println("error:"+e);
		} catch (IOException e)
		{
			System.out.println("error:"+e);
		}finally{
			try {
				if(fs != null) fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
