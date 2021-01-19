package game.states;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
	public void action() {
		
	}
	
}