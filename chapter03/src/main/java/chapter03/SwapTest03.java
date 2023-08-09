package chapter03;

import mypackage.Value;

public class SwapTest03 {
	
	public static void swap(Value a, Value b)
	{
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}
	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);
		
		System.out.println("a= " + a.val + " , b= " + b.val);
//		int temp = a;
//		a = b;
//		b = temp;
		
		//call by reference (call by value) 
		swap(a, b);
		
		System.out.println("a= " + a.val + " , b= " + b.val);
		
	}
}
