package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import game.Background;
import game.entities.Coin;
import game.entities.OpponentOne;
import game.entities.OpponentThree;
import game.entities.OpponentTwo;
import game.entities.PlayerCar;
import game.entities.Score;

public class Level1State extends GameState {
	
	Score score;
	
	int currentSpeed;
	
	Background background;
	PlayerCar player;
	OpponentOne opponent1;
	OpponentTwo opponent2;
	OpponentThree opponent3;
	Coin coin;
	
	public Level1State(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		player = new PlayerCar();
				
		opponent1 = new OpponentOne();
		opponent2 = new OpponentTwo();
		opponent3 = new OpponentThree();
		background = new Background();
		coin = new Coin();
		
		score = new Score();
		
//		sound = new GameSound();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void action() {
		update();
		opponent3.move();
		opponent1.move();
		opponent2.move();
		checkCollision();
	}
	
	@Override
	public void update() {
				
		if(coin.isVisible()==true)
			score.deltaCoinScore=1;
		else
			score.deltaCoinScore=0;
		
		score.finalCoinScore = score.currentCoinScore;
		
		player.setX(player.getX() + player.getDx());
		player.setY(player.getY() - player.getDy());
		
		//maks gerak ke kanan
		if(player.getX() >= background.getRightRoadBound())
			player.setX( background.getRightRoadBound() );
		
		//maks gerak ke kiri
		if(player.getX() <= background.getLeftRoadBound())
			player.setX( background.getLeftRoadBound() );;
		
		score.currentScore += score.deltaScore;
		score.checkScore = score.currentScore;
		
		if(score.checkScore>2000){
			background.setSpeed(7);
			opponent1.setSpeed(10);
			opponent2.setSpeed(9);
			opponent3.setSpeed(8);
			coin.update(6);
		}
		
		if(score.checkScore>5000){
			background.setSpeed(8);
			score.deltaScore=10;
			opponent1.setSpeed(14);
			opponent2.setSpeed(15);
			opponent3.setSpeed(13);
			coin.update(8);
		}
		
		if(score.checkScore>7000){
			background.setSpeed(9);
			score.deltaScore=25;
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

	@Override
	public void draw(Graphics g) {

		for(int i=0; i<2; i++){
			g.drawImage(background.getBackRoad(),i,0,null);
		}

		g.setColor(new Color(240, 208, 83));
		Font f=new Font("Consolas",Font.PLAIN,20);
		g.setFont(f);
		
		g.drawString("Coin  : " +score.currentCoinScore, 30, 50);
		g.drawString("SCORE : " +score.currentScore, 30, 70);
		
		g.drawImage(background.getRoad(), background.getRoadX(), background.getRoadY(), null);
		
		g.drawImage(opponent2.getImage(), (int)opponent2.getX(), (int)opponent2.getY(), null);
		g.drawImage(opponent1.getImage(), (int)opponent1.getX(), (int)opponent1.getY(), null);
		g.drawImage(opponent3.getImage(), (int)opponent3.getX(), (int)opponent3.getY(), null);
	
		// drawing player car
		g.drawImage(player.getImage(), (int) player.getX(),(int) player.getY(), null);
		
		g.drawImage(coin.getImage(), coin.getX(), coin.getY(), null);
		
		score.finalScore = score.currentScore;

	}

	public void checkCollision(){
		score.deltaScore = 4;
		currentSpeed = 7;
		
		Rectangle op1 = opponent1.getRectangle();
		Rectangle op2 = opponent2.getRectangle();
		Rectangle op3 = opponent3.getRectangle();
		Rectangle c = coin.getRectangle();
		
		Rectangle p = player.getRectangle();
		
		if(op1.intersects(p)){
			gsm.setState(GameStateManager.STOPSTATE);
//			coin.setVisible(false);
		}

		if(op2.intersects(p)){
			gsm.setState(GameStateManager.STOPSTATE);
//			coin.setVisible(false);
		}		
		
		if(op3.intersects(p)){
			gsm.setState(GameStateManager.STOPSTATE);
//			coin.setVisible(false);
		}
		
		if(c.intersects(p)){
			coin.generateRandomPosition();
			score.currentCoinScore = score.currentCoinScore + score.deltaCoinScore;
		}
		
	}
	
	@Override
	public void keyPressed(int key) {
		if(key==KeyEvent.VK_RIGHT){
			player.setDx(player.getDx() + 3.5);
		}
		
		if(key==KeyEvent.VK_LEFT){
			player.setDx(player.getDx() - 3.5);
		}
	}

	@Override
	public void keyReleased(int key) {
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
