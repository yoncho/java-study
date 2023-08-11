package chapter04;

import java.util.Objects;

public class Rect {
	private int width;
	private int height;
	
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	
	//hashCode를 override해서 원하는 방식으로 hash를 생성하게 변경
	// ex) 넓이가 같은 애들은 같은 해쉬가 나오게 하려면 height * width를 넘겨줘야함.
	@Override
	public int hashCode() {
		return Objects.hash(height * width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		return height * width == other.height * other.width;
	}



	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + "]";
	}
	
}
