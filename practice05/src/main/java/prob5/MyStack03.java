package prob5;

public class MyStack03<T>{ //와일드카드 *... *... 제한자도 있음. 누구의 자식 class만 넣어라..등
	private T[] str;
	private int currentTop;
			
	public MyStack03(int n)
	{
		this.str = (T[])new Object[n]; //Casting..
		this.currentTop = 0;
	}

	public void push(T data)
	{
		str[currentTop] = data;
		currentTop++;
		if(currentTop >= str.length)
		{
			str = bufferSetSize(str);
		}
	}
	
	public T pop() throws MyStackException
	{
		currentTop--;
		if(currentTop < 0)
		{
			throw new MyStackException();
		}
		T popData = str[currentTop];
		
		return popData;
	}
	
	public boolean isEmpty()
	{
		if (currentTop == 0)
		{
			return true;
		}
		return false;
	}
	
	public T[] bufferSetSize(T[] data)
	{
		T[] s = (T[])new Object[data.length * 2];
		
		for(int i = 0; i < data.length; i++)
		{
			s[i] = data[i];
		}
		
		return s;
	}
}