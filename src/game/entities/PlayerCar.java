package game.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.tools.ImageLoader;

public class PlayerCar {
	private double x = 300;
	private double y = 535; //posisi mulai pemain
	private double dx, dy;
	
	private int width;
	private int height;
	
	private BufferedImage image;
	
	public PlayerCar() {
		image = ImageLoader.loadImage("/res/car1.png");
		
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int)x, (int)y, width, height);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
