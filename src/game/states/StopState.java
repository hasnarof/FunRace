package game.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.Background;
import game.entities.Score;

public class StopState extends GameState {
	
	private Score score;
	
	private Background background;
	
	Font highestScoreFont, f;
	
	public StopState(GameStateManager gsm, Score score) {
		
		this.gsm = gsm;
		
		this.score = score;
		
		background = new Background();
		
		init();
	}

	@Override
	public void init() {
		highestScoreFont = new Font("Lucida Console",Font.BOLD,20);
		f = new Font("Lucida Console",Font.BOLD,28);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void draw(Graphics g) {
		
		score.setHighestScore(score.finalScore);
		score.setHighestCoinScore(score.finalCoinScore);
		
		for(int i=0;i<10;i++) {
			g.drawImage(background.getBackRoad(),i,0,null);
		}
		
		g.setFont(highestScoreFont);
		g.drawString("HIGHEST SCORE EVER "+score.getHighestScore(), 10, 25);
		g.drawString("HIGHEST COIN COUNT EVER "+ score.getHighestCoinScore(), 10, 50);
		
		g.setFont(f);
		g.drawString("GAME OVER", 265, 150);
		g.drawString("SCORE "+score.finalScore, 270, 300);
		
		
//		coin.setVisible(false);
		score.deltaCoinScore=0;
		
//		if(coin.isVisible()==false)
			g.drawString("Coin Count "+score.finalCoinScore, 265, 340);
		
		g.drawString("Press Space to Play Again", 135, 480);

	}

	@Override
	public void keyPressed(int k) {
		
		if(k==KeyEvent.VK_SPACE) {
			gsm.setState(GameStateManager.LEVEL1STATE, score);
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
