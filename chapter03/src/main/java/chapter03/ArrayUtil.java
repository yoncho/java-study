package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] input) {
		// TODO Auto-generated method stub
		double[] d = new double[input.length];
		
		for(int i = 0; i < input.length; i++)
		{
			d[i] = input[i];
		}
		return d;
	}

	public static int[] doubleToInt(double[] ds) {
		// TODO Auto-generated method stub
		int[] a = new int[ds.length];
		
		for(int i = 0; i < ds.length; i++)
		{
			a[i] = (int)ds[i];
		}
		return a;
	}

	public static int[] concat(int[] is, int[] is2) {
		// TODO Auto-generated method stub
		int[] a = new int[is.length + is2.length];
		
		for(int i = 0 ; i < is.length + is2.length; i++)
		{
			//
		}
		return null;
	}
	
}
