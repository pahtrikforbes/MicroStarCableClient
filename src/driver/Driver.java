package driver;

import javax.swing.JFrame;

import ResponseView.addResponse;
import ResponseView.viewAllResponse;
import complaintsViews.ComplaintView;
import complaintsViews.DisplayAllResponses;
import controllers.ComplaintController;
import controllers.UserController;
import models.Complaint;
import models.User;
import utils.ComplaintCategory;
import utils.ComplaintStatus;
import utils.CustomizedException;
import utils.Role;
import views.*;

public class Driver {

	public static void main(String[] args) {

		 //new SplashScreen();
		
		JFrame test=  new JFrame();
		test.setSize(900,580);
		addResponse ar= new addResponse();
		DisplayAllResponses var = new DisplayAllResponses();
		test.add(ar);
		test.setVisible(true);
		
		//new ParentWindow(Role.REPRESENTATIVE, new User("Patrick","", null, null, null, null));

		/*
		ComplaintController cc = new ComplaintController();
		try {
			Complaint c1 = cc.findById(31);
			c1.setComplaintStatus(ComplaintStatus.RESOLVED);
			cc.updateComplaint(c1);
			System.out.println("Completetd!");
		} catch (CustomizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		UserController uc = new UserController();
		try {
			User u1 = uc.findById(1730);
			u1.setFirstName("Monkey");
			uc.updateUser(u1);
			System.out.println("Completetd!");
		} catch (CustomizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	
}













