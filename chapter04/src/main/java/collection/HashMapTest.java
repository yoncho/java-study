package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> m = new HashMap<>();
		
		m.put("one", 1); // auto boxing
		
		m.put("two", 2); 
		m.put("three", 3);
		
		int i = m.get("one");
		int j = m.get(new String("one"));
		System.out.println(i + ":" + j);
		
		m.put("three", 3333); //값을 바꿈..
		System.out.println(m.get("three"));
		

		//순회 key가 set으로 들어가있음 중복x 들어간 순서대로 정렬 x
		Set<String> keys = m.keySet();		
		
		for(String key : keys)
		{
			System.out.println(m.get(key));
		}
		
	}
}
