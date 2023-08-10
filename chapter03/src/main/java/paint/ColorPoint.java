package paint;

public class ColorPoint extends Point {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override //annotation [@] : 식별자 태그. 나중에 만들 수 있음. 
	public void show() {
		System.out.println("점[x=" + getX() +",y="+ getY() + ", color = " + color + "] 으로 그렸습니다.");
	}
	
	
	
}
