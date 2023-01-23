package Graphics;

import javax.swing.*;
import java.awt.*;
import System.*;
public class InfoPanel extends JPanel {
	
	private Font myfont = new Font("SanSerif", Font.BOLD,20);
	
	LifePanel lifePanel = new LifePanel();
	
	JPanel Stage = new JPanel();
	JPanel Score = new JPanel();
	
	public static JLabel ScoreLB = new JLabel("Score: ");
	public static JLabel StageLB = new JLabel("Stage: ");
	
	
	InfoPanel(){
		//this.setBounds(0,0,100,730);
		//this.setLocation(0, 0);
		this.setPreferredSize(new Dimension(650, 110));
		//this.setBackground(Color.white);
		this.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.gray));
		

	
		this.setLayout(new FlowLayout(20,20,5));
		
		
		//StageLB.setBackground(Color.white);
		//ScoreLB.setBackground(Color.white);
		this.add(lifePanel);
		//lifePanel.setLayout(null);
		//lifePanel.setLocation(5, 5);
		lifePanel.setPreferredSize(new Dimension(225, 80));
		
		StageLB.setForeground(Color.black); 
		StageLB.setFont(myfont);
		StageLB.setPreferredSize(new Dimension(120, 50));
		
		//StageLB.setLocation(10, 10);
		//StageLB.setBounds(2, 2, 120, 50);
		
		
		this.add(Stage);
		//Stage.setLayout(new BorderLayout());
		Stage.add(StageLB);
		Stage.setBackground(Color.white);
		
		//StageLB.setLayout(null);
		//Stage.setLocation(290, 10);
		Stage.setPreferredSize(new Dimension(120, 50));
		
		
		ScoreLB.setForeground(Color.black); 
		ScoreLB.setPreferredSize(new Dimension(120, 50));
		//ScoreLB.setLocation(2, 1);
		ScoreLB.setFont(myfont);
		
		this.add(Score);
		//Score.setLayout(new BorderLayout());
		Score.add(ScoreLB);
		Score.setBackground(Color.white);
		
		//ScoreLB.setLayout(null);
		//Score.setLocation(490, 10);
		Score.setPreferredSize(new Dimension(120, 50));
		
	}


	

}
