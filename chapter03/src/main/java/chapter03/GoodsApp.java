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
		System.out.println("상품 이름 : " + camera.getName() +
				"상품 가격 : " + camera.getPrice() +
				"재고 : " + camera.getCountStock() +
				"팔린 개수 : " + camera.getCountSold());
		
	}

}
