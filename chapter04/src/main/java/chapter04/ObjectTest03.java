package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
//		String s1 = "hello";
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2); //동일성 reference 비교는 다른 객체이므로 false
		System.out.println(s1.equals(s2)); //동질성
		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		
		//주소 기반의 hash값
		System.out.println(System.identityHashCode(s1) + " : " + System.identityHashCode(s2));
		
		
		System.out.println("=======================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s4); //동일성 reference 비교는 다른 객체이므로 false
		System.out.println(s3.equals(s4)); //동질성 value가 동일한지..
		System.out.println(s3.hashCode() + " : " + s4.hashCode());
		
		//주소 기반의 hash값
		System.out.println(System.identityHashCode(s3) + " : " + System.identityHashCode(s4));
		
	}

}
