package geometry;

public class Rectangle {
	
	private Point upperLeft;
	private int width;
	private int height; 
	private boolean selected; 
	
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
	
	//metode
	
	public double area() {
		return width*height; 
	}
	
	public double circumference() {
		return 2*(width*height); 
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}
