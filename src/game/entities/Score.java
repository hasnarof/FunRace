package game.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Score {

	public int currentScore;
	public int checkScore;
	public int deltaScore;
	public int deltaCoinScore;
	public int currentCoinScore;
	public int finalScore,finalCoinScore;
	
	private int highestScore, highestCoinScore;
	
	URL pathHighestScore, pathHighestCoinScore;
	
	File highestScoreFile, highestCoinScoreFile;
	
	public Score() {
		
		pathHighestScore = getClass().getResource("/res/highestScore.txt");
		pathHighestCoinScore = getClass().getResource("/res/highestCoinScore.txt");
				
		init();

	}
	
	public void init() {
			
		try {
		      highestScoreFile = new File(pathHighestScore.getPath());
		      Scanner myReader = new Scanner(highestScoreFile);
		      while (myReader.hasNextInt()) {
		        highestScore = myReader.nextInt();
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		
		try {
		      highestCoinScoreFile = new File(pathHighestCoinScore.getPath());
		      Scanner myReader = new Scanner(highestCoinScoreFile);
		      while (myReader.hasNextInt()) {
		        highestCoinScore = myReader.nextInt();
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}

	}

	
	public void setHighestScore(int score) {
	
		highestScore = Math.max(highestScore, score);
		
		// read file highest score and compare
		try {
		      Scanner myReader = new Scanner(highestScoreFile);
		      
		      int highestScoreTemp = 0;
		      while (myReader.hasNextInt()) {
		        highestScoreTemp = myReader.nextInt();
		      }
		      
		      highestScore = Math.max(highestScore, highestScoreTemp);
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		
		// write highest score to file
		try {
		      FileWriter myWriter = new FileWriter("src/res/highestScore.txt");
		      myWriter.write(highestScore + "");
		      myWriter.close();
		} catch (IOException e) {
	      e.printStackTrace();
	    }
		
	}
	
	public void setHighestCoinScore(int coinCount) {
		
		highestCoinScore = Math.max(highestCoinScore, coinCount);
		
		// read file highest coin count and compare
		try {
		      Scanner myReader = new Scanner(highestCoinScoreFile);
		      
		      int highestCoinScoreTemp = 0;
		      while (myReader.hasNextInt()) {
		    	  highestCoinScoreTemp = myReader.nextInt();
		      }
		      
		      highestCoinScore = Math.max(highestCoinScore, highestCoinScoreTemp);
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		
		// write highest score to file
		try {
		      FileWriter myWriter = new FileWriter("src/res/highestCoinScore.txt");
		      myWriter.write(highestCoinScore + "");
		      myWriter.close();
		} catch (IOException e) {
	      e.printStackTrace();
	    }
		
	}
	
	
	public int getHighestScore() {
		return highestScore;
	}

	public int getHighestCoinScore() {
		return highestCoinScore;
	}
	

}
