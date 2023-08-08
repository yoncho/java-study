package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int startValue = 1;
		int maxValue = 100;
		
		while(startValue <= maxValue)
		{
			int remainder = startValue % 10;
			if (remainder != 0 && remainder % 3 == 0)
			{
				System.out.println(startValue + " 짝");
			}
			startValue++;
		}
	}
}
