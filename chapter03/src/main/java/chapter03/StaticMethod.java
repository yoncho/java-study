package chapter03;

public class StaticMethod {

	int n;
	
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		m = 20; //m 이 누움, 같은 클래스의 static 변수(클래스 변수) 접근에서는 클래스 이름 생략 가능..
	}
	
	void f3()
	{
		f2();
		
	}
	
	void f4()
	{
		// static method 호출
		StaticMethod.s1();
		
		s1();
	}
	
	static void s1()
	{
		//error : static method에서 instance 변수 접근 불가능..
		//n = 10;
	}
	
	static void s2()
	{
		//error : static method에서 instance method 접근 불가능..
//		f1();
	}
	
	static void s3()
	{
		StaticMethod.m = 10;
		m = 10;
	}
	
	static void s4()
	{
		StaticMethod.s1();
		
		s1();
		
		//static -> only static
		//instance -> all
	}
}
