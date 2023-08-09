package prob02;

import java.util.Arrays;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;
	public static class Goods{
		private String goodsName;
		private int goodsPrice;
		private int goodsInputCount;
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public int getGoodsPrice() {
			return goodsPrice;
		}
		public void setGoodsPrice(int goodsPrice) {
			this.goodsPrice = goodsPrice;
		}
		public int getGoodsInputCount() {
			return goodsInputCount;
		}
		public void setGoodsInputCount(int goodsInputCount) {
			this.goodsInputCount = goodsInputCount;
		}
		public void printGoodsInfo()
		{
			System.out.println(getGoodsName() +"(가격:"
					+ getGoodsPrice() +"원)이 "
					+ getGoodsInputCount()+"개 입고 되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		// 상품 입력
		System.out.println("실행 결과:");
		for(int i = 0; i < COUNT_GOODS; i++)
		{
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			goods[i] = new Goods();
			goods[i].setGoodsName(infos[0]);
			goods[i].setGoodsPrice(Integer.parseInt(infos[1]));
			goods[i].setGoodsInputCount(Integer.parseInt(infos[2]));
		}
		
		// 상품 출력
		
		for(int i = 0; i < COUNT_GOODS; i++)
		{
			goods[i].printGoodsInfo();
		}
		// 자원정리
		scanner.close();
	}
}
