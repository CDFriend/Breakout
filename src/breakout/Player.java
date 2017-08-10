package breakout;

import processing.core.PApplet;

public class Player {
	
	// player position
	float x;
	float y;
	
	// paddle size
	float width;
	float height;
	
	// Processing app!
	PApplet app;
	
	public Player(PApplet pApp, float startX, float startY, 
					float width, float height) {
		
		// start position
		this.x = startX;
		this.y = startY;
		
		// paddle size
		this.width = width;
		this.height = height;
		
		this.app = pApp;
		
	}
	
	public void move() {
		this.x = app.mouseX;
	}
	
	public void draw() {
		app.rectMode(app.CENTER);
		app.rect(this.x, this.y, this.width, this.height);
	}
	
}
