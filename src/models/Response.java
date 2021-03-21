package models;

/*This class will serve as the user domain object.
 * it will map to the users table in the mysql database
 * 
 * */

import java.util.Date;


public class Response {
	
	private int response_id;
	
	private Complaint complaint_id;
	
	private Date response_date;
	
	private String response;
	
	
	
	
	//constructors
	
	public Response() {
		this(null,null,""); // initialize variables using primary constructor to promote code reuse 
	}

	public Response(Complaint complaint_id, Date response_date, String response) {
		
		this.complaint_id = complaint_id;
		this.response_date = response_date;
		this.response = response;
		
	}
	
	public Response(final Response response) {
		
		this.complaint_id = response.complaint_id;
		this.response_date = response.response_date;
		this.response = response.response;
	}

//getters and setters
	

	public int getResponse_id() {
		return response_id;
	}


	public void setResponse_id(int responses_id) {
		this.response_id = responses_id;
	}


	public Complaint getComplaint_id() {
		return complaint_id;
	}


	public void setComplaint_id(Complaint complaint_id) {
		this.complaint_id = complaint_id;
	}


	public Date getResponse_date() {
		return response_date;
	}


	public void setResponse_date(Date response_date) {
		this.response_date = response_date;
	}


	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Responses [responses_id=" + response_id + ", complaint_id=" + complaint_id + ", response_date="
				+ response_date + ", response=" + response + "]";
	}

	
	

}
