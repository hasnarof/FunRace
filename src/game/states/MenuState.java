package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import game.GamePanel;
import game.tools.ImageLoader;

public class MenuState extends GameState {
	
	private	BufferedImage frontScreen;
	
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Quit"
	};
	
	private String info = "press ENTER to select the option";
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	private Font fontSelected;
	private Font fontInfo;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		init();

	}

	@Override
	public void init() {
		
		frontScreen = ImageLoader.loadImage("/res/loadingscreen2.png");
		
		titleColor = new Color(128, 0, 0);
		titleFont = new Font(
				"Century Gothic",
				Font.PLAIN,
				28);
		
		font = new Font("Century Gothic", Font.PLAIN, 28);
		fontInfo = new Font("Verdana", Font.ITALIC, 16);
		
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		fontSelected = new Font("Century Gothic",Font.BOLD, 28).deriveFont(fontAttributes);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(frontScreen, 0, 0, null);
		
		// draw string info
		g.setColor(Color.white);
		g.setFont(fontInfo);
		
		g.drawString(info, GamePanel.WIDTH / 4 + 50, GamePanel.HEIGHT/17);
		
		// draw menu
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
				g.setFont(fontSelected);
			}
			else {
				g.setColor(Color.RED);
				g.setFont(font);
			}
			g.drawString(options[i], GamePanel.WIDTH / 2 - 33, GamePanel.HEIGHT/9 + i * 30);
		}

	}
	
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE, score);
		}
		if(currentChoice == 1) {
			executeExit();
		}
	}
	
	public void executeExit() {
		
		int choose = JOptionPane.showConfirmDialog(null, "Do you really want to exit the game?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			System.exit(0);
			System.out.println("Exit");
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}

	}

}
