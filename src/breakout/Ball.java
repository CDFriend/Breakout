package breakout;

import processing.core.PApplet;

public class Ball {

	// how big is the ball?
	public float size;

	// position of the ball
	public float x;
	public float y;

	// speed of the ball
	public float speedX;
	public float speedY;

	public PApplet app;
	public Player player;

	public Ball(PApplet pApp, Player player, float x, float y, float size, float speedX, float speedY) {
		this.x = x;
		this.y = y;
		this.size = size;

		this.speedX = speedX;
		this.speedY = speedY;

		this.app = pApp;
		this.player = player;
	}

	public void move() {

		// check for a bounce
		if (this.isTouchingSideWall() == true) {
			this.speedX = -this.speedX;
		}
		if (this.isTouchingFrontWall() == true) {
			this.speedY = -this.speedY;
		}
		if (this.isTouchingPlayer(this.player)) {
			this.speedY = -this.speedY;
		}

		this.x += speedX;
		this.y += speedY;
	}

	public void draw() {
		app.ellipse(x, y, size, size);
	}

	public boolean isTouchingPlayer(Player p) {
		boolean isLeftSideOverPaddleX = this.x - this.size / 2 > p.x - p.width / 2
				&& this.x - this.size / 2 < p.x + p.width / 2;

		boolean isRightSideOverPaddleX = this.x + this.size / 2 > p.x - p.width / 2
				&& this.x + this.size / 2 < p.x + p.width / 2;

		boolean isOverPaddleX = isLeftSideOverPaddleX || isRightSideOverPaddleX;

		boolean isTopSideOverPaddleY = this.y - this.size / 2 > p.y - p.height / 2
				&& this.y - this.size / 2 < p.y + p.height / 2;

		boolean isBottomSideOverPaddleY = this.y + this.size / 2 > p.y - p.height / 2
				&& this.y + this.size / 2 < p.y + p.height / 2;

		boolean isOverPaddleY = isTopSideOverPaddleY || isBottomSideOverPaddleY;

		return isOverPaddleX && isOverPaddleY;
	}

	public boolean isTouchingBrick(Brick b) {

		boolean isLeftSideOverPaddleX = this.x - this.size / 2 > b.x
				&& this.x - this.size / 2 < b.x + b.width;

		boolean isRightSideOverPaddleX = this.x + this.size / 2 > b.x
				&& this.x + this.size / 2 < b.x + b.width;

		boolean isOverPaddleX = isLeftSideOverPaddleX || isRightSideOverPaddleX;

		boolean isTopSideOverPaddleY = this.y - this.size / 2 > b.y
				&& this.y - this.size / 2 < b.y + b.height;

		boolean isBottomSideOverPaddleY = this.y + this.size / 2 > b.y
				&& this.y + this.size / 2 < b.y + b.height;

		boolean isOverPaddleY = isTopSideOverPaddleY || isBottomSideOverPaddleY;

		return isOverPaddleX && isOverPaddleY;

	}

	public boolean isTouchingFrontWall() {
		if (this.y <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTouchingSideWall() {
		if (this.x >= app.width) {
			return true;
		} else if (this.x <= 0) {
			return true;
		} else {
			return false;
		}
	}

}
