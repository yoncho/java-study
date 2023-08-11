package prob6;

public abstract class Shape implements Resizable{
	protected double width;
	protected double height;
	
	abstract double getArea();
	abstract double getPerimeter();
}
