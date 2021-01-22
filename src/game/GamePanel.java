package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.states.GameStateManager;
import game.states.MenuState;
import game.tools.ImageLoader;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	// dimensions
	public static final int WIDTH = 720;
	public static final int HEIGHT = 690;
	public static final int SCALE = 1;
	
	// game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// game state manager
	private GameStateManager gsm;
	
	public GamePanel()
	{
		super();
		setPreferredSize(
			new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init() {
		
		running = true;
		
		gsm = new GameStateManager();
		
	}

	@Override
	public void run() {
		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			repaint();
			update();
			
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000; // in milliseconds
			if(wait < 0) wait = 5; // pakai elapse, wait karena takut elapsed melebihi targetTime
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void update() {
		gsm.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		gsm.draw(g);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
	
}