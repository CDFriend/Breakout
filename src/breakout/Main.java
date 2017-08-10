package breakout;

import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {
	
	// The player's paddle
	Player p;
	
	// The ball
	Ball ball;
	
	ArrayList<Brick> bricks;
	
	// info about our bricks
	public final float BRICK_HEIGHT = 15;
	public final float BRICK_WIDTH = 60;
	public final int NUMBER_OF_ROWS = 3;

	public static void main(String[] args) {
		PApplet.main("breakout.Main");
	}
	
	public void settings() {
		size(500, 500);
	}
	
	public void setup() {
		// Make our player object
		p = new Player(this, this.width / 2, this.height - 25, 
						60, 10);
		
		// Make our ball object
		ball = new Ball(this, p, this.width / 2, this.height - 37, 12,
						5, -6);
		
		// generate our bricks
		bricks = new ArrayList<Brick>();
		
		for (int row = 0; row < NUMBER_OF_ROWS; row += 1) {
			
			for (int x = 0; x < width; x += BRICK_WIDTH) {
				
				Brick b = new Brick(this, x, row * BRICK_HEIGHT,
									BRICK_WIDTH, BRICK_HEIGHT);
				bricks.add(b);
				
			}
			
		}
				
	}
	
	public void draw() {
		background(255);
		
		for (Brick b : bricks) {
			b.draw();
		}
		
		// check whether or not we've hit a brick
		for (int i = 0; i < bricks.size(); i += 1) {
			Brick b = bricks.get(i);
			if (ball.isTouchingBrick(b)) {
				ball.speedY = -ball.speedY; // bounce!
				bricks.remove(b);
			}
		}
		
		p.move();
		p.draw();
		
		ball.move();
		ball.draw();
	}

}
