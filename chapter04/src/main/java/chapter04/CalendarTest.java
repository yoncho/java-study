package chapter04;

import java.awt.print.Book;
import java.util.Calendar;

public class CalendarTest { //class앞에 final을 하게되면 더 이상 상속을 해줄 수 없음. 즉 자식 class 생성 불가
	public final void m() {
		//변수 앞에 붙으면 데이터 변경 x
		// 함수 앞에 붙으면 override 불가
		// class 앞에 붙으면 자식 class한테 상속 불가
	}
	
	
	
	public static void main(String[] args) {
		//팩토리 메소드, instance를 만듦.
		Calendar cal = Calendar.getInstance(); //getInstance가 내부에서 instance를 만들어반환 (이를 팩토리 메소드라 함)
		
		int i = 10;
		i = 10 + 9; //변수, 변할 수 있는 수
		
		final int i2 = 10; //상수, 선언과 함께 초기화 시킨 이후 값을 변경할 수 없음.
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		cal.set(2024, 11, 25);
		cal.add(Calendar.DATE, 10000);
		printDate(cal);

	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0~ 11. +1( 넣을 떈 -1)
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1~7 나옴 (1: 일, 7: 토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println((year) +"/"+(month +1) +"/"+date
				+" " + DAYS[day-1] + "요일 " +hour +":"+minute +":"+second);
	}
	
	
	

}
