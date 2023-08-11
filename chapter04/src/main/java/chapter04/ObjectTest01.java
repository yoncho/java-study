package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
//		Class klass = point.getClass();  // reflection 
		System.out.println(point.getClass());
		
		//object 안에는 getClass()가 있다..
		System.out.println(point.hashCode()); // address x....아님!!
											  // reference x
											  // address 기반의 해싱값 ok!!
		System.out.println(point.toString()); // getClass() + "@" + hashCode()			
		System.out.println(point);
		
		
		
		
	}

}
