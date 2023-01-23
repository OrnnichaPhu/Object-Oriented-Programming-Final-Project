package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import System.*;



public class Checkstart implements ActionListener {
	
	static int stageNum;
	
	public static boolean isRun = false;
	
	public static boolean isReset = false;
	
	GameCalculator Gc = new GameCalculator();
	
	PatternGenerate Pg = new PatternGenerate();

	
	public void actionPerformed(ActionEvent e) {
		
		if(GameCalculator.Gameover != true && GameCalculator.GameStart != true) {
			
			if(e.getSource() == ModePanel.startBT) {
				
				GameCalculator.GameStart = true;
				
				if (GameCalculator.GameStart == true && isRun != true) {
					
					isRun = true;
					
					GameCalculator.displayEnd = false;
					
					PatternPanel.ShowPattern.setDelay(dataSystem.delay);
				
					GameCalculator.Stagecount++;
					
					stageNum = GameCalculator.StageChange();
					
					Gc.GetPatternXY(stageNum);
					
					if(ModePanel.EndlessCb.isSelected() == true) {
						if(Math.floorMod(GameCalculator.Stagecount, 16) == 0) {
							InfoPanel.ScoreLB.setText("Score: "+ GameCalculator.Score);
						}
					}
					
					PatternPanel.ShowPattern.start();
					
					ModePanel.checkRun.start();
					
				}
				else if (GameCalculator.GameStart == true && isRun == true) {
					
					GameCalculator.displayEnd = false;
					
					PatternPanel.ShowPattern.setDelay(dataSystem.delay);
					
					stageNum = GameCalculator.StageChange();
					
					Gc.GetPatternXY(stageNum);

					PatternPanel.ShowPattern.restart();
				}
			}
			else if(isReset == true && isRun != true) {
				Pg.resetPatternGenerate();
				Pg.resetdataSystem();
				Gc.resetGameCalculator();
				LifePanel.LifeChange = true;
				ModePanel.EndlessCb.setEnabled(true);
				InfoPanel.StageLB.setText("Stage: ");
				InfoPanel.ScoreLB.setText("Stage: ");
				isReset = false;
			
				ModePanel.checkReset.stop();
			}
			else if(e.getSource() == ModePanel.resetBT && isRun != true) {
				Pg.resetPatternGenerate();
				Pg.resetdataSystem();
				Gc.resetGameCalculator();
				LifePanel.LifeChange = true;
				ModePanel.EndlessCb.setEnabled(true);
				InfoPanel.StageLB.setText("Stage: ");
				InfoPanel.ScoreLB.setText("Stage: ");
			
			}
		}
		else {
			if(e.getSource() == ModePanel.resetBT && isRun != true) {
				Pg.resetPatternGenerate();
				Pg.resetdataSystem();
				Gc.resetGameCalculator();
				LifePanel.LifeChange = true;
				ModePanel.EndlessCb.setEnabled(true);
				InfoPanel.StageLB.setText("Stage: ");
				InfoPanel.ScoreLB.setText("Stage: ");
				
			}
			else if(isReset == true && isRun != true) {
				Pg.resetPatternGenerate();
				Pg.resetdataSystem();
				Gc.resetGameCalculator();
				LifePanel.LifeChange = true;
				InfoPanel.StageLB.setText("Stage: ");
				InfoPanel.ScoreLB.setText("Stage: ");
				isReset = false;
				ModePanel.EndlessCb.setEnabled(true);
				ModePanel.checkReset.stop();
				
			}
			
		}
		

	}

}
