package prob3;

import java.util.Scanner;

public class Prob3 {
	public static int sumCalculator(int start, int jumpWidth, int maxValue)
	{
		int result = 0;
		for(int i = start; i<= maxValue; i+=jumpWidth)
		{
			result += i;
		}
		return result;
	}
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요 : ");
		int inputValue = scanner.nextInt();
		int totalSum = 0;
		
		if(inputValue % 2 == 0)
		{
			totalSum = sumCalculator(0, 2, inputValue);
		}
		else
		{
			totalSum = sumCalculator(1, 2, inputValue);
		}
		
		System.out.println("결과 값 : "+ totalSum);
		scanner.close();
	}
}
