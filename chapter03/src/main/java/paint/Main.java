package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
		draw(point1);
		
//		point1.disappear();
		point1.show(false);
		
		Point point2 = new ColorPoint(); //up casting
	
		point2.setX(20);
		point2.setY(20);
		((ColorPoint)point2).setColor("red");
		draw(point2);
		
		Rect r = new Rect();
//		drawRect(r);
		draw(r); // upcasting
		
		Triangle triangle = new Triangle();
		draw(triangle);
		
		Circle circle = new Circle();
		draw(circle);
		
	
		draw(new GraphicText("hello workd"));
		
	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	public static void drawPoint(Point point){
//		point.show(true); //input param이 ColorPoint Type인 경우 ColorPoint의 Show()가 실행되니까 override
//	}
//	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
//	
	
//	public static void drawColorPoint(ColorPoint colorPoint){
//		colorPoint.show();
//	}
}
