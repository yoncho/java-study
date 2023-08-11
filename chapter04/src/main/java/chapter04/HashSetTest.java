package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		//set은 중복 없는 (hash 중복이 없는) 항목
		Set<Rect> set = new HashSet<>();
		
		Rect r1 = new Rect(10,20);
		Rect r2 = new Rect(10,20);
		Rect r3 = new Rect(4,50);
		
		set.add(r1);
		set.add(r2);
		set.add(r3);
		//  ':' 기준으로 오른쪽은 컬렉션, 왼쪽은 컬렉션에서 하나씩 빼온 객체
		for(Rect r : set) {
			System.out.println(r);
		}
		
	}
}
