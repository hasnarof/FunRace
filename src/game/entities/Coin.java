package game.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.*;

import javax.imageio.ImageIO;
public class Coin {
	
	private boolean visible = true;
	private BufferedImage img2;
	 int x;
	 int y;
	
	private int area = 15;
	private int width;
	private int height;
	
	public Coin()
	{
		try{
		
		URL carImge=this.getClass().getResource("/res/coin.png");
		img2=ImageIO.read(carImge);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		width=img2.getWidth(null);;
		height=img2.getHeight(null);
		
		generateRandomPosition();
	}
	public Image getImage()
	{
		return img2;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void generateRandomPosition()
	{
		visible=true;
		int x1=(int)(Math.random()*16);
		x=280+x1*area;
		
		int y1=(int )(Math.random()*2);
		y=5+y1*area;
	}
	
	public void setVisible(boolean visible)
	{
		this.visible=visible;
	}
	public boolean isVisible()
	{
		return visible;
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x,y,width,height);
	}
	
	public void update(int dy)
	{
	 y+=dy;
	 
		if(y>800){
			
			generateRandomPosition();}
	}
}
