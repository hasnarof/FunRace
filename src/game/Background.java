package game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


public class Background {
	
	private	BufferedImage road, background;
	private int x, y; 
	private int dy;

	
	public Background()
	{
		x=200;
	    y=-700;
		
		try{
			URL roadImgUrl=this.getClass().getResource("/res/(long)portraitRoadBG.png");
			road=ImageIO.read(roadImgUrl);
			URL backgroungImgUrl=this.getClass().getResource("/res/(long)background.png");
			background=ImageIO.read(backgroungImgUrl);
		}
		catch(Exception e){}
	}

	
	 public int getWidth()
	 {
		 return road.getWidth();
	 }
	 public int getHeight()
	 {
		 return road.getHeight();
	 }
	 public int getX()
	 {
		 return x;
		 
	 }
	 public int getY()
	 {
		 return y;
	 }
	public Image getImage() {
		
		return road;
	}
	public Image getImgBG()
	{
		return background;
	}
	 public void update()
	 {

	     y+=dy;
	     if(y>0)
	     {
	    	 y=-700;
	     }
	 }
	 
	 public void acceleration(int dya)
	 {
		 dy=dya;
		 update();
	 }

}
