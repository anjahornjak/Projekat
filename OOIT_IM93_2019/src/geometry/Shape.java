package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Movable, Comparable {
	
	//obelezja
	
	protected boolean selected; 
	protected Color color; 
	
	
	//konstruktori
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
	this.selected = selected; 
		
	}
	
	public Shape (boolean selected, Color color) {
		this(selected);
		this.color = color; 
		
	}
	
	//metode
	
	public abstract boolean contains(int x, int y);
	
	public abstract void draw (Graphics g);
	

	//getters & setters

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Color getColor() {
		return this.color; 
	}
	
	public void setColor(Color color) {
		this.color = color; 
	}

}
