package driver;

import java.io.IOException;

import javax.swing.JFrame;

import ResponseView.addResponse;
import models.User;
import utils.Role;
import views.*;

public class Driver {

	public static void main(String[] args) {

		//new SplashScreen();
		
		//new ParentWindow(Role.REPRESENTATIVE, new User("Patrick","", null, null, null, null));
		
		JFrame jf = new JFrame();
		ChatView cv;
		try {
			cv = new ChatView();
			cv.showForm();
			jf.add(cv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jf.setSize(900,900);
		
		
        jf.setVisible(true);
		
	}
	
}













