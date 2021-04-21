package models;

import java.io.Serializable;

/*This class will serve as the user domain object.
 * it will map to the users table in the mysql database
 * 
 * */

import utils.Role;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	
	private String firstName;

	private String lastName;
	
	private String email;
	
	private String password;
	 
	private Role role;
	
	private String contactNum;
	 
	//constructors
	
	public User() {

		this("","","","",null,""); // initialize variables using primary constructor to promote code reuse 
	}


	public User(String firstName, String lastName, String email,
			String password, Role role, String contactNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.contactNum = contactNum;
	}
	
	public User(final User user) {
		this.userId = user.userId;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email;
		this.role = user.role;
		this.password = user.password;
		this.contactNum = user.contactNum;
	}

//getters and setters
	public int getUserId() {
		return this.userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return this.firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return this.lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return this.password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
  
	
	public Role getRole() {
		return this.role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	public String getContactNum() {
		return contactNum;
	}


	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	@Override
	public String toString() {
		return "\nUser \nUser Id: " + userId + "\nfirstName: " + firstName + "\nlastName: " + lastName + "\nemail: " + email
				+ "\npassword: " + password + "\nrole: " + role + "\n"+ contactNum + "\n";
	}
	
	
	
	

}
