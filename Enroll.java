package mypack;

import java.io.Serializable;

public class Enroll implements Serializable 
{
	public String userName;
	public String courseName;
	public String paymentStatus;
	public Enroll()
	{
		
	}
	public Enroll(String userName, String courseName, String paymentStatus) {
		super();
		this.userName = userName;
		this.courseName = courseName;
		this.paymentStatus = paymentStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Enroll [userName=" + userName + ", courseName=" + courseName + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
	
	

}
