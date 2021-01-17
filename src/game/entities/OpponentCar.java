package game.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.tools.ImageLoader;

public abstract class OpponentCar extends Car {
	
	protected int area = 15;
	protected boolean visible = true;
	
	public OpponentCar(String pathImage) {
		
		super(pathImage);
		
		generateRandomPosition();
	}
	
	
	protected void generateRandomPosition() {
		int x1 = (int)(Math.random()*16);
		x = 250+x1*area;
		int y1 = (int)(Math.random()*1);
		y = y1*area-600;
	}

	abstract public void move();
	
	public void setSpeed (int dy){
		this.dy = dy;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
}
