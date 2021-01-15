package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.entities.Coin;
import game.entities.OpponentOne;
import game.entities.OpponentThree;
import game.entities.OpponentTwo;


//@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
	Timer t;
	int count;
	int count1;
	int coinCount;
	int coincount;
	private static int z,z1;
	Background bg;
	int acc;
	private int menu;
	private double x = 300;
	private double y= 535; //posisi mulai pemain
	private double dx,dy;
	private	BufferedImage player,front;
	private OpponentOne op1;
	private OpponentTwo op2;
	private OpponentThree op3;
	int score;
	private boolean ingame=false;
	private Coin c;
	private boolean ingame1=true;
	public GamePanel()
	{
		
		addKeyListener(new KeyMenu());
		setFocusable(true);
		try{
		URL car1=this.getClass().getResource("/res/car1.png");
		player=ImageIO.read(car1);
		
		URL front1=this.getClass().getResource("/res/loadingscreen2.png");
		front=ImageIO.read(front1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		op1 = new OpponentOne();
		op2 = new OpponentTwo();
		op3=new OpponentThree();
		bg = new Background();
		c = new Coin();
		t = new Timer(20, this)	;
		t.start();
	}
	
	public void paint(Graphics g)
	{
		if(ingame1)
		{
			g.drawImage(front, 0, 0, this);
			if(menu>=150){
				ingame =true;
				ingame1=false;
			}
		}
		
		if(ingame)
		{
			for(int i=0; i<2; i++)
			{
				g.drawImage(bg.getImgBG(),i,0,this);
			}

			g.setColor(new Color(240, 208, 83));
			Font f=new Font("Consolas",Font.PLAIN,20);
			g.setFont(f);
			
			g.drawString("Coin  : " +coincount, 30, 50);
			g.drawString("SCORE : " +score, 30, 70);
			g.drawImage(bg.getImage(), bg.getX(), bg.getY(), this);
			g.drawImage(op2.getImage(), op2.getX(), op2.getY(), this);
			g.drawImage(op1.getImage(), op1.getX(), op1.getY(), this);
			g.drawImage(op3.getImage(), op3.getX(), op3.getY(), this);
		
			// drawing player car
			g.drawImage(player, (int) x,(int) y, this);
			
			g.drawImage(c.getImage(), c.getX(), c.getY(), null);
			z=score;
		}
		
		else if(ingame==false && ingame1==false){
			
			for(int i=0;i<10;i++)
			{
				g.drawImage(bg.getImgBG(),i,0,this);
			}
			Font f=new Font("Lucida Console",Font.BOLD,28);
			g.setFont(f);
			
			g.drawString("GAME OVER", 265, 150);
			g.drawString("SCORE "+z, 270, 300);
		   int c1=z1;
		   c.setVisible(false);
		   coinCount=0;
		   if(c.isVisible()==false)
			   g.drawString("Coin Count "+c1, 265, 340);
		   g.drawString("Press Space to Play Again", 135, 480);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		update();
		op3.move();
		op1.move();
		op2.move();
		checkCollision();
	}
	
	
	public void checkCollision()
	{
		count1 = 4;
		acc = 6;
		
		Rectangle ImageCar2=op2.getBoundCar1();
		Rectangle ImageCar3=op3.getBoundCar1();
		Rectangle ImageCar1=op1.getBoundCar1();
		Rectangle coinImg=c.getBoundCar2();
		Rectangle ImageCarPlayer=new Rectangle((int)x,(int)y,player.getWidth(null),player.getHeight(null));
		
		if(ImageCar1.intersects(ImageCarPlayer)){
			ingame = false;
			c.setVisible(false);
		}
		if(ImageCar3.intersects(ImageCarPlayer)){
			ingame = false;
			c.setVisible(false);
		}
		if(ImageCar2.intersects(ImageCarPlayer))
		{
			ingame = false;
			c.setVisible(false);
		}		
		if(coinImg.intersects(ImageCarPlayer))
		{
			c.generateRandomPosition();
			coincount = coincount + coinCount;
		}
		
	}
	
	public void update()
	{
		
		if(c.isVisible()==true)
			coinCount=1;
		else
			coinCount=0;
		
		z1 = coincount;
		menu += 2;
		x += dx;
		y -= dy;
		
		//maks gerak ke kanan
		if(x>=482)
			x = 482;
		//maks gerak ke kiri
		if(x<=260)
			x=260;
		
		score += count1;
		count = score;
		
		if(count>1000){
			bg.acceleration(7);
			op1.acc(10);
			op2.acc(9);
			op3.acc(8);
			c.update(6);
		}
		
		if(count>3000)
		{
			bg.acceleration(8);
			count1=10;
			op1.acc(14);
			op2.acc(15);
			op3.acc(13);
			c.update(8);
		}
		
		if(count>5000){
			bg.acceleration(9);
			count1=25;
			op1.acc(18);
			op2.acc(20);
			op3.acc(19);
			c.update(10);
		}
		else{
			bg.acceleration(acc);
			op1.acc(7);
			op2.acc(5);
			op3.acc(6);
			c.update(acc);
		}
	}
	
	
	public class KeyMenu extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			
			if(ingame1==false && ingame==false && key==KeyEvent.VK_SPACE){
				score=0;
				z=0;
				count=0;
				ingame=true;
				new GamePanel();
				//new Game();
				c.setVisible(true);
				
				coincount=0;
			}	
		
			if(key==KeyEvent.VK_RIGHT)
			{
				dx =+ 3.5;
			}
			if(key==KeyEvent.VK_LEFT)
			{
				dx =- 3.5;
			}
			
		}
		public void keyReleased(KeyEvent e)
		{
			int key=e.getKeyCode();
			if(key==KeyEvent.VK_RIGHT)
			{
				dx=0;
				dy=0;
			}
			if(key==KeyEvent.VK_LEFT)
			{
				dx=0;
				dy=0;
			}	
		}	
	}
}
