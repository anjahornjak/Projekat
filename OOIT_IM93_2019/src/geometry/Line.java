package geometry;

public class Line {
	
	//obelezja
	
	private Point startPoint; 
	private Point endPoint; 
	private boolean selected; 

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
	
	//metode
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
