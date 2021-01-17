package game.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.*;

import javax.imageio.ImageIO;

public class OpponentTwo extends OpponentCar {
	
	private static String pathImage = "/res/(pressed)car3.png";
	
	public OpponentTwo() {
		
		super(pathImage);
		
	}
	
	public void move() {
		y += dy;
		if(y >= 680)
		super.generateRandomPosition();	
	}
	
	

	

}
