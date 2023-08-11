package prob6;

public class Rectangle extends Shape{

	public Rectangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void resize(double s) {
		
		width = width * s;
		height = height * s;
	}

	@Override
	double getArea() {
		
		return width * height;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return (width + height) * 2;
	}
	
	

}
