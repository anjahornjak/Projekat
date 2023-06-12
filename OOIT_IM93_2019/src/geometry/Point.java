package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape implements Movable {
	
	//obelezja
	
	private int x;
	private int y; 

	
	//konstruktori
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x; 
		this.y = y; 
		
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y); 
		setSelected(selected);
		
	}
	
	//konstruktori za boje 
	
	
	public Point (int x, int y, boolean selected, Color color) {
		this(x,y); 
		setSelected(selected);
		setColor(color); 
		
	}
	
	//metode
	
	public double distance(int x, int y) {
		int dX = this.x - x; 
		int dY = this.y - y; 
		double distance =  Math.sqrt(dX*dX + dY*dY); 
		return distance; 
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <=2; 
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
	
	@Override
	
	public void draw(Graphics g) {
		g.setColor(getColor()); 
		g.drawLine(this.x - 2, this.y , this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y +2);
		
		if (isSelected()) {
			g.drawRect(this.x - 4, this.y - 4, 8, 8); 
		}
	}
		
	@Override
	public void moveOn (int x, int y) { 
		this.x = x; 
		this.y = y; 
		
	}
	
	@Override
	public void moveBy (int dx, int dy) {
		this.x = this.x + dx; 
		this.y = this.y + dy; 
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point temp = (Point)o;
			return ((int)(this.distance(0, 0) - temp.distance(0, 0)));
		}
		return 0;
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

}
