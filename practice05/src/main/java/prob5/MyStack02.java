package prob5;

public class MyStack02{
	private Object[] str;
	private int currentTop;
	
	
	public MyStack02(int n)
	{
		this.str = new Object[n];
		this.currentTop = 0;
	}

	public void push(Object data)
	{
		str[currentTop] = data;
		currentTop++;
		if(currentTop >= str.length)
		{
			str = bufferSetSize(str);
		}
	}
	
	public Object pop() throws MyStackException
	{
		currentTop--;
		if(currentTop < 0)
		{
			throw new MyStackException();
		}
		Object popData = str[currentTop];
		
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
	
	public Object[] bufferSetSize(Object[] data)
	{
		Object[] s = new Object[data.length * 2];
		
		for(int i = 0; i < data.length; i++)
		{
			s[i] = data[i];
		}
		
		return s;
	}
}