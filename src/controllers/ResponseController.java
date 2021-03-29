package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import client.Client;
import models.Response;
import serverconnector.ServerConnector;
import utils.CustomizedException;

public class ResponseController {
	
	private Client client;
	
	public ResponseController() {
		this.client = new Client();
	}


	public int createResponse(Response response) throws CustomizedException{
		 int responseId = -1;
		 client.setOperation("createResponse");
		 client.setEndPoint("response");
		 
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(response);
			 try {
				responseId = (int)client.getObjectInStream().readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	   
	   return responseId;
	}
	
	
	/* Method to  READ all the responses returned from database through network stream */
	public ArrayList<Response> getAllResponses() throws CustomizedException {
		ArrayList<Response> responseList = new ArrayList<>();

		 client.setOperation("getAllResponses");
		 client.setEndPoint("response");
	    
	    try {
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			responseList = (ArrayList<Response>)client.getObjectInStream().readObject();
		} catch (Exception e) {
			// TODO manage and log exceptions
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	    
	    return responseList;
	}
	
	
	/* Method to accept a user id and returns an ArrayList of Responses
	that are tied to that specific User from database through network stream */
	public ArrayList<Response> getResponsesPerUser(int responseId) throws CustomizedException {
		ArrayList<Response> userResponseList = new ArrayList<>();

		 client.setOperation("getAllUserResponses");
		 client.setEndPoint("response");
	    
	    try {
	    	client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			userResponseList = (ArrayList<Response>)client.getObjectInStream().readObject();
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
		client.setEndPoint("response");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(responseId);
			
			response = (Response)client.getObjectInStream().readObject();
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
		client.setEndPoint("response");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(updatedResponse);
		    response = (Response)client.getObjectInStream().readObject();
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
		client.setEndPoint("response");
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			client.getObjectOutStream().writeObject(assignResponse);
		    response = (Response)client.getObjectInStream().readObject();
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
		client.setEndPoint("response");
		
		try {
			client.getObjectOutStream().writeObject(client.getOperation());
			client.getObjectOutStream().writeObject(client.getEndPoint());
			
			client.getObjectOutStream().writeObject(responseId);
			 
			 
			 try {
				 responseId = (int)client.getObjectInStream().readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CustomizedException(e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomizedException(e.getMessage());
		}
	   return result;
	}
		
	
}


















