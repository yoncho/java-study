package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		//순회1
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		
		//삭제	
		list.remove(2);
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		//순회3 Iterator가 존재하는 애들은 foreach문 과 같은 아래 코드를 구현 가능
		for(String i : list)
		{
			System.out.println(i);
		}// 단점 : index를 모름...
		
		
		
	}

}
