package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import controllers.UserController;
import models.User;
import utils.CustomizedException;
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
		 this.setTitle("Micro-Star Main Window");
		    this.setSize(1200,720);
	        this.setLayout(null);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(false);
	        this.setVisible(true);
	        
	    }
	 
	 private void setLocationAndSize() {
		 desktop.setBounds(0,0,1200,720);
	     desktop.setBackground(Color.WHITE);
	     
	 } 
	 
	 private void addComponentsToFrame() {
		
		 this.add(desktop);
		 if(desktop.isShowing() == true) {
			 desktop.add(mainView);
			 desktop.moveToFront(mainView);
			 mainView.setSize(desktop.getWidth(), desktop.getHeight());
			 mainView.setLocation(0, 0);
		 }
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
	
	
	public static void main(String[] args) {
		
		User user = new User("Jill", "Jack", "",Role.REPRESENTATIVE, "", "");
		new ParentWindow(user.getRole(), user);
		
		
	}
		
}














