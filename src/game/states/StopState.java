package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.Background;
import game.GamePanel;
import game.entities.Score;

public class StopState extends GameState {
	
	private Score score;
	
	private Background background;
	
	Font highestScoreFont, f, titleFont;
	
	public StopState(GameStateManager gsm, Score score) {
		
		this.gsm = gsm;
		
		this.score = score;
		
		background = new Background();
		
		init();
	}

	@Override
	public void init() {
		highestScoreFont = new Font("Bodoni MT",Font.BOLD,25);
		f = new Font("Broadway",Font.BOLD,28);
		titleFont = new Font("Broadway",Font.BOLD,60);
		
		score.setHighestScore(score.finalScore);
		score.setHighestCoinScore(score.finalCoinScore);

		score.deltaCoinScore=0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void draw(Graphics g) {
		
		for(int i=0;i<10;i++) {
			g.drawImage(background.getBackRoad(),i,0,null);
		}
		
		g.setFont(highestScoreFont);
		g.setColor(Color.BLACK);
		g.drawString("Highest Score Ever : "+score.getHighestScore(), 10, 25);
		g.drawString("Highest Coin Count Ever : "+ score.getHighestCoinScore(), 10, 50);
		
		g.setFont(titleFont);
		g.setColor(Color.white);
		g.drawString("GAME OVER", GamePanel.WIDTH/5 + 10, 200);
		
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("SCORE "+score.finalScore, 270, 300);
		g.drawString("COIN COUNT "+score.finalCoinScore, 245, 340);
		
		g.setFont(new Font("Bodoni MT",Font.ITALIC,25));
		g.setColor(Color.white);
		g.drawString("Press Space to Play Again", GamePanel.WIDTH/3 - 15, 480);

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
