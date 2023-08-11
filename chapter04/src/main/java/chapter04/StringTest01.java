package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:/temp
		System.out.println("c:\\temp");
		
		
		// "Hello"
		System.out.println("\"Hello\"");
		
		// control character
		// \t : tab
		// \n : 개행 new line
		// \\ : '\' 표시
		// \r : carriage return (커서 위치를 변경)
		// println의 ln은 '\r\n'을 의미. 정통 unix 스타일
		//  			 '\n' 은 window 스타일
		// \b : bell (pc내장 speaker 울리는)
		
		// '
		
		char c = '\'';
		System.out.println(c);
		
		String path = "c:/User/yoncho/test.txt";
		//unix path = "/User/yoncho/test.txt"; 로 접근해야함.
	}

}
