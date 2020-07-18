package com.webapp.service;

import java.util.ArrayList;

import com.webapp.bean.CurrentHawkerDetails;
import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.HawkerRegister;
import com.webapp.bean.Login;
import com.webapp.bean.Request;

public interface HawkerService {
	
	public boolean checkHawkerLogin(Login user);
	public boolean saveHawker(HawkerRegister register);
	public HawkerDetails getHawkerDetails(String username);
	public boolean updateHawker(HawkerDetails hd);
	public ArrayList<CustomerDetails> getCustomerRequests(String hawkerUsername);
	public boolean requestAccept(Request r);
	ArrayList<CustomerDetails> getCurrentCustomers(String hawkerUsername);
	public CurrentHawkerDetails getCurrentHawkerDetails(Request request);
	public Request getRequestAcceptDate(Request request);

}
