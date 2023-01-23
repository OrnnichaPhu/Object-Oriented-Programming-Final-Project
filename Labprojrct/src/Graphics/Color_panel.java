package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import System.PatternGenerate;

public class Color_panel extends JPanel implements ActionListener {
	public static boolean colorChange; 
	
	private Font myfont = new Font("SanSerif", Font.BOLD,15);
	JLabel colourLB = new JLabel(" Select Color: ",10);
	JRadioButton PinkRT = new JRadioButton("Pink");
	JRadioButton YellowRT = new JRadioButton("Yellow");
	JRadioButton BlueRT = new JRadioButton("Blue");
	
	Color_panel(){
		this.setLayout(new GridLayout(5,1,4,1));
		
		this.add(colourLB);
		colourLB.setFont(myfont);
	
		
		this.add(PinkRT);
		PinkRT.setFont(myfont);
		
		this.add(YellowRT);
		YellowRT.setFont(myfont);
		
		this.add(BlueRT);
		BlueRT.setFont(myfont);

		
		this.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.gray));
		
		this.setPreferredSize(new Dimension(150, 570));
		
		PinkRT.addActionListener(this);
		YellowRT.addActionListener(this);
		BlueRT.addActionListener(this);
		
		PinkRT.setSelected(true);
		
	}

	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == PinkRT) {
			PinkRT.setSelected(true);
			YellowRT.setSelected(false);
			BlueRT.setSelected(false);
			PatternGenerate.PatternC  = Color.PINK;
			PatternGenerate.pressPattern = Color.WHITE;
			colorChange = true;
	
			
		}
		else if(e.getSource() == YellowRT) {
			YellowRT.setSelected(true);
			PinkRT.setSelected(false);
			BlueRT.setSelected(false);
			PatternGenerate.PatternC = Color.YELLOW;
			PatternGenerate.pressPattern = Color.RED;
			colorChange = true;
			
		}
		else {
			BlueRT.setSelected(true);
			PinkRT.setSelected(false);
			YellowRT.setSelected(false);
			PatternGenerate.PatternC = Color.BLUE;
			PatternGenerate.pressPattern = Color.LIGHT_GRAY;
			colorChange = true;
		
		}
		
	}

}
