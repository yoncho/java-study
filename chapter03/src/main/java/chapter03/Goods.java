package chapter03;

public class Goods {
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public void initGoodsInfo(String name, int price, int countStock, int countSold)
	{
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}
}
