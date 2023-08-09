package mypackage;

public class Goods2 {
	public String name;     // 모든 접근이 가능하다. (접근 제한 없
	protected int price;   // 같은 패키지 + 자식 클래스에서 접근 가능
	private int countStock; // 클래스 내부에서만 가능
	int countSold;			// 같은 패키지
	
	public void m(int n)
	{
		this.countStock = n;
	}
}
