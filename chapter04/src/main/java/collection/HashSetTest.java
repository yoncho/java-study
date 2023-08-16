package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		System.out.println(s1 == s2);
		System.out.println(s1.hashCode() == s2.hashCode());
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1); //hash? 
//		s.add(s2); //중복된 값으로 취급하는구나... hashCode 비교!! 
		
		//두개가 같은 객체 literal (string constant pool에 저장됨.)
//		String s1 = "또치";
//		s.add("또치");
		
		System.out.println(s.size());
		System.out.println(s.contains(s2));
		//값 기반!! hashCode  
		
		//순회1
		for(String str : s)
		{
			System.out.println(str);
		}
		
		//삭제
		
		
	}

}
