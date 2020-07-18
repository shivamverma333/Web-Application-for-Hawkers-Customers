package com.webapp.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;




public class LeaveDate {


private Date date;


private String customerUsername;
public String getCustomerUsername() {
	return customerUsername;
}

public void setCustomerUsername(String customerUsername) {
	this.customerUsername = customerUsername;
}

public String getHawkerUsername() {
	return hawkerUsername;
}

public void setHawkerUsername(String hawkerUsername) {
	this.hawkerUsername = hawkerUsername;
}

private String hawkerUsername;


public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

}
