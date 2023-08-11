package prob6;

public class RectTriangle extends Shape{
	
	public RectTriangle(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea()
	{
		return width * height * 0.5;
	}

	@Override
	double getPerimeter() {
		return width + height + Math.sqrt((width * width) + (height * height));
	}

	@Override
	public void resize(double size) {
		width = width * size;
		height = height * size;
	}
}