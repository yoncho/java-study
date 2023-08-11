package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하게 되면 JVM의 힙 상에 객체가 존재하게 된다.
		//  리터럴을 사용하게 되면 JVM 안의 Constant Pool이 관리한다. 
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		
		// Auto Boxing 
		Integer j1 = 10; //10을 integer로 감싸줌.
		Integer j2 = 20;
		
		System.out.println(j1 == j2); // reference 비교  (동일성 비교)
		System.out.println(j1 < j2); //  auto unboxing - int의 value가 직접 나와 비교
		
		// Auto Unboxing
//		int m = j1.intValue() + 10;
		int m = j1 + 10; //j1의 실제 value가 나와 연산
		
		
		
	}

}
