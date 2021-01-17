package game.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.tools.ImageLoader;

public abstract class Car {
	
	protected double x;
	protected double y; //posisi mulai pemain
	protected double dx, dy;
	
	protected int width;
	protected int height;
	
	protected BufferedImage image;
	
	public Car(String pathImage) {
		image = ImageLoader.loadImage(pathImage);
		
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public double getX(){
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY(){
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

}
