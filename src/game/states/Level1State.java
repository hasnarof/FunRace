package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

	@Override
	public void update() {
		// TODO Auto-generated method stub

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

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}


}
