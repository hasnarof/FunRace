
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class GameLauncher extends JFrame {
	private  BufferedImage img1;
	public GameLauncher()
	{
		try{
			//logo app
			URL icon=this.getClass().getResource("res/car1.png");
			img1=ImageIO.read(icon);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		JFrame f=new JFrame("Balapan Fun Race");
//		f.setUndecorated(true);
//		f.setExtendedState(f.MAXIMIZED_BOTH);
		f.setSize(720, 690);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.add(new GamePanel());
        f.setIconImage(img1);
        f.setVisible(true);
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String args[])
	{
		new GameLauncher();
		
	}
}
