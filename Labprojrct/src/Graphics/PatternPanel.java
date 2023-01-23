package Graphics;

import javax.swing.*;
import System.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class PatternPanel extends JPanel implements ActionListener {
	
	PatternListenrr PatL = new PatternListenrr();
	
	static Timer ShowPattern = new Timer(0,null);
	
	private Timer checkColor = new Timer(500,this);
	
	GameCalculator gCal = new GameCalculator();
	
	//Implicit casting
	dataSystem ds = new PatternGenerate();
	
	clickPattern Cp = new clickPattern();
	
	Color patternc = PatternGenerate.PatternC;

	
	
	PatternPanel(){
		this.setSize(390, 520);
		this.setPreferredSize(new Dimension(390, 520));
		this.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.gray));
		//this.setLocation(50, 0);
		this.addMouseListener(Cp);
		checkColor.start();
		ShowPattern.addActionListener(PatL);
	
	
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(30, 30, 330, 330);
		//
		if(GameCalculator.displayEnd != true) {
			gCal.StagePatternGenerate(g);
		}
		else {
			//Explicit casting
			((PatternGenerate) ds).Patternfuction(g);
		}
	
	}
	
	
	

	public void actionPerformed(ActionEvent e) {
		if(Color_panel.colorChange == true) {
			repaint();
			Color_panel.colorChange = !Color_panel.colorChange;
		}
		
		
	}
	
	
	
	private class clickPattern implements MouseListener{

		public void mouseClicked(MouseEvent e) {}


		public void mousePressed(MouseEvent e) {
			if(GameCalculator.displayEnd == true) {
				ds.m = e.getPoint();
				repaint();
				
				int ansXpoint = (int) ds.m.getX();
				int ansYpoint = (int) ds.m.getY();
				if(GameCalculator.Gameover != true) {
					if(GameCalculator.GameStart == true)
						if( GameCalculator.getI() < GameCalculator.stagePattern - 1) {
							gCal.CheckScore(ansXpoint,ansYpoint);
						}
						else if (GameCalculator.getI() < GameCalculator.stagePattern){
							gCal.CheckScore(ansXpoint,ansYpoint);
							
						}
				}
				
				
			}
		}

		public void mouseReleased(MouseEvent e) {
			ds.m = null;
			if (GameCalculator.getI() == GameCalculator.stagePattern){
				GameCalculator.GameFin = true;	
				GameCalculator.GameStart = false;
				PatternGenerate.index = 0;
				GameCalculator.setI(0);
				ds.setPatternX();
				ds.setPatternY();
				
				if(ModePanel.EndlessCb.isSelected() == true) {
					if(Math.floorMod(GameCalculator.Stagecount, 15) == 0) {
						int OldScore = GameCalculator.Score;
						GameCalculator.Score += (int)Math.floor(Math.random()*(5-1+1)+1);
						InfoPanel.ScoreLB.setText(OldScore+"->"+GameCalculator.Score);
						GameCalculator.Lifecount += 1;
						LifePanel.LifeChange = true;
					}
				}
				
			}
			repaint();
		}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
		
	}
	
	
	private class PatternListenrr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(gCal.getIndexLength() > 0) {
				repaint();
				}
			else {
				GameCalculator.displayEnd = true;
				Checkstart.isRun = false;
				ShowPattern.stop();
				
				gCal.setAnsX(((PatternGenerate) ds).getAnsAlley(Checkstart.stageNum, ds.getPatternX()));
				gCal.setAnsY(((PatternGenerate) ds).getAnsAlley(Checkstart.stageNum, ds.getPatternY()));
				
				//System.out.println(Arrays.toString(gCal.getAnsX()));
				
		
				repaint();
			}
			
		}
	}	

}
