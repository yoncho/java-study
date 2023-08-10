package tv;

public class TV {
	private int channel; //단, 1~255 (overflow시 1로,, underflow시 255로)
	private int volume; //단, 0 ~ 100 (overflow시 0, underflow시 100)
 	private boolean power;
 	
 	public TV() {
 		
 	}
 	
 	public void power(boolean on){
 		power = on;
 	}
 	
 	public void volume(boolean up) {
 		//current power check logic
 	}
 	
 	public void volume(int volume) {
 		this.volume = volume;
 	}
 	
 	public void channel(int channel) {
 		this.channel = channel;
 	}
 	
 	public void channel(boolean up) {
 		
 	}
 	
 	public void status() {
 		System.out.println("TV[power = " + (power ? "on":"off") + 
 				", channel= " + channel + ", volume= " + volume + "]");
 	}
 	
 	
 	
}
