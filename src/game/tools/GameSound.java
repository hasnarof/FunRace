package game.tools;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.sound.sampled.*;

public class GameSound {
	
    // to store current position 
    Long currentFrame; 
    
    // current status of clip 
    String status; 
	
    String filePath;
    
	File file;
	
	URL url;
	
	Clip clip;
	
	AudioInputStream audioInputStream;

	public GameSound(String pathname) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		url = getClass().getResource(pathname);
		
		this.filePath = url.getPath();
		
		File file = new File(url.getPath());
		audioInputStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		
		
		
	}
	
	public Clip getCLip() {
		return clip;
	}
	
	// Method to play the audio 
    public void play()  
    { 
    	try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
      
    // Method to pause the audio 
    public void pause()  
    { 
        if (status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  
        this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
      
    // Method to resume the audio 
    public void resumeAudio() throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    } 
      
    // Method to restart the audio 
    public void restart() throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
      
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    } 
      
    // Method to jump over a specific part 
    public void jump(long c) throws UnsupportedAudioFileException, IOException, 
                                                        LineUnavailableException  
    { 
        if (c > 0 && c < clip.getMicrosecondLength())  
        { 
            clip.stop(); 
            clip.close(); 
            resetAudioStream(); 
            currentFrame = c; 
            clip.setMicrosecondPosition(c); 
            this.play(); 
        } 
    } 
      
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream(file); 
        clip.open(audioInputStream); 
//        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
  
} 
	