package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import models.User;
import utils.Role;

public class ParentWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JDesktopPane desktop;
	private MainView mainView;
	
	public ParentWindow(Role role,User user) {
		desktop = new JDesktopPane();
		mainView = new MainView(role, user);
		showForm();	
	}
	
	 private void createWindow()
	    {
	       //Setting properties of JFrame; i.e this frame
		    this.setSize(1400,800);
	        this.setLayout(null);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(false);
	        this.setVisible(true);
	    }
	 
	 private void setLocationAndSize() {
		 desktop.setBounds(0,0,1400,800);
	     desktop.setBackground(Color.white);
	     
	 }
	 
	 private void addComponentsToFrame() {
		 desktop.add(mainView);
		 this.add(desktop);
	 }
	 
	 private void showForm() {
		 createWindow();
		 setLocationAndSize();
		 addComponentsToFrame();
	 }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
