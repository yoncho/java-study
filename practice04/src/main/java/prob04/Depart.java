package prob04;

public class Depart extends Employee {
	private String department;
	
	public Depart(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	public void getInformation() {
		System.out.println("이름: "+ super.getName()
						+ "\t연봉: " + super.getSalary()
						+ "\t부서 : " + department);
	}
}
