package models;

import java.util.Date;

import utils.ComplaintCategory;
import utils.ComplaintType;



/*This class will serve as the complaints domain object.
 * it will map to the complaints table in the mysql database
 * 
 * */

public class Complaint {

	private int complaintID;
	
	private int custID;
	
	private int empID;
	
	private ComplaintCategory category;

	private String complaint;
	
	private Date complaintDate;
	
	private ComplaintType complaintType;

	
	public Complaint() {
		this.custID = 0;
		this.empID = 0;
		this.category = null;
		this.complaint = "";
		this.complaintDate =  new Date();
		this.complaintType = null;
	}
	
	public Complaint(int custID, int empID, ComplaintCategory category, String complaint, Date complaintDate,
			ComplaintType complaintType) {
		this.custID = custID;
		this.empID = empID;
		this.category = category;
		this.complaint = complaint;
		this.complaintDate = complaintDate;
		this.complaintType = complaintType;
	}
	
	
	public Complaint(final Complaint c ) {
		this.complaintID = c.complaintID;
		this.custID = c.custID;
		this.empID = c.empID;
		this.category = c.category;
		this.complaint = c.complaint;
		this.complaintDate = c.complaintDate;
		this.complaintType = c.complaintType;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public ComplaintCategory getCategory() {
		return category;
	}

	public void setCategory(ComplaintCategory category) {
		this.category = category;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public ComplaintType getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(ComplaintType complaintType) {
		this.complaintType = complaintType;
	}

	@Override
	public String toString() {
		return "\nComplaints \ncomplaintID: " + complaintID + "\ncustID: " + custID +
				"\nempID: " + empID + "\ncategory: "
				+ category + "\ncomplaint: " + complaint + "\ncomplaintDate: " + complaintDate + 
				"\ncomplaintType: "
				+ complaintType + "\n";
	}
	
	
	
}
