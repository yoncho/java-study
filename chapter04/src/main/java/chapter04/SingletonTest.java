package chapter04;

public class SingletonTest {

	public static void main(String[] args) {
		
		//Singleton 구현  (팩토리 메소드)
		Singleton singleton1 = Singleton.getInstance();
		
		Singleton singleton2 = Singleton.getInstance();
		Singleton singleton3 = Singleton.getInstance();
		
		System.out.println(singleton1 == singleton2);
		// singleton으로 두 인스턴스의 레퍼런스값이 동일,,!!
		// spring으로 관리하는 객체들이 거의 다 싱글톤!
	}

}
