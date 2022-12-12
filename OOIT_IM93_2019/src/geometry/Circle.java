package geometry;

public class Circle {
	
	//obelezja
	
	private Point center; 
	private int r; 
	private boolean selected; 
	
	//konstruktori
	
	public Circle() {

	}
	
	public Circle(Point center, int r) {
		this.center = center; 
		this.r = r; 
	}
	
	public Circle(Point center, int r, boolean selected) {
		this.center = center; 
		this.r = r; 
		this.selected = selected; 
		
	}
		
	//metode
		
	public double circumference() {
		return 2*r*Math.PI; 
		
	}
	
	public double area() {
		return r*r*Math.PI; 
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}