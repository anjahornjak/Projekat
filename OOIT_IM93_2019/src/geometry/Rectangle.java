package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends ShapeForInnerC {
	
	private Point upperLeft;
	private int width;
	private int height; 
	
	//konstruktori
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point uL, int w, int h) {
		this.upperLeft = uL; 
		this.width = w;
		this.height = h;
	}
	
	public Rectangle(Point uL, int w, int h, boolean s) {
		this.upperLeft = uL; 
		this.width = w;
		this.height = h;
		this.selected = s; 
	}
	
	public Rectangle (Point uL, int w, int h, boolean selected, Color color) {
		this(uL, w, h, selected);
		this.color = color;
	}
    
    public Rectangle(Point uL, int w, int h, Color color) {
    	this (uL, w, h);
    	this.color = color;
    }
    
    public Rectangle(Point uL, int w, int h,  Color color, Color innercolor) {
    	this (uL, w, h, color);
    	this.innercolor = innercolor;
    }
    
    public Rectangle(Point uL, int w, int h,  boolean selected, Color color, Color innerColor) {
    	this (uL, w, h, color, innerColor);
    	this.selected = selected;
    }
	
	//metode
	
	public double area() {
		return width*height; 
	}
	
	public double circumference() {
		return 2*(width*height); 
	}
	
	public boolean contains(int x, int y) {
		return upperLeft.getX() < x && upperLeft.getX() + width > x &&
				upperLeft.getY() < y && upperLeft.getY() + width > y; 		
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(),p.getY()); 
	}
	//overrajdi
	
	@Override
	
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}

	@Override
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if (upperLeft.equals(temp.upperLeft) && width == temp.width && height == temp.height) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		this.fill(g);
		if(isSelected()) {
			g.setColor(getColor());
	        g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
	        g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
	        g.drawRect(upperLeft.getX() - 2,upperLeft.getY() + height - 2, 4, 4);
	        g.drawRect(upperLeft.getX() + width - 2,upperLeft.getY() + height - 2, 4, 4);
		}
	}
	
	public void fill (Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.getUpperLeft().getX() + 1, this.getUpperLeft().getY() + 1, this.width - 1, this.height - 1);
	}
	
	@Override
	public void moveOn(int x, int y) {
		upperLeft.moveOn(x, y);
		
	}
	
	@Override
	public void moveBy(int dX, int dY) {
		this.upperLeft.moveBy(dX, dY);
	}
	
	@Override
	public int compareTo (Object o) {
		if (o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o; 
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	

	
	//geteri i seteri

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}
