package chapter04;

public class Singleton{
	private static Singleton instance;
	
	private Singleton() {
		//못 만들게 변경..?
	};
	
	public static Singleton getInstance() {
		if (instance == null)
		{
			instance = new Singleton();
		}
		return instance;
	}
	
}
