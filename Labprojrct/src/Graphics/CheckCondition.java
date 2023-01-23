package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import System.GameCalculator;

class CheckCondition implements ActionListener {
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(LifePanel.LifeChange == true) {
			LifePanel.LifeRepaint.start();
			LifePanel.checkLife.stop();
		}
		else if(LifePanel.LifeChange != true) {
			LifePanel.LifeRepaint.stop();
		}

	}

}

