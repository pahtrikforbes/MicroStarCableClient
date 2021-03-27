package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import controllers.AccountController;
import controllers.AuthController;
import controllers.ComplaintController;
import controllers.ResponseController;
import controllers.UserController;
import models.Account;
import models.Complaint;
import models.Response;
import models.User;
import serverconnector.ServerConnector;
import utils.CustomizedException;
import utils.Role;

public class Client {

	private ObjectOutputStream objectOutStream;
	private ObjectInputStream objectInStream;
	private Socket socket;
	
	private AccountController accountController;
	private AuthController authController;
	private ComplaintController complaintController;
	private ResponseController responseController;
	private UserController userController;

	public Client() {
		try {
			this.socket = new Socket("localhost",3600);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean sendUserData(String operation, User user) throws CustomizedException {
		
		try {
			
			initDataStreams();
			objectOutStream.writeObject(operation); 
		    objectOutStream.writeObject("user"); //endpoint variable
		    
		    switch (operation.toLowerCase()) {
		      case "createuser": 
				int returnUserId = this.userController.createUser(user);
				break;
		    }
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		
		return true;
	}
	public void sendData(String operation,String endPoint) {
		System.out.println("sending data");
		try {
			
			  
			  objectOutStream.writeObject(operation); 
			  objectOutStream.writeObject(endPoint);
			  
			  switch (endPoint.toLowerCase()) {
				case "account":
					switch (operation.toLowerCase()) {
					case "createaccount": 
						Account acctToCreate = (Account)this.objectInStream.readObject();
						int newAccountId = accountController.createAccount(acctToCreate);
						this.objectOutStream.writeObject(newAccountId);
						break;
					case "updateaccount": 
						Account accToUpdate = (Account)this.objectInStream.readObject();
						Account updatedAccount = accountController.updateAccount(accToUpdate);
						this.objectOutStream.writeObject(updatedAccount);
						break;
					case "findbyid": 
						int acctIdToFind = (int)this.objectInStream.readObject();
						Account acctFound = accountController.findById(acctIdToFind); 
						this.objectOutStream.writeObject(acctFound);
						break;
					case "deleteaccount": 
						int deleteAcctId = (int)this.objectInStream.readObject();
						int deletedId = accountController.deleteAccount(deleteAcctId);
						this.objectOutStream.writeObject(deletedId);
						break;
					case "getallaccounts": 
						ArrayList<Account> accountList = this.accountController.getAllAccounts();
						this.objectOutStream.writeObject(accountList);
						break; 
					default:
						throw new IllegalArgumentException("Unexpected value: " + operation.toLowerCase());
					}
					break;
					
				//AuthenticationController
				case "auth":
					switch (operation.toLowerCase()) {
					case "login": 
						int loginUserId = (int)this.objectInStream.readObject();
						String password = (String)this.objectInStream.readObject();
						Role role = (Role)this.objectInStream.readObject();
						boolean loginSuccess = this.authController.login(loginUserId, password, role);
						this.objectOutStream.writeObject(loginSuccess);
						break;
					case "updatepassword":
						int updatePasswordUserId = (int)this.objectInStream.readObject();
						String oldPassword = (String)this.objectInStream.readObject();
						String newPassword = (String)this.objectInStream.readObject();
						boolean passwordUpdated = this.authController.updatePassword(updatePasswordUserId, oldPassword, newPassword);
						this.objectOutStream.writeObject(passwordUpdated);
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + operation.toLowerCase());
					}
					break;
				case "complaint":
					switch (operation.toLowerCase()) {
					case "createcomplaint": 
						Complaint complaint = (Complaint)this.objectInStream.readObject();
						int newComplaintId = this.complaintController.createComplaint(complaint);
						this.objectOutStream.writeObject(newComplaintId);
						break;
					case "updatecomplaint": 
						Complaint complaintId = (Complaint)this.objectInStream.readObject();
						Complaint complaintUpdate = this.complaintController.updateComplaint(complaintId);
						this.objectOutStream.writeObject(complaintUpdate);
						break;
					case "findbyid": 
						int comIdToFind = (int)this.objectInStream.readObject();
						Complaint returnFoundComplaint = this.complaintController.findById(comIdToFind);
						this.objectOutStream.writeObject(returnFoundComplaint);
						break;
					case "deletecomplaint": 
						int deleteId = (int)this.objectInStream.readObject();
						int returnDeleteId = this.complaintController.deleteComplaint(deleteId);
						this.objectOutStream.writeObject(returnDeleteId);
						break;
					case "getallcomplaints": 
						ArrayList<Complaint> returnComplaintList = this.complaintController.getAllComplaints();
						this.objectOutStream.writeObject(returnComplaintList);
						break;
					case "assigntechnician": 
						User technician = (User)this.objectInStream.readObject();
						
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + operation.toLowerCase());
					}
					break;
					//response 
				case "response":
					switch (operation.toLowerCase()) {
					case "addresponse": 
						Response responseToAdd = (Response)this.objectInStream.readObject(); 
						this.responseController.addResponse(responseToAdd);
						this.objectOutStream.writeObject("saved");
						break;
					case "updateresponse": 
						Response updateId = (Response) this.objectInStream.readObject();
						Response returnUpdateId = this.responseController.updateResponse(updateId);
						this.objectOutStream.writeObject(returnUpdateId);
						break;
					case "findbyid": 
						int findResponseId = (int)this.objectInStream.readObject();
						Response returnFoundResponseId = this.responseController.findById(findResponseId);
						this.objectOutStream.writeObject(returnFoundResponseId);
						break;
					case "deleteresponse": 
						int deleteResponseId = (int)this.objectInStream.readObject();
						int returnDeleteId = this.responseController.deleteResponse(deleteResponseId);
						this.objectOutStream.writeObject(returnDeleteId);
						break;
					case "getallresponses": 
						ArrayList<Response> returnAllResponse = this.responseController.getAllResponses();
						this.objectOutStream.writeObject(returnAllResponse);
						break;
					case "getresponsespercomplaint": 
						int complaintId = (int)this.objectInStream.readObject();
						ArrayList<Response> returnComplaint = this.responseController.getResponsesPerComplaint(complaintId);
						this.objectOutStream.writeObject(returnComplaint);
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + operation.toLowerCase());
					}
					break;
				case "user":
					switch (operation.toLowerCase()) {
					
					case "updateuser": 
						User userIdUpdate = (User) this.objectInStream.readObject();
						User returnUserIdUpdate = this.userController.updateUser(userIdUpdate);
						this.objectOutStream.writeObject(returnUserIdUpdate);
						break;
					case "findbyid": 
						int userId = (int)this.objectInStream.readObject();
						User returnFindUser = this.userController.findById(userId);
						this.objectOutStream.writeObject(returnFindUser);
						break;
					case "findbyemail": 
						String findByEmail = (String)this.objectInStream.readObject();
						boolean returnFindByEmail = this.userController.findByEmail(findByEmail);
						this.objectOutStream.writeObject(returnFindByEmail);
						break;
					case "deleteuser": 
						int deleteUser = (int)this.objectInStream.readObject();
						int returnDeleteUser= this.userController.deleteUser(deleteUser);
						this.objectOutStream.writeObject(returnDeleteUser);
						break;
					case "getallusers": 
						ArrayList<User> userList = this.userController.getAllUsers();
						this.objectOutStream.writeObject(userList);
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + operation.toLowerCase());
					}
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + endPoint.toLowerCase());
				}
			
			
			float result = 0;
			try {
				result = (float)objectInStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void initDataStreams() throws IOException{
		this.objectOutStream = new ObjectOutputStream(this.socket.getOutputStream());
		this.objectInStream = new ObjectInputStream(this.socket.getInputStream());
		
	}
	
}
