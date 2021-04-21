

package controllers;

import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import models.Response;
import utils.CustomizedException;

public class ResponseController {
	
	private Client client;
	
	public ResponseController() {
		this.client = new Client();
		this.client.setEndPoint("response");
	}


	public int createResponse(Response response) throws CustomizedException{
		 
		System.out.println("Test7");
		int responseId = -1;
		 client.setOperation("createResponse");
		
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			System.out.println("Test5");
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(response);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				responseId = (int)client.getObjectInStream().readObject();
			}
			else {
				CustomizedException e = (CustomizedException)client.getObjectInStream().readObject();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			throw new CustomizedException(e1.getMessage());
		}
	   
	   return responseId;
	}
	
	
	/* Method to  READ all the responses returned from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Response> getAllResponses() throws CustomizedException {
		ArrayList<Response> responseList = new ArrayList<>();

		 client.setOperation("getAllResponses");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				responseList = (ArrayList<Response>)client.getObjectInStream().readObject();
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
	    
	    return responseList;
	}
	
	
	/* Method to accept a user id and returns an ArrayList of Responses
	that are tied to that specific User from database through network stream */
	@SuppressWarnings("unchecked")
	public ArrayList<Response> getResponsesPerUser(int complaintId) throws CustomizedException {
		ArrayList<Response> userResponseList = new ArrayList<>();

		 client.setOperation("getResponsesPerComplaint");
	    
	    try {
	    	client.initDataStreams();
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(complaintId);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				userResponseList = (ArrayList<Response>)client.getObjectInStream().readObject();
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
	    
	    return userResponseList;
	}
	
	
	/* Method to READ one Response. Returns a single Response. */
	public Response findById(int responseId) throws CustomizedException {
		
		Response response = null;
		client.setOperation("findById");
		
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(responseId);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				response = (Response)client.getObjectInStream().readObject();
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
		
		return response;
	}
	

	/*Method to UPDATE a response*/
	public Response updateResponse(Response updatedResponse) throws CustomizedException {
		Response response = null;
		client.setOperation("updateResponse");
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedResponse);
			
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				response = (Response)client.getObjectInStream().readObject();
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
		return response;
	}
	
	
	/*Method to assign a Technician to a Response*/
	public Response assignTechnician(Response assignResponse) throws CustomizedException {
		Response response = null;
		
		client.setOperation("assignTechnician");

		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(assignResponse);
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				response = (Response)client.getObjectInStream().readObject();
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
		return response;
	}
	
	
	/*Method to delete response*/
	public int deleteResponse(int responseId) throws CustomizedException {
		int result = -1;
		client.setOperation("deleteResponse");
	
		try {
			client.initDataStreams();
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			client.getObjectOutStream().writeObject(responseId);
			 
			String success = (String)client.getObjectInStream().readObject();
			
			if(success.equalsIgnoreCase("success")) {
				responseId = (int)client.getObjectInStream().readObject();
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
