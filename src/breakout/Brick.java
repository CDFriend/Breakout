package breakout;

import java.awt.Color;
import processing.core.PApplet;

public class Brick {

	// size
	float width;
	float height;
	
	// where's mah brick?
	float x;
	float y;
	
	// brick color
	Color color;
	
	PApplet app;
	
	public Brick(PApplet pApp, float x, float y, float width, 
					float height) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
		
		this.app = pApp;
		
		color = new Color(  (int) app.random(255), // red
							(int) app.random(255), // green
							(int) app.random(255)); // blue
	}
	
	public void draw() {
		app.rectMode(app.CORNER);
		app.fill(this.color.getRGB());
		app.rect(this.x, this.y, this.width, this.height);
		app.fill(255);
	}
	
	
}
