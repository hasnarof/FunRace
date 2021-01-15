package game.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class OpponentCar {
	
	protected BufferedImage img;
	int x;
	int y;
	int dx;
	protected int area = 15;
	protected boolean visible = true;
	protected int width;
	protected int height;
	
	public OpponentCar(String pathImage) {
		try {
			URL carImg = this.getClass().getResource(pathImage);
			img=ImageIO.read(carImg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		width = img.getWidth(null);
		height = img.getHeight(null);
		
		generateRandomPosition();
	}
	
	
	protected void generateRandomPosition() {
		int x1 = (int)(Math.random()*16);
		x = 250+x1*area;
		int y1 = (int)(Math.random()*1);
		y = y1*area-600;
	}
	
	public Rectangle getBoundCar1() {
		return new Rectangle(x, y, width, height);
	}

	abstract public void move();
	
	public void acc(int dya){
		dx = dya;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public Image getImage(){
		return img;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
