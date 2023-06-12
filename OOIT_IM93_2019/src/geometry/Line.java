package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	//obelezja
	
	private Point startPoint; 
	private Point endPoint; 

	//konstruktori
	
	public Line() {
		
	}
	
	public Line(Point start, Point end) {
		this.startPoint = start; 
		this.endPoint = end; 
	}
	
	public Line(Point start, Point end, boolean selected) {
		this.startPoint = start; 
		this.endPoint = end; 
		this.selected = selected; 
	}
	
	public Line(Point start, Point end, Color color) {
		this.startPoint = start; 
		this.endPoint = end; 
		this.color = color; 
	}
	
	public Line(Point start, Point end, boolean selected, Color color) {
		this.startPoint = start; 
		this.endPoint = end; 
		this.selected = selected; 
		this.color = color; 
	}
	
	
	//metode
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <=2; 
	}
	
	//overrajdi
	
	@Override
	
	public String toString() {
		return startPoint + " --> " + endPoint;
	}

	@Override
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line temp = (Line) obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}
	
	@Override
	public void moveOn(int x, int y) {
		int midX = (startPoint.getX() + endPoint.getX())/2; 
		int midY = (startPoint.getY() + endPoint.getY())/2; 
		int dx = x - midX; 
		int dy = y - midY; 
		this.startPoint.moveBy(dx, dy);
		this.endPoint.moveBy(dx, dy);
	}
	
	@Override
	public void moveBy(int dX, int dY) {
		this.startPoint.moveOn(this.startPoint.getX()+dX, this.startPoint.getY()+dY);
		this.endPoint.moveOn(this.endPoint.getX()+dX, this.endPoint.getY()+dY);
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor()); 
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
		if (isSelected()) {
			g.drawRect(startPoint.getX()-2, startPoint.getY()-2, 4, 4);
			g.drawRect(endPoint.getX()-2, endPoint.getY()-2, 4, 4);
		}
	}
	
	@Override
	public int compareTo (Object o) {
		if (o instanceof Line) {
			Line temp = (Line)o; 
			return ((int)(this.length() - temp.length()));
		}
		return 0;
	}
	
		
	//geteri i seteri

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	
}
