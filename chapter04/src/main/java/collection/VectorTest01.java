package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
//collection framework 출시 이전에 사용되었던 vector 방법 : 이렇게 사용 x
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너");
		
		//순회1
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.elementAt(i));
		}
//		
//		for(String i : v) {
//			System.out.println(i);
//		}
//		
		//삭제
		v.removeElementAt(2);
		System.out.println("=================");
		
		//순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement()); 
		}
	}
}
