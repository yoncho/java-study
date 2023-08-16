package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		
		q.offer("둘리"); //push
		q.offer("마이콜"); 
		q.offer("또치");
		
		while(!q.isEmpty()) {
			System.out.println(q.poll()); // poll = pop같은..
		}
		
		q.offer("둘리"); //push
		q.offer("마이콜"); 
		q.offer("또치");
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		// 비어있는 경우 null 반환.
		System.out.println(q.poll());
	}

}
