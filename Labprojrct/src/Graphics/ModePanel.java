package Graphics;

import javax.swing.*;

import System.GameCalculator;
import System.dataSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ModePanel extends JPanel implements ItemListener, ActionListener{
	
	static Timer checkRun = new Timer(1,null);
	
	static Timer checkReset = new Timer(1,null);
	
	Checkstart checkstart = new Checkstart();
	
	static JButton startBT = new JButton("START");
	
	static JButton resetBT = new JButton("RESET");
	
	JLabel modeLB = new JLabel("Mode: ");
	
	static JCheckBox easyCB = new JCheckBox("Easy");
	
	static JCheckBox normalCB = new JCheckBox("Normal");
	
	static JCheckBox hardCb = new JCheckBox("Hard");
	
	public static JCheckBox EndlessCb = new JCheckBox("Endless");
	
	
	ModePanel(){
		
		this.setSize(550, 45);
		
		setPreferredSize(new Dimension(550,45));
		this.setBorder(BorderFactory.createEtchedBorder(Color.lightGray, Color.gray));
		
		add(modeLB);
		add(easyCB);
		add(normalCB);
		add(hardCb);
		add(EndlessCb);
		add(startBT);
		add(resetBT);
		
		startBT.addActionListener(checkstart);
		resetBT.addActionListener(checkstart);
		
		checkRun.addActionListener(this);
		checkReset.addActionListener(checkstart);
		
		
		easyCB.addItemListener(this);
		normalCB.addItemListener(this);
		hardCb.addItemListener(this);
		
		
		normalCB.setSelected(true);
		
		
	
	
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(GameCalculator.GameStart == true) {
			if(normalCB.isSelected() == true) {
				//normalCB.setSelected(true);
				hardCb.setSelected(false);
				easyCB.setSelected(false);
				dataSystem.delay = 1000;
				Checkstart.isReset = true;
	
				checkReset.start();
		
				
			}
			else if(easyCB.isSelected() == true) {
				//easyCB.setSelected(true);
				normalCB.setSelected(false);
				hardCb.setSelected(false);
				dataSystem.delay = 2000;
				Checkstart.isReset = true;
			
				checkReset.start();
				
			}
			else {
				//hardCb.setSelected(true);
				normalCB.setSelected(false);
				easyCB.setSelected(false);
				dataSystem.delay = 500;
				
				Checkstart.isReset = true;
				checkReset.start();
			}
		}
		
		
		else { 
			if(e.getSource() == normalCB) {
				//normalCB.setSelected(true);
				hardCb.setSelected(false);
				easyCB.setSelected(false);
				dataSystem.delay = 1000;
				
				if(GameCalculator.Stagecount>1) {
					dataSystem.delay += dataSystem.timePlus;
				}

				
			}
			else if(e.getSource() == easyCB) {
				//easyCB.setSelected(true);
				normalCB.setSelected(false);
				hardCb.setSelected(false);
				dataSystem.delay = 2000;
		
				if(GameCalculator.Stagecount>1) {
					dataSystem.delay += dataSystem.timePlus;
				}
		
				
			}
			else {
				//hardCb.setSelected(true);
				normalCB.setSelected(false);
				easyCB.setSelected(false);
				dataSystem.delay = 500;
	
				if(GameCalculator.Stagecount>1) {
					dataSystem.delay += dataSystem.timePlus;
				}
				
			}
		}
	}
		
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Checkstart.isRun == true) {
			easyCB.setEnabled(false);
			normalCB.setEnabled(false);
			hardCb.setEnabled(false);
			EndlessCb.setEnabled(false);
			startBT.setEnabled(false);
			resetBT.setEnabled(false);
		}
		else {
			easyCB.setEnabled(true);
			normalCB.setEnabled(true);
			hardCb.setEnabled(true);
			//EndlessCb.setEnabled(false);
			startBT.setEnabled(true);
			resetBT.setEnabled(true);
			
			checkRun.stop();
		}
		
	}
	
	


	

}
