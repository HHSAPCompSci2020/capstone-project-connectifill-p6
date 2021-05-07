package rjayant.physicsShapeDemo;
import java.awt.Color;

import processing.core.PApplet;
import tli450.shapes.Circle;
import tli450.shapes.Line;
import tli450.shapes.Rectangle;


public class DrawingSurface extends PApplet {

	private Rectangle divider;

	
	
	public DrawingSurface() {
		divider = new Rectangle(387,0,25,800,Color.white,Color.white,1);
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void draw() {
		background(60,142,0);
		
		// DRAWING
		divider.draw(this);
		
	}
	
}
