package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// 불변성 (immutability)- (String의 모든 Method들은 내부를 변경시키지 않음)
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase(); // s1의 객체 class에 toUpperCase가 
		// 외부에 객체를 하나 생성하고 s1이 참조하는 data를 가져와 대문자로 변경한 뒤 외부 객체에 넣어놓고 return
		// 그게 s2가 참조하게됨.  (s2는 s1의 toUpperCase가 생성한 외부 대문자 객체를 참조하게됨)
		
		String s4 = s2.concat("??"); // concat : 입력원을 타겟 객체 뒤에 붙이는 함수
		// 외부 객체를 만들어서 this (s2)를 하나 씩 옮기고 객체 뒤에 parameter(??)를 붙이고 
		// return한걸 s4가 받음 (return 되면서 method를 탈출하고, 동작 관련 method를 메모리에서 지움)
		
		
		//한번만 쓰고 말꺼면 아래처럼,, 하지만 그게 아니기 때문에 객체를 만들어서 레퍼런스하게 해야함.
		String s5 = "!".concat(s2).concat("@");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("Hello"));
		System.out.println(equalsHello(null));
	}
	
	private static boolean equalsHello(String s)
	{
		return "Hello".equals(s);
	}
	

}
