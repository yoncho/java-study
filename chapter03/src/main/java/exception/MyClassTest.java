package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		 try {
			MyClass myClass = new MyClass();
			myClass.danger();
		} 
//		 catch (IOException e) {
//			e.printStackTrace();
//		} catch(MyException e) {
//			e.printStackTrace();
//		} 
		 catch (Exception e) { //모든 exception은 여기서.. 
			e.printStackTrace();
		}
		
	}

}
