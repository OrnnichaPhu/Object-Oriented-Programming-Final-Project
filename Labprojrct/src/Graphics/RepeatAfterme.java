package Graphics;

import javax.swing.*;
import java.awt.*;
import System.*;

class RepeatAfterme extends JFrame {
	
	InfoPanel info = new InfoPanel();
	Color_panel color = new Color_panel();
	PatternPanel pattern = new PatternPanel();
	ModePanel mode = new ModePanel();
	
	RepeatAfterme(){
		super("Repeat_After_Me_Lab_Project");
		this.setLayout(new BorderLayout());
		this.add(info, BorderLayout.NORTH);
		info.setPreferredSize(new Dimension(550, 100));
		
		this.add(color,BorderLayout.EAST);
		color.setPreferredSize(new Dimension(150, 470));
		
		this.add(pattern, BorderLayout.CENTER);
		pattern.setPreferredSize(new Dimension(390, 420));
		
		this.add(mode, BorderLayout.SOUTH);
		mode.setPreferredSize(new Dimension(550, 45));
		
		
		this.setVisible(true);
		this.setSize(550,560);
		this.setPreferredSize(new Dimension(400, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);


		
	}
	
	public static void main(String[] args) {
		new RepeatAfterme();
	
	}
	

}
