package controllers;

import models.User;
import utils.CustomizedException;
import utils.Role;

public class UserViewController {

	public static void main(String[] args) {
		System.out.println("Test");
		
		User u1 = new User("Jacob",
				"Richards",
				"jrichi@gmail.com",
				"pass123",
				Role.TECHNICIAN);
		
		UserController uc1 = new UserController();
		try {
			uc1.createUser(u1);
			System.out.println("Success!!!");
		} catch (CustomizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
