package chapter03;

import mypackage.Goods2;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		
		goods.name = "test";
		
		// protected : 더 중요한 접근 제어는 자식에서 접근 가능하다.
//		goods.countSold = 1;
//		goods.price = 1000;
	}
}
