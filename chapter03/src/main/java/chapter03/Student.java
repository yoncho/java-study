package chapter03;

public class Student extends Person {
	public Student() {
		// 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면,
		//여기에 Person() 생성자가 없다면 자동 생성
		//자동으로 부모의 기본 생성자를 자식 생성자 코드 맨 앞!! 에 위치 해야함!
		super(); // 부모 객체 호출을 위해 super() 사용..
//		super(0); // 다른 생성자를 호출해야할 경우 단 부모 생성자는 단 1개만 존재 할 수 있음.
		System.out.println("Student() called");
		super.Walk(); // 부모 class의 Walk()함수 호출
	}
}