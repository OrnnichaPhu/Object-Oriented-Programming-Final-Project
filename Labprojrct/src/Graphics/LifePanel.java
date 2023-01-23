package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import System.*;

public class LifePanel extends JPanel implements ActionListener {
	
	public static boolean LifeChange = false;
	
	CheckCondition Lifecontrol = new CheckCondition();

	static Timer checkLife = new Timer(1,null);
	
	static Timer LifeRepaint = new Timer(500,null);
	
	private boolean show = true;
	
	private Font myfont = new Font("SanSerif", Font.BOLD,30);
	

	int[] xHeart = {40,15,15,25,40,55,65,65};
	int[] xHeart2 = {110 , 85,85,95,110,125,135,135};
	int[] xHeart3 = {180 , 155,155,165 ,180,195,205,205};
	
	int[] yHeart = {70,38,25,10,30,10,25,38};
	
	

	LifePanel(){
		this.setLayout(null);
        //this.setLocation(50, 50);
        //this.setSize(300, 300);eF.setLayout(null);
		//this.setLocation(10, 10);
		this.setSize(225, 80);
		this.setPreferredSize(new Dimension(225, 80));
		this.setBackground(Color.white);
		
		checkLife.addActionListener(Lifecontrol);
		checkLife.start();
		LifeRepaint.addActionListener(this);
		//this.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.gray));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		
		if(GameCalculator.Gameover != true) {
			if(GameCalculator.Lifecount == 3) {
				
				g.fillPolygon(xHeart, yHeart, xHeart.length);

				g.fillPolygon(xHeart2, yHeart, xHeart2.length);
			
				g.fillPolygon(xHeart3, yHeart, xHeart3.length);
			}
			else if(GameCalculator.Lifecount == 2) {
				
				g.fillPolygon(xHeart, yHeart, xHeart.length);

				g.fillPolygon(xHeart2, yHeart, xHeart2.length);
			
			}
			else if(GameCalculator.Lifecount == 1) {
				g.fillPolygon(xHeart, yHeart, xHeart.length);
			}
			else {
				GameCalculator.Gameover = true;
				GameCalculator.GameStart = false;
				LifePanel.LifeChange = true;
			}
		}
		else
			if(show == true){
				
				g.setFont(myfont);
				
				g.setColor(Color.RED);
				
				g.drawString("GAME OVER!", 14, 49);
				show = !show;
			}
			else {
				show = !show;
			}
			
		
	


	}


	public void actionPerformed(ActionEvent e) {
		if(GameCalculator.Gameover != true) {
			LifeChange = false;
			repaint();
			LifePanel.checkLife.start();
		}
		else {
			repaint();
			
		
		
		
	} 

		
	}
}