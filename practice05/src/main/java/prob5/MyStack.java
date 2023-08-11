package prob5;

public class MyStack{
	private String[] str;
	private int currentTop;
	
	
	public MyStack(int n)
	{
		this.str = new String[n];
		this.currentTop = 0;
	}

	public void push(String data)
	{
		str[currentTop] = data;
		currentTop++;
		if(currentTop >= str.length)
		{
			str = bufferSizeUp(str);
		}
	}
	
	public String pop() throws MyStackException
	{
		currentTop--;
		if(currentTop < 0)
		{
			throw new MyStackException();
		}
		String popData = str[currentTop];
		
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
	
	public String[] bufferSizeUp(String[] data)
	{
		String[] s = new String[data.length * 2];
		
		for(int i = 0; i < data.length; i++)
		{
			s[i] = data[i];
		}
		
		return s;
	}
}