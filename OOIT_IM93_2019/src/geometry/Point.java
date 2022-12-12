package geometry;

public class Point {
	
	//obelezja
	
	private int x;
	private int y; 
	private boolean selected; 

	
	//konstruktori
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		
	}
	
	public Point(int x, int y, boolean selected) {
		
	}
	
	//metode
	
	public double distance(int x, int y) {
		int dX = this.x - x; 
		int dY = this.y - y; 
		double distance =  Math.sqrt(dX*dX + dY*dY); 
		return distance; 
	}
	
	//overrajdi
	
	@Override
	
	public String toString() { 
		return "(" + x + ", " + y + ")";
	}
	
	@Override
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point)obj; 
		if (x == temp.x && y == temp.y) {
			return true; }
		} return false; 
	}
	
	// geteri i seteri
	
	public int getX () {
		return x; 
	}
	
	public void setX (int x) {
		this.x = x; 
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y; 
	}
	
	public boolean getSelected () {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected; 
		
	}
}
