package mypackage;

public class DescountGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	
	public int getDiscountPrice() {
		//protected인 price는 상속해서 자식에서 접근이 가능하다.
		return (int)(discountRate * price);
	}
}
