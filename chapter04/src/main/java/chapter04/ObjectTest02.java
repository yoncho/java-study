package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		
		// == : 두 객체의 동일성 
		System.out.println(p1 == p2); // 레퍼런스 값 다름, 참조 객체도 다름
		System.out.println(p2 == p3); // 레퍼런스 값 같고 같은 객체를 참조
		
		// equals : 두 객체의 동질성 (내용비교)
		//		  : 부모 클래스 Object의 기본 구현은 동일성 (==) 비교와 같다.
		System.out.println(p1.equals(p2)); //false? equals가 결국 동일성 비교
		System.out.println(p2.equals(p3)); //true
		//equals는 기본적으로 동일성 비교이므로 우리가 override해서 변경해야함.
		
		
		
		
	}

}
