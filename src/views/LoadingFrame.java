package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class LoadingFrame {
  
	    /**
	 * 
	 */

	static Timer timer;
	
		public static void main(String[] args){
	    	JFrame frame = new JFrame("Progress Bar");
	    	frame.setBounds(100,100,394,269);
	    	frame.setVisible(true);
	    	frame.setLayout(null);
	    	
	    	JButton btn = new JButton("Click");
	    	
	    	btn.setBounds(12,12,50,23);
	    	frame.add(btn);
	    	
	    	btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("Btn pressed");
						timer.start();
					
				}
	    		
	    	});
	    	
	    	JProgressBar progress = new JProgressBar();
	    	progress.setBounds(106,37,175,29);
	    	progress.setVisible(true);
	    	progress.setForeground(Color.GREEN);
	    	progress.setBackground(Color.LIGHT_GRAY);
	    	progress.setBorder(new LineBorder(Color.DARK_GRAY));
	    	frame.add(progress);
	    	
	    	timer = new Timer(1000, new ActionListener()  {
	    		private int x = 0;

				@Override
				public void actionPerformed(ActionEvent e) {
					progress.setValue(x++);
					if (x==100) {
						timer.stop();
						frame.dispose();
						x=0;
					}
				}	
	    	});
	    	
	    	
	    	
	    	
		}
}

