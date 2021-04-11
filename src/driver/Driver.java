package driver;
import complaintsViews.ComplaintView;
import controllers.UserController;
import models.User;
import utils.CustomizedException;
import utils.Role;
import views.*;

import java.io.IOException;

import javax.swing.JFrame;
import views.ChatView;

public class Driver {

	public static void main(String[] args) {
		

		ChatView cv;
		try {
			cv = new ChatView();
			JFrame jf = new JFrame();
			cv.showForm();
			jf.add(cv);
			
			jf.setVisible(true);
			jf.setSize(500,700);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

















