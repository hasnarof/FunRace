package game.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.*;
import java.awt.Image;

import javax.imageio.ImageIO;

public class OpponentOne extends OpponentCar {
	
	private static String pathImage = "/res/(pressed)car2.png";
	
	public OpponentOne() {
		
		super(pathImage);
		
	}
	
	public void move()
	{
		y+=dy;
		if(y >= 900)
			generateRandomPosition();
	}
	
}
