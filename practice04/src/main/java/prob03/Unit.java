package prob03;

public abstract class Unit {
	protected int x;
	protected int y;
	
	abstract void move(int x, int y);
	abstract void stop();
}
