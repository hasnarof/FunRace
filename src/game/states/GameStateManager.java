package game.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.entities.Score;
import game.tools.ImageLoader;

public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;
	Score score;
	
	public static final int NUMGAMESTATES = 3;
	public static final int MENUSTATE = 0;
	public static final int STOPSTATE = 1;
	public static final int LEVEL1STATE = 2;
	
	public GameStateManager() {
		
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = MENUSTATE;
		loadState(currentState);
		
	}
	
	private void loadState(int state) {
		if(state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		if(state == LEVEL1STATE)
			gameStates[state] = new Level1State(this);
		if(state == STOPSTATE) {
			gameStates[state] = new StopState(this, this.score);
		}
			
	}
	
	private void unloadState(int state) {
		gameStates[state] = null;
	}
	
	public void setState(int state, Score score) {
		unloadState(currentState);
		currentState = state;
		this.score = score;
		loadState(currentState);
		//gameStates[currentState].init();
	}
	
	public void update() {
		try {
			if(currentState == LEVEL1STATE) {
				gameStates[currentState].action();
			} else 
				gameStates[currentState].update();
		} catch(Exception e) {}
	}
	
	public void draw(Graphics g) {
		try {
			gameStates[currentState].draw(g);
			
		} catch(Exception e) {}
	}
	
	public void keyPressed(int k) {
		if(gameStates[currentState] != null)
			gameStates[currentState].keyPressed(k);
	}
	
	public void keyReleased(int k) {
		
		if(gameStates[currentState] != null)
			gameStates[currentState].keyReleased(k);
	}
	
}









