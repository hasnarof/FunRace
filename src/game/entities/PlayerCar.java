package game.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.tools.ImageLoader;

public class PlayerCar extends Car {
	
	public PlayerCar() {
		
		super("/res/car1.png");
		
		this.x = 300;
		this.y = 535; // posisi mulai bermain
	}
	


}
