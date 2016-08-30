/**
 * Created by Steven Hu on 2016-08-30.
 */
public abstract class Entity {
	public double x;
	public double y;
	public char symbol;
	public double speed;
	
	public Entity(double x, double y, char symbol) {
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}
	
	public int getX(){
		return (int)x;
	}
	public int getY(){
		return (int)y;
	}
	
}
