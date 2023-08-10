package tv;


public class TV {
	//MIN, MAX VALUE
	static int MIN_CHANNEL = 1;
	static int MAX_CHANNEL = 255;
	static int MIN_VOLUME = 0;
	static int MAX_VOLUME = 100;
	
	private int channel; //단, 1~255 (overflow시 1로,, underflow시 255로)
	private int volume; //단, 0 ~ 100 (overflow시 0, underflow시 100)
 	private boolean power;
 	
 	public TV(int channel, int volume, boolean power) {
 		this.channel = channel;
 		this.volume = volume;
 		this.power = power;
 		
 	}
 	public int getChannel(){
 		return channel;
 	}
 	
 	public int getVolume() {
 		return volume;
 	}
 	
 	public void power(boolean on){
 		power = on;
 	}
 	
 	public void volume(boolean up) {
 		//current power check logic
 		if (power) {
 			int upCount = up ? 1 : -1;
 			this.volume = valueChanger(MIN_VOLUME, MAX_VOLUME, this.volume, upCount);
 		}
 		else {
 			exceptionPowerOff();
 		}
 		
 	}
 	
 	public void volume(int volume) {
 		if (power) {
 			if (volume < MIN_VOLUME)
 	 		{
 				this.volume = MAX_VOLUME;
 	 		}
 	 		else if(volume > MAX_VOLUME)
 	 		{
 	 			this.volume = MIN_VOLUME;
 	 		}
 	 		else
 	 		{
 	 			this.volume = valueChanger(MIN_VOLUME, MAX_VOLUME, this.volume, volume);
 	 		}
 			
 		}
 		else {
 			exceptionPowerOff();
 		}
 	}
 	
 	public void channel(int channel) {
 		if (power) {
 			if (channel < MIN_CHANNEL)
 	 		{
 				this.channel = MAX_CHANNEL;
 	 		}
 	 		else if(channel > MAX_CHANNEL)
 	 		{
 	 			this.channel = MIN_CHANNEL;
 	 		}
 	 		else
 	 		{
 	 			this.channel = valueChanger(MIN_CHANNEL, MAX_CHANNEL, this.channel, channel);
 	 		}
 		}
 		else {
 			exceptionPowerOff();
 		}
 	}
 	
 	public void channel(boolean up) {
 		if (power) {
 			int upCount = up ? 1 : -1;
 			this.channel = valueChanger(MIN_CHANNEL, MAX_CHANNEL, this.channel, upCount);
 		}
 		else {
 			exceptionPowerOff();
 		}
 	}
 	
 	public void status() {
 		System.out.println("TV[power = " + (power ? "on":"off") + 
 				", channel= " + getChannel() + ", volume= " + getVolume() + "]");
 	}
 	
 	public int valueChanger(int min, int max, int currentValue, int upCount)
 	{
 		int result;
 		int checkValue = currentValue + upCount;
	 		
	 	if(checkValue > max) {
	 		result = min;
	 	}else if (checkValue < min)
	 	{
	 		result = max;
	 	}
	 	else
	 	{
	 		result = checkValue;
	 	}
 		return result;
 	}
 	
 	public void exceptionPowerOff() {
 		System.out.println("TV가 꺼저 있습니다.");
 	}
}
