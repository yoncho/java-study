package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] d =  ArrayUtil.intToDouble(new int[]{10, 20, 30 ,40});
		System.out.println(Arrays.toString(d)); //reference값이 찍힘
		
		int[] a = ArrayUtil.doubleToInt(new double[] {10.0, 11.0, 12.0});
		System.out.println(Arrays.toString(a));
	}

}
