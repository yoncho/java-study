package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
		drawPoint(point1);
		
//		point1.disappear();
		point1.show(false);
		
		Point point2 = new ColorPoint(); //up casting
	
		point2.setX(20);
		point2.setY(20);
		((ColorPoint)point2).setColor("red");
		drawPoint(point2);
		
		Rect r = new Rect();
		drawRect(r);
	}

	public static void drawPoint(Point point){
		point.show(true); //input param이 ColorPoint Type인 경우 ColorPoint의 Show()가 실행되니까 override
	}
	
	public static void drawRect(Rect rect) {
		rect.draw();
	}
	
//	public static void drawColorPoint(ColorPoint colorPoint){
//		colorPoint.show();
//	}
}
