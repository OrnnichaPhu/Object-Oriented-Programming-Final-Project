package System;
import Graphics.*;
import java.awt.Graphics;

public class GameCalculator extends dataSystem {
	public static int Lifecount = 3;
	
	public static int Stagecount = 4;
	
	public static int stagePattern = 5;
	
	public static int Score = 0;
	
	public static boolean Gameover = false;
	
	public static boolean GameFin = false;
	
	public static boolean GameStart = false;
	
	public static boolean displayEnd = true;
	
	private boolean show = true;
	
	static int i = 0;
	
	private int[] ansX, ansY;
	
	PatternGenerate PaGen = new PatternGenerate();
	//dataSystem dss = new dataSystem();
	
	
	
	
	public static int StageChange() {
		if(GameFin == true && Gameover != true ) {
			
			if(ModePanel.EndlessCb.isSelected() == true) {
				if(Stagecount<=5) {
					stagePattern = 5;
					timePlus += 10;
					delay += 10; 
				}
				else if(Stagecount>5 && Stagecount<=10) {
					stagePattern = 10;
					timePlus += 15;
					delay += 15; 
				}
				else if(Stagecount>10 && Stagecount<15) {
					stagePattern = 16;
					timePlus += 25;
					delay += 25; 
					
				}
			}
			
			else {
				if(Stagecount<=5) {
					stagePattern = 5;
					timePlus += 10;
					delay += 10; 
				}
				else if(Stagecount>5 && Stagecount<=10) {
					stagePattern = 10;
					timePlus += 15;
					delay += 15; 
				}
				else if(Stagecount>10 && Stagecount<=15) {
					stagePattern = 16;
					timePlus += 25;
					delay += 25; 
					
				}
				else {
					stagePattern = 5;
					Stagecount = 1;
					timePlus = 0;
					Score = 0;
					InfoPanel.ScoreLB.setText("Score: "+ GameCalculator.Score);
					delay -= (4*10);
					delay -= (5*15);
					delay -= ((GameCalculator.Stagecount-10)*25);
					
				}
			}
			
		}
		InfoPanel.StageLB.setText("Stage: "+ GameCalculator.Stagecount);
		//System.out.println(delay);
		//System.out.println(timePlus);
		PatternGenerate.indexLength = stagePattern;
		return stagePattern;
	}
	
	public int CheckScore(int x, int y) {
		int xpi = PaGen.checkPost(x);
		int ypi = PaGen.checkPost(y);
		if(Gameover == false) {
			if( i < stagePattern) {
				if(x> 36 &&x<336 && y<336 && y>36) {
					if(ansX[getI()] == xpi && ansY[getI()] == ypi ) {
						Score++;
						InfoPanel.ScoreLB.setText("Score: "+ GameCalculator.Score);
						i++;
					}
					else {
						//Score--;
						InfoPanel.ScoreLB.setText("Score: "+ GameCalculator.Score);
						Lifecount--;
						LifePanel.LifeChange = true;
					}
				}	
			}
		}
		return Score;
	}
	
	public void GetPatternXY(int stagePattern) {
		PatternGenerate.PatternX = PaGen.patternCalculate(stagePattern);
		PatternGenerate.PatternY = PaGen.patternCalculate(stagePattern);
	}
	
	public void StagePatternGenerate(Graphics g) {
		
		if(show == true) {
			int idx = PatternGenerate.PatternX[PatternGenerate.index];
			int idy = PatternGenerate.PatternY[PatternGenerate.index];
			
			PatternGenerate.index++;
			
			PatternGenerate.indexLength--;
			
			int xpi = Mposition[idx];
			int ypi = Mposition[idy];
			for(int i=0; i<4;i++)
				for(int j=0; j<4;j++) {
					if(Xi[i] != xpi) {
						g.setColor(PatternGenerate.PatternC);
						g.fillRect(Xi[i], Yi[j], PaGen.R, PaGen.R);
					}
					else {
						if(Yi[j]!= ypi) {
							g.setColor(PatternGenerate.PatternC);
							g.fillRect(Xi[i], Yi[j], PaGen.R, PaGen.R);
						}
						else {
							g.setColor(PatternGenerate.pressPattern);
							g.fillRect(xpi, ypi, PaGen.R, PaGen.R);
						}
					}
				}
			show = !show;
		}
		else {
			for(int h=0; h<4;h++)
				for(int k=0; k<4;k++) {
					g.setColor(PatternGenerate.PatternC);
					g.fillRect(Xi[h], Yi[k], PaGen.R, PaGen.R);
				}
			show = !show;
			
		}

		

		
	}
	
	public int getIndexLength() {
		int index = PatternGenerate.indexLength;
		
		return index;
	}

	
	public void resetGameCalculator() {
		Lifecount = 3;
		Stagecount =0;
		stagePattern = 5;
		Score = 0;
		Gameover = false;
		GameFin = false;
		GameStart = false;
		displayEnd = true;
		show = true;
		i = 0;
		ansX = null;
		ansY = null;
	}
	
	public int[] getAnsX() {
		return ansX;
	}
	public void setAnsX(int[] ansX) {
		this.ansX = ansX;
	}

	public int[] getAnsY() {
		return ansY;
	}
	public void setAnsY(int[] ansY) {
		this.ansY = ansY;
	}

	
	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		GameCalculator.i = i;
	}

}
