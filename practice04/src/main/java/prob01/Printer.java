package prob01;

public class Printer {
//	public void println(int input) {
//		System.out.println(input);
//	}
//	public void println(boolean input) {
//		System.out.println(input);
//	}
//	public void println(double input) {
//		System.out.println(input);
//	}
//	public void println(String input) {
//		System.out.println(input);
//	}
	
	//GenericMethod안에서 사용할 type을 미리 지정..
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}	
	}
	
	//가변 parameter...?
	public int sum(Integer... nums) {
		int s = 0;
		for(Integer i : nums) {
			s+= i;
		}
		return s;
	}
	
//	public <T> void printlns(T o) {
//		System.out.println(o);
//	}
	
	public void printlns(Object o) {
		System.out.println(o);
	}
}
