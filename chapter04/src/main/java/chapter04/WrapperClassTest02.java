package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		
		String s = "123456";
		int i = Integer.parseInt(s); // wrapper class `s static method
		
		// cf1 반대로
		String s1 = String.valueOf(i);
		
		// cf2 반대로
		String s2 = "" + i; // string buffer가 생겨 cost가 높음.
		
		System.out.println(s + " : " + s1 + " : " + s2);
		
		int a = Character.getNumericValue('A'); //16진수 -> 10진수
		System.out.println(a);
		
		// cf ascii 코드값
		System.out.println((int)'A');
		
		// 2진수 binary
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		// 16진수 
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}

}
