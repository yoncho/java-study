package chapter03;

public class Goods {
	
	public static int countOfGoods = 0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods()
	{
		//기본 생성자 - 작성안해도 알아서 생성해줌.
//		Goods.countOfGoods++; 원래..
		countOfGoods++; // 내부에서는 클래스 이름 생략 가능...!!
		
	}
	
	public Goods(int price)
	{
		//추가 생성자 - 추가생성자만 있을 경우 error/ 추가 생성자를 만들었을 경우, 사용자가 직접 기본 생성자를 추가해줘야함.
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		if (price < 0) {
			price = 0;
		}
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getCountStock() {
		return countStock;
	}



	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}



	public int getCountSold() {
		return countSold;
	}



	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}



	public void initGoodsInfo(String name, int price, int countStock, int countSold)
	{
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
	
	public void showInfo()
	{
		System.out.println("상품 이름 : " + name +
				"상품 가격 : " + price +
				"재고 : " + countStock +
				"팔린 개수 : " + countSold);
	}

	public int calcDiscountPrice(double discountRate) {
		// TODO Auto-generated method stub
		return (int) (price * discountRate);
	}
}
