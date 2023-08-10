package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s = new Student();
		Person p = s; // upcasting (암시적, implicity)
		
		Student s1 = (Student)p; //downcasting (명시적, explicity)
		
	}

}
