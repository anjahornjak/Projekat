package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends ShapeForInnerC {
	
	//obelezja
	
	protected Point center; 
	protected int r; 
	
	//konstruktori
	
	public Circle() {

	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.r = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		setInnerColor(innerColor);
	}
		
	//metode
		
	public double circumference() {
		return 2*r*Math.PI; 
		
	}
	
	public double area() {
		return r*r*Math.PI; 
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) >= r;
	}
	
	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <=r; 
	}
	
	
	//overrajdi
	
	@Override
	
	public String toString() {
		return "Center: " + center + ", radius: " + r;
	}

	@Override
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if (center.equals(temp.center) && r == temp.r) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - r	 + 1, this.center.getY() - r + 1, r*2 - 2, r*2 - 2);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(this.center.getX() - r	, this.center.getY() - r, r*2, r*2); 
		this.fill(g);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - r - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() + r - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() - r - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() + r - 3, 6, 6);
		}
		
	}
	
	
	@Override
	public void moveOn(int x, int y) {
		center.moveOn(x, y);
		
	}

	@Override
	public void moveBy(int dX, int dY) {
		center.moveBy(dX, dY);
		
	}
	
	@Override
	public int compareTo (Object o) {
		if (o instanceof Circle) {
			Circle temp = (Circle)o; 
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	
	//geteri i seteri
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}