package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods();
		
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountSold(0);
		camera.setCountStock(0);
		
		//정보 은닉 (데이터보호)
		camera.setPrice(-1);
		
		
		//countOfGoods 테스트
		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		camera.initGoodsInfo("nikon", 400000, 0, 0);

		camera.showInfo();
		camera.setPrice(500000);
		int discountPrice = camera.calcDiscountPrice(0.5);
		
		System.out.println(discountPrice);
		
		
		
	}

}
