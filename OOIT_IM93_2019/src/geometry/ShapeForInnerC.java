package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ShapeForInnerC extends Shape {
	
	//obelezja

	protected Color innercolor; 
	
	//metode
	
	public abstract void fill (Graphics g);
	
	//geteri i seteri
	
	public Color getInnerColor() {
		return innercolor;
	}
	
	public void setInnerColor(Color innercolor) {
		this.innercolor = innercolor; 
	}
	
}
