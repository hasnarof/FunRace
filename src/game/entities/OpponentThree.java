package game.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.*;

import javax.imageio.ImageIO;

public class OpponentThree extends OpponentCar {
	
	private static String pathImage = "/res/(pressed)car4.png";
	
	public OpponentThree() {
		
		super(pathImage);
		
	}
	
	
	public void move()
	{
		y += dy;
		if(y >= 1150)
			super.generateRandomPosition();
	}
	

}
