package game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import game.tools.ImageLoader;


public class Background {
	
	private	BufferedImage road, backRoad;
	private int roadX, roadY; 
	private int dy;

	
	public Background()
	{
		roadX=200;
	    roadY=-700;
	    
	    road = ImageLoader.loadImage("/res/(long)portraitRoadBG.png");
	    backRoad = ImageLoader.loadImage("/res/(long)background.png");
	}

	
//	 public int getWidth(){
//		 return road.getWidth();
//	 }
//	 
//	 public int getHeight(){
//		 return road.getHeight();
//	 }
	 
	 public int getRoadX(){
		 return roadX;
	 }
	 
	 public int getRoadY(){
		 return roadY;
	 }
	 
	 public Image getRoad() {	
		return road;
	}
	 
	 public Image getBackRoad(){
		return backRoad;
	 }
	 
	 public void update(){
	     roadY+=dy;
	     if(roadY>0){
	    	 roadY=-700;
	     }
	 }
	 
	 public void setSpeed(int dy){
		 this.dy = dy;
		 update();
	 }

}