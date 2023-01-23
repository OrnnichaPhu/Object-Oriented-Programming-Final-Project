package System;
import java.awt.*;



public class PatternGenerate extends dataSystem {
	
	int[] Pattern;
	
	static int[] PatternX;
	
	static int[] PatternY;
	
	public static int PatternIndex = 0;
	
	public static int index = 0;
	
	protected static int indexLength;
	
	final public int R = 75;
	
	public static Color PatternC = Color.PINK;
	public static Color pressPattern = Color.WHITE;
	
	int point;
	
	
	//method to generate rec4x4
	public void Patternfuction(Graphics g) {
		//rec that has been press
		/*
		 * g.setColor(pressPattern); g.fillRect(xpi, ypi, r, r);
		 */
		//rec that hasn't been press
		g.setColor(PatternC);
		if(m != null && m.x> 36 &&m.x<336 && m.y<336 && m.y>36) {
			int xpi = checkPost((int) m.getX());
			int ypi = checkPost((int) m.getY());
			for(int i=0; i<4;i++)
				for(int j=0; j<4;j++) {
					if(Xi[i] != xpi) {
						g.setColor(PatternC);
						g.fillRect(Xi[i], Yi[j], R, R);
					}
					else {
						if(Yi[j]!= ypi) {
							g.setColor(PatternC);
							g.fillRect(Xi[i], Yi[j], R, R);
						}
						else {
							g.setColor(pressPattern);
							g.fillRect(xpi, ypi, R, R);
						}
					}
				}
		}
		else {
			for(int h=0; h<4;h++)
				for(int k=0; k<4;k++) {
					g.setColor(PatternC);
					g.fillRect(Xi[h], Yi[k], R, R);
				}		
		}
	
	}
	
	int checkPost(int post) {
		for(int i = 0; i<4; i++) {
			if((int)(post/endPoint[i])<1) {
				point = super.Mposition[i];
				break;
			}
		}
		return point;
	}
	
	public int[] patternCalculate(int stagePattern) {
		
		Pattern = null;
		
		Pattern = new int[stagePattern];		
		for(int i = 0; i<stagePattern; i++) {
			Pattern[i] = getRandomInt();
		}
		return Pattern;
	}
	
	public int[] getAnsAlley(int stagePattern, int[] PatternZ) {
		int[] ansSet = new int[stagePattern];
		for(int i = 0; i<stagePattern; i++) {
			ansSet[i] = super.Mposition[PatternZ[i]];
		}
		return ansSet;
	}

	public void resetPatternGenerate() {
		Pattern = null;
		PatternX = null;
		PatternY = null;
		PatternIndex = 0;
		index = 0;
		indexLength = 0;
		point = 0;
	}
	
}
