package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	/* 코드 작성 */
	public Person() {
		this(12, "");
	}
	public Person(String name)
	{
		this();
		this.name = name;
	}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}
	
	public void selfIntroduce()
	{
		System.out.println("내 이름은 " + this.name + "이며, 나이는 " + this.age + "살입니다.");
	}
	
	static public int getPopulation() {
		return numberOfPerson;
	}
}
