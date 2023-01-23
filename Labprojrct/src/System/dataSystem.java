package System;

import java.awt.*;

public class dataSystem {
	
	//X&Y initial position
	public int[] Xi = {36,117,198,279};
	public int[] Yi = {36,117,198,279};
	
	//for check position in Point m(x,y)
	public int[] Mposition = {36,117,198,279};
	
	//X&Y end position	
	public int[] endPoint = {111,186,261,336};
	
	//position of mouse press
	public Point m;
	
	//range
	final private int MAX = 3;
	final private int MIN = 0;
	
	
	
	public static int delay = 1000;
	
	public static int timePlus;
	
	

	
	
	
	//protected 
	protected int getRandomInt() {
		//
		int random_int = (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN);
		return random_int;
	}
	
	public int[] getPatternX() {
		return PatternGenerate.PatternX;
	}
	
	public int[] setPatternX() {
		return PatternGenerate.PatternX = null;
	}
	
	public int[] getPatternY() {
		return PatternGenerate.PatternY;
	}
	
	public int[] setPatternY() {
		return PatternGenerate.PatternY = null;
	}

	public void resetdataSystem() {
		m = null;
		
		if(GameCalculator.Stagecount <= 5  && GameCalculator.Stagecount > 1) {
			delay = delay-((GameCalculator.Stagecount-1)*10);
		}
		else if(GameCalculator.Stagecount > 5 && GameCalculator.Stagecount <= 10) {
			delay = delay - (4*10);
			delay = delay-((GameCalculator.Stagecount-5)*15);
		}
		else if(GameCalculator.Stagecount>10 && GameCalculator.Stagecount < 15) {
			delay = delay - (4*10);
			delay = delay - (5*15);
			delay = delay-((GameCalculator.Stagecount-10)*25);
		}
	}
}
