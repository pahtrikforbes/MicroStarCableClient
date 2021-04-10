package view;
import java.awt.Container;

import java.awt.EventQueue;

import javax.swing.GroupLayout;

import javax.swing.ImageIcon;

import javax.swing.JComponent;

import javax.swing.JFrame;

import javax.swing.JLabel;

import login.UserLogin;


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class loading extends JFrame {
	
	public  loading() {
		 JFrame frame = new JFrame("Please wait");

		    ImageIcon loading = new ImageIcon("src/logo/loading.gif");
		    frame.add(new JLabel("loading... ", loading, JLabel.CENTER));

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(400, 200);
		    frame.setVisible(true);
		    frame.setLocationRelativeTo(null);
	}
	   
	    public static void main(String[] args) throws Exception {
	    	new loading();
	}
}
/*
 

public class SplashPage extends JFrame {

    public SplashPage() { 
        initUI();
  
    }

    private void initUI() {       

        ImageIcon ii = loadImage();
        JLabel label = new JLabel(ii);
        createLayout(label);
        setTitle("Micro Star Cable Company");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private ImageIcon loadImage() {
        ImageIcon ii = new ImageIcon("src/logo/microImage.png");
        return ii;
    }

    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()

                .addComponent(arg[0])

        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );
        pack();
 
    }

    public static void main(String[] args) {
    	
    	SplashPage ex = new SplashPage();
       // ex.setVisible(true);
        
        EventQueue.invokeLater(new Runnable() {
  
			@Override
			public void run() {
				try {
		            Thread.sleep(3000);
		            new UserLogin();
		            ex.dispose();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
          });
       
    }
}
*/

