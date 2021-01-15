package game.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.tools.ImageLoader;

public abstract class OpponentCar {
	
	protected BufferedImage image;
	int x;
	int y;
	int dx;
	protected int area = 15;
	protected boolean visible = true;
	protected int width;
	protected int height;
	
	public OpponentCar(String pathImage) {
		
		image = ImageLoader.loadImage(pathImage);
		
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		generateRandomPosition();
	}
	
	
	protected void generateRandomPosition() {
		int x1 = (int)(Math.random()*16);
		x = 250+x1*area;
		int y1 = (int)(Math.random()*1);
		y = y1*area-600;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

	abstract public void move();
	
	public void setSpeed (int dy){
		dx = dy;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
