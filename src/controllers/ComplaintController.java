package controllers;

import java.io.IOException;
import java.util.ArrayList;
import client.Client;
import models.Complaint;
import utils.CustomizedException;

public class ComplaintController {
	
	private Client client;
	
	public ComplaintController() {
		this.client = new Client();
		this.client.setEndPoint("complaint");
	}
	
	public int createComplaint(Complaint complaint) throws CustomizedException{
		 int complaintId = -1;
		 client.setOperation("createComplaint");
		
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(complaint);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintId = (int)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return complaintId;
	}

//	*************************************************************************	


	
	/* Method to  READ all the complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
//	*************************************************************************	

	
	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllMildComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllMildComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
	
//	*************************************************************************	

	
	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllModerateComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllModerateComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
//	*************************************************************************	


	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllSevereComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllSevereComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}

//	*************************************************************************	

	
	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllBroadbandComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllBroadbandComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}

//	*************************************************************************	
	
	
	/* Method to  READ all MILD complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllCableComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllCableComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}

//	*************************************************************************	
	

	/* Method to  READ all RESOLVED Cable complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllResolvedCableComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllResolvedCableComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
//	*************************************************************************	


	/* Method to  READ all RESOLVED Cable complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllResolvedBroadbandComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllResolvedBroadbandComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}	
	
	
//	*************************************************************************	


	/* Method to  READ all OUTSTANDING Cable complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllOutstandingCableComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllOutstandingCableComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}
	
//	*************************************************************************	


	/* Method to  READ all OUTSTANDING Cable complaints returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllOutstandingBroadbandComplaints() throws CustomizedException {
		ArrayList<Complaint> complaintList = new ArrayList<>();

		 client.setOperation("getAllOutstandingBroadbandComplaints");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return complaintList;
	}	
	
	
//	*************************************************************************	

	
	/* Method to accept a user id and returns an ArrayList of complaints
	that are tied to that specific User from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getComplaintsPerUser(int userId) throws CustomizedException {
		ArrayList<Complaint> userComplaintList = new ArrayList<>();
		client.setOperation("getAllUserComplaints");	
		
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				userComplaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return userComplaintList;
	}
	
	
//	*************************************************************************	
	
	/* Method to accept a user id and returns an ArrayList of complaints
	that are tied to that specific User from database through network stream  */
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getComplaintsPerTechnician(int userId) throws CustomizedException {
		ArrayList<Complaint> userComplaintList = new ArrayList<>();
		client.setOperation("getAllTechnicianAssignedComplaints");	
		
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(userId);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				userComplaintList = (ArrayList<Complaint>)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return userComplaintList;
	}
	
//	*************************************************************************	

	/* Method to READ one complaint. Returns a single complaint. */
	public Complaint findById(int complaintId) throws CustomizedException {
		System.out.println("Now in ComplaintController find by id (client)");
		
		Complaint complaint = null;
		System.out.println("Complaint complaint = null");
		
		client.setOperation("findById");
		System.out.println("now past  client.setOperation(\"findById\"");
		
		try {
			client.initDataStreams();
			System.out.println("DataStreams int");
			
			client.getObjectOutStream().writeObject(client.getOperation());
			System.out.println("getOperation");
			
			client.getObjectOutStream().writeObject(client.getEndPoint());
			System.out.println("EndPoint");
			
			client.getObjectOutStream().writeObject(complaintId);
			System.out.println("now past get object out streem");
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				complaint = (Complaint)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
		return complaint;
	}
	

//	*************************************************************************	

	
	/*Method to UPDATE a complaint*/
	public Complaint updateComplaint(Complaint updatedComplaint) throws CustomizedException {
		System.out.println("Entering client side update");
		System.out.println("updatedComplaint:\n"+updatedComplaint);
		
		Complaint complaint = null;
		client.setOperation("updateComplaint");
		try {
			
			client.initDataStreams();
			System.out.println("\nEntering try block");
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedComplaint);
			System.out.println("Writing complaint to server");
			
			String success = (String)client.getObjectInStream().readObject();
			System.out.println(success);
			
			if(success.equalsIgnoreCase("success")) {
				complaint = (Complaint)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		}
		  catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return complaint;
	}

	
//	*************************************************************************	

	
	/*Method to assign a Technician to a Complaint*/
	public Complaint assignTechnician(Complaint assignComplaint) throws CustomizedException {
		Complaint complaint = null;
		
		client.setOperation("assignTechnician");
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(assignComplaint);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				 complaint = (Complaint)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		}
		  catch (Exception e) {
			// TODO: handle exception
			  throw new CustomizedException(e.getMessage());
		}	
		return complaint;
	}
	
	
//	*************************************************************************	
	
	/*Method to delete complaint*/
	public int deleteComplaint(int complaintId) throws CustomizedException {
		int result = -1;
		client.setOperation("deleteComplaint");
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			client.getObjectOutStream().writeObject(complaintId);
			 
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				result = (int)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e.getMessage());
		}
	   return result;
	}
	
}