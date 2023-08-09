package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods camera = new Goods();
		
		camera.name = "nikon";
		camera.price = 400000;
		camera.countSold = 50;
		camera.countStock = 30;
//		camera.initGoodsInfo("nikon", 400000, 0, 0);
		
		System.out.println("상품이름 : " + camera.name + " 가격 : " + camera.price
				+ " 재고 개수 : " + camera.countStock + " 팔린 개수 : " + camera.countSold);
	}

}
