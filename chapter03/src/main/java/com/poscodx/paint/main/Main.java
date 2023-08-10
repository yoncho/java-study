package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.*;
import com.poscodx.paint.shape.*;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

import com.poscodx.paint.*;
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
		
		
		// instanceof 연산자 test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
//		System.out.println(circle instanceof Rect); error : 연산자 우측항이 클래스인 경우, 레퍼런스 하고 있는 클래스 타입의 hierachy 상의 하위와 상위만 instanceof 연산자를 사용할 수 있다.
		
		
		// 구현 여부  interface
		// 연산자 우측항이 interface인 경우, 상관없음
		// hierachy 상관없이 Instanceof 연산자 사용 가능.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
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
