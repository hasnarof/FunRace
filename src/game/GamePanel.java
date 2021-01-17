package game;

//test
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
import game.entities.PlayerCar;
import game.tools.ImageLoader;

//@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
	Timer timer;
	int count;
	int deltaScore;
	int deltaCoinScore;
	int currentCoinScore;
	private int finalScore,finalCoinScore;
	
	int currentSpeed;
	private int menu;
	
	private	BufferedImage frontScreen;
	
	Background background;
	PlayerCar player;
	OpponentOne opponent1;
	OpponentTwo opponent2;
	OpponentThree opponent3;
	
	int currentScore;
	
	private boolean inGameState=false;
	private Coin coin;
	private boolean welcomeScreenState=true;
	
	public GamePanel()
	{
		
		addKeyListener(new KeyMenu());
		setFocusable(true);
		
		player = new PlayerCar();
		
		frontScreen = ImageLoader.loadImage("/res/loadingscreen2.png");
				
		opponent1 = new OpponentOne();
		opponent2 = new OpponentTwo();
		opponent3 = new OpponentThree();
		background = new Background();
		coin = new Coin();
		
		timer = new Timer(20, this)	;
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		if(welcomeScreenState)
		{
			g.drawImage(frontScreen, 0, 0, this);
			if(menu>=150){
				inGameState = true;
				welcomeScreenState = false;
			}
		}
		
		if(inGameState)
		{
			for(int i=0; i<2; i++){
				g.drawImage(background.getBackRoad(),i,0,this);
			}

			g.setColor(new Color(240, 208, 83));
			Font f=new Font("Consolas",Font.PLAIN,20);
			g.setFont(f);
			
			g.drawString("Coin  : " +currentCoinScore, 30, 50);
			g.drawString("SCORE : " +currentScore, 30, 70);
			
			g.drawImage(background.getRoad(), background.getRoadX(), background.getRoadY(), this);
			
			g.drawImage(opponent2.getImage(), opponent2.getX(), opponent2.getY(), this);
			g.drawImage(opponent1.getImage(), opponent1.getX(), opponent1.getY(), this);
			g.drawImage(opponent3.getImage(), opponent3.getX(), opponent3.getY(), this);
		
			// drawing player car
			g.drawImage(player.getImage(), (int) player.getX(),(int) player.getY(), this);
			
			g.drawImage(coin.getImage(), coin.getX(), coin.getY(), null);
			
			finalScore = currentScore;
		}
		
		else if(inGameState == false && welcomeScreenState == false){
			
			for(int i=0;i<10;i++) {
				g.drawImage(background.getBackRoad(),i,0,this);
			}
			
			Font f = new Font("Lucida Console",Font.BOLD,28);
			g.setFont(f);
			g.drawString("GAME OVER", 265, 150);
			g.drawString("SCORE "+finalScore, 270, 300);
			
//			int c1=z1;
			coin.setVisible(false);
			deltaCoinScore=0;
			
			if(coin.isVisible()==false)
				g.drawString("Coin Count "+finalCoinScore, 265, 340);
			
			g.drawString("Press Space to Play Again", 135, 480);
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		update();
		opponent3.move();
		opponent1.move();
		opponent2.move();
		checkCollision();
	}
	
	
	public void checkCollision(){
		deltaScore = 4;
		currentSpeed = 7;
		
		Rectangle op1 = opponent1.getRectangle();
		Rectangle op2 = opponent2.getRectangle();
		Rectangle op3 = opponent3.getRectangle();
		Rectangle c = coin.getRectangle();
		
		Rectangle p = player.getRectangle();
		
		if(op1.intersects(p)){
			inGameState = false;
			coin.setVisible(false);
		}

		if(op2.intersects(p)){
			inGameState = false;
			coin.setVisible(false);
		}		
		
		if(op3.intersects(p)){
			inGameState = false;
			coin.setVisible(false);
		}
		
		if(c.intersects(p)){
			coin.generateRandomPosition();
			currentCoinScore = currentCoinScore + deltaCoinScore;
		}
		
	}
	
	public void update() {
		
		if(coin.isVisible()==true)
			deltaCoinScore=1;
		else
			deltaCoinScore=0;
		
		finalCoinScore = currentCoinScore;
		menu += 2;
		
		player.setX(player.getX() + player.getDx());
		player.setY(player.getY() - player.getDy());
		
		//maks gerak ke kanan
		if(player.getX() >= 482)
			player.setX(482);
		
		//maks gerak ke kiri
		if(player.getX() <= 260)
			player.setX(260);;
		
		currentScore += deltaScore;
		count = currentScore;
		
		if(count>2000){
			background.setSpeed(7);
			opponent1.setSpeed(10);
			opponent2.setSpeed(9);
			opponent3.setSpeed(8);
			coin.update(6);
		}
		
		if(count>5000){
			background.setSpeed(8);
			deltaScore=10;
			opponent1.setSpeed(14);
			opponent2.setSpeed(15);
			opponent3.setSpeed(13);
			coin.update(8);
		}
		
		if(count>7000){
			background.setSpeed(9);
			deltaScore=25;
			opponent1.setSpeed(18);
			opponent2.setSpeed(20);
			opponent3.setSpeed(19);
			coin.update(10);
		}
		else {
			background.setSpeed(currentSpeed);
			opponent1.setSpeed(7);
			opponent2.setSpeed(5);
			opponent3.setSpeed(6);
			coin.update(currentSpeed);
		}
	}
	
	
	public class KeyMenu extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			
			if(welcomeScreenState==false && inGameState==false && key==KeyEvent.VK_SPACE){
				currentScore=0;
				finalScore=0;
				count=0;
				inGameState=true;
				new GamePanel();
				//new Game();
				coin.setVisible(true);
				
				currentCoinScore=0;
			}	
		
			if(key==KeyEvent.VK_RIGHT){
				player.setDx(player.getDx() + 3.5);
			}
			
			if(key==KeyEvent.VK_LEFT){
				player.setDx(player.getDx() - 3.5);
			}
			
		}
		
		public void keyReleased(KeyEvent e){
			int key=e.getKeyCode();
			if(key==KeyEvent.VK_RIGHT){
				player.setDx(0);
				player.setDy(0);
			}
			
			if(key==KeyEvent.VK_LEFT){
				player.setDx(0);
				player.setDy(0);
			}	
		}	
	}
}
