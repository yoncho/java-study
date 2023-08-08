package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {
	public static int k;
	public static int rangeMin;
	public static int rangeMax;
	public static int tryCount;
	public static boolean isSuccess;
	
	public static void initSetting()
	{
		Random r = new Random();
		k = r.nextInt(100) + 1;
		tryCount = 0;
		rangeMin = 1;
		rangeMax = 100;
		isSuccess = false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		initSetting();
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		
		while(!isSuccess)
		{
			tryCount++;
			System.out.print(rangeMin+"-"+rangeMax+"\n" + tryCount + ">>");
			int inputValue = scanner.nextInt();
			
			if (inputValue == k)
			{
				System.out.println("맞았습니다.\n다시하시겠습니까(y/n)>>");
				char inputAsk = scanner.next().charAt(0);
				if(inputAsk == 'y' || inputAsk == 'Y')
				{
					initSetting();
				}
				else
				{
					isSuccess = true;
				}
			}
			else if (inputValue > k)
			{
				System.out.println("더 낮게\n");
				rangeMax = inputValue;
			}
			else
			{
				System.out.println("더 높게\n");
				rangeMin = inputValue;
			}
		}
		
		scanner.close();
	}
}
