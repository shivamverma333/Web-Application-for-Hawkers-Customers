package com.webapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.webapp.bean.CurrentHawkerDetails;
import com.webapp.bean.CustomerDetails;
import com.webapp.bean.HawkerDetails;
import com.webapp.bean.HawkerRegister;
import com.webapp.bean.LeaveDate;
import com.webapp.bean.Login;
import com.webapp.bean.Register;
import com.webapp.bean.Request;
import com.webapp.util.DBConnection;

public class DAO {
	
	Connection connection;
	PreparedStatement statement;
	ResultSet resultSet;
	
	public DAO(){
		connection=DBConnection.openConnection();
	}
	
	public boolean checkLogin(Login user) {
		try {
			statement=connection.prepareStatement("select * from customer where username=? and password=?");
			statement.setString(1,user.getUsername());
			statement.setString(2, user.getPassword());
			resultSet=statement.executeQuery();
			if(resultSet.next())
				return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean saveCustomer(Register register) {
		try {
			int i;
			statement=connection.prepareStatement("insert into customer values(?,?);");
			statement.setString(1, register.getUsername());
			statement.setString(2, register.getPassword());
			i=statement.executeUpdate();
			if(i>0) {
				statement=connection.prepareStatement("insert into customerdetails values (?,?,?,?,?,?,?)");
				statement.setString(1,register.getUsername());
				statement.setString(2,register.getName());
				statement.setString(3,register.getEmail());
				statement.setString(4,register.getContact());
				statement.setString(5,register.getAddress());
				statement.setString(6,register.getState());
				statement.setString(7,register.getCity());
				i=statement.executeUpdate();
				if(i>0) {
					return true;
				}
				
			}
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean checkUsername(String username) {
		try {
			statement=connection.prepareStatement("select username from customer where username=?");
			statement.setString(1,username);
			resultSet=statement.executeQuery();
			if(!resultSet.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public ArrayList<HawkerDetails> findHawkers(String search) {
		ArrayList<HawkerDetails> list=new ArrayList<>();
		try {
			statement=connection.prepareStatement("select * from hawkerdetails where planName=?");
			statement.setString(1, search);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				HawkerDetails hd=new HawkerDetails();
				hd.setUsername(resultSet.getString(1));
				hd.setName(resultSet.getString(2));
				hd.setEmail(resultSet.getString(3));
				hd.setContact(resultSet.getString(4));
				hd.setAddress(resultSet.getString(5));
				hd.setState(resultSet.getString(6));
				hd.setCity(resultSet.getString(7));
				hd.setPlanName(resultSet.getString(8));
				hd.setPlanQuantity(resultSet.getString(9));
				hd.setPlanPrice(resultSet.getString(10));
				list.add(hd);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public CustomerDetails getCustomerDetails(String username) {
		CustomerDetails cd=new CustomerDetails();
		try {
			statement=connection.prepareStatement("select * from customerdetails where username=?");
			statement.setString(1,username);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				cd.setUsername(resultSet.getString(1));
				cd.setName(resultSet.getString(2));
				cd.setEmail(resultSet.getString(3));
				cd.setContact(resultSet.getString(4));
				cd.setAddress(resultSet.getString(5));
				cd.setState(resultSet.getString(6));
				cd.setCity(resultSet.getString(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cd;
		
	}
	
	public boolean updateCustomer(CustomerDetails cd) {
		try {
			statement=connection.prepareStatement("update customerdetails set name=? , email=? , contact=? , address=? , state=? , city=? where username= ?;");
			statement.setString(1, cd.getName());
			statement.setString(2, cd.getEmail());
			statement.setString(3, cd.getContact());
			statement.setString(4, cd.getAddress());
			statement.setString(5, cd.getState());
			statement.setString(6, cd.getCity());
			statement.setString(7, cd.getUsername());

			int i=statement.executeUpdate();
			if(i>0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean saveHawker(HawkerRegister register) {
		try {
			int i;
			statement=connection.prepareStatement("insert into hawker values(?,?);");
			statement.setString(1, register.getUsername());
			statement.setString(2, register.getPassword());
			i=statement.executeUpdate();
			if(i>0) {
				statement=connection.prepareStatement("insert into hawkerdetails values (?,?,?,?,?,?,?,?,?,?)");
				statement.setString(1,register.getUsername());
				statement.setString(2,register.getName());
				statement.setString(3,register.getEmail());
				statement.setString(4,register.getContact());
				statement.setString(5,register.getAddress());
				statement.setString(6,register.getState());
				statement.setString(7,register.getCity());
				statement.setString(8,register.getPlanName());
				statement.setString(9,register.getPlanQuantity());
				statement.setString(10,register.getPlanPrice());
				i=statement.executeUpdate();
				if(i>0) {
					return true;
				}
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public HawkerDetails getHawkerDetails(String username) {
		HawkerDetails hd=new HawkerDetails();
		try {
			statement=connection.prepareStatement("select * from hawkerdetails where username=?");
			statement.setString(1,username);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				hd.setUsername(resultSet.getString(1));
				hd.setName(resultSet.getString(2));
				hd.setEmail(resultSet.getString(3));
				hd.setContact(resultSet.getString(4));
				hd.setAddress(resultSet.getString(5));
				hd.setState(resultSet.getString(6));
				hd.setCity(resultSet.getString(7));
				hd.setPlanName(resultSet.getString(8));
				hd.setPlanQuantity(resultSet.getString(9));
				hd.setPlanPrice(resultSet.getString(10));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return hd;
	
	}
	
	public CurrentHawkerDetails getCurrentHawkerDetails(Request request) {
		CurrentHawkerDetails hd=new CurrentHawkerDetails();
		try {
			statement=connection.prepareStatement("select * from hawkerdetails where username=?");
			statement.setString(1,request.getHawkerUsername());
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				hd.setUsername(resultSet.getString(1));
				hd.setName(resultSet.getString(2));
				hd.setEmail(resultSet.getString(3));
				hd.setContact(resultSet.getString(4));
				hd.setAddress(resultSet.getString(5));
				hd.setState(resultSet.getString(6));
				hd.setCity(resultSet.getString(7));
				hd.setPlanName(resultSet.getString(8));
				hd.setPlanQuantity(resultSet.getString(9));
				hd.setPlanPrice(resultSet.getString(10));
				hd.setLeaveDates(getLeaveDates(request));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return hd;
	
	}
	
	public ArrayList<Date> getLeaveDates(Request request){
		ArrayList<Date> dates=new ArrayList<>();
		ResultSet resultSet2;
		try {
			statement=connection.prepareStatement("select leaveDate from leaveDates where customerUsername=? and hawkerUsername=?");
			statement.setString(1, request.getCustomerUsername());
			statement.setString(2, request.getHawkerUsername());
			resultSet2=statement.executeQuery();
			while(resultSet2.next()) {
				dates.add(resultSet2.getDate(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dates;
	}
	
	public boolean updateHawker(HawkerDetails hd) {
		try {
			statement=connection.prepareStatement("update hawkerdetails set name=? , email=? , contact=? , address=? , state=? , city=?, planName=? , planQuantity=? , planPrice=? where username= ?;");
			statement.setString(1, hd.getName());
			statement.setString(2, hd.getEmail());
			statement.setString(3, hd.getContact());
			statement.setString(4, hd.getAddress());
			statement.setString(5, hd.getState());
			statement.setString(6, hd.getCity());
			statement.setString(7, hd.getPlanName());
			statement.setString(8, hd.getPlanQuantity());
			statement.setString(9, hd.getPlanPrice());
			statement.setString(10, hd.getUsername());
			
			int i=statement.executeUpdate();
			if(i>0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkHawkerLogin(Login user) {
		try {
			statement=connection.prepareStatement("select * from hawker where username=? and password=?");
			statement.setString(1,user.getUsername());
			statement.setString(2, user.getPassword());
			resultSet=statement.executeQuery();
			if(resultSet.next())
				return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean saveRequest(Request r) throws SQLException {
			statement=connection.prepareStatement("insert into request values(?,?)");
			statement.setString(1,r.getCustomerUsername());
			statement.setString(2, r.getHawkerUsername());
			int i=statement.executeUpdate();
			if(i>0) {
				return true;
			}
		return false;
	}
	
	public ArrayList<HawkerDetails> getRequestedHawkers(String customerUsername){
		ArrayList<HawkerDetails> list=new ArrayList<>();
		try {
			ResultSet resultSet2;
			statement=connection.prepareStatement("select hawkerUsername from request where customerUsername=?;");
			statement.setString(1, customerUsername);
			resultSet2=statement.executeQuery();
			while(resultSet2.next()) {
			
				list.add(getHawkerDetails(resultSet2.getString(1)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<HawkerDetails> getCurrentHawkers(String customerUsername){
		ArrayList<HawkerDetails> list=new ArrayList<>();
		try {
			ResultSet resultSet2;
			statement=connection.prepareStatement("select hawkerUsername from requestaccept where customerUsername=?;");
			statement.setString(1, customerUsername);
			resultSet2=statement.executeQuery();
			while(resultSet2.next()) {
			
				list.add(getHawkerDetails(resultSet2.getString(1)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<CustomerDetails> getCustomerRequests(String hawkerUsername){
		ResultSet resultSet2;
		ArrayList<CustomerDetails> list=new ArrayList<>();
		try {
			statement=connection.prepareStatement("select customerUsername from request where hawkerUsername=?;");
			statement.setString(1,hawkerUsername);
			resultSet2=statement.executeQuery();
			while(resultSet2.next()) {
				list.add(getCustomerDetails(resultSet2.getString(1)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean requestAccept(Request r) {
		try {
			statement=connection.prepareStatement("insert into requestAccept values(?,?,?);");
			statement.setString(1, r.getCustomerUsername());
			statement.setString(2, r.getHawkerUsername());
			statement.setDate(3, new Date(System.currentTimeMillis()));
			int i=statement.executeUpdate();
			boolean result=deleteRequest(r);
			if(i>0&&result) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteRequest(Request r) {
		try {
			statement=connection.prepareStatement("delete from request where customerUsername=? and hawkerUsername=?;");
			statement.setString(1,r.getCustomerUsername());
			statement.setString(2, r.getHawkerUsername());
			int result=statement.executeUpdate();
			if(result>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<CustomerDetails> getCurrentCustomers(String hawkerUsername){
		ArrayList<CustomerDetails> list=new ArrayList<>();
		ResultSet resultSet2;
		try {
			statement=connection.prepareStatement("select customerUsername from requestAccept where hawkerUsername=?;");
			statement.setString(1, hawkerUsername);
			resultSet2=statement.executeQuery();
			while(resultSet2.next()) {
				list.add(getCustomerDetails(resultSet2.getString(1)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> saveLeaveDate(LeaveDate leaveDate) {
		ArrayList<String> status=new ArrayList<>();
		boolean valid=checkValid(leaveDate);
		if(!valid) {
			status.add("Fail");
			status.add("Leave date limit exceed");
			return status;
		}
		try	{
			statement=connection.prepareStatement("insert into leaveDates values(?,?,?);");
			statement.setString(1,leaveDate.getCustomerUsername());
			statement.setString(2, leaveDate.getHawkerUsername());
			statement.setDate(3,new Date(leaveDate.getDate().getTime()));
			int i=statement.executeUpdate();
			if(i>0) {
				status.add("Success");
				return status;
			}
			status.add("Fail");
			status.add("Failed to add date.");
		}catch(Exception e) {
			status.add("Fail");
			status.add("Date already added.");
		}
		return status;
	}
	
	public boolean checkValid(LeaveDate leaveDate) {
		try {
			statement=connection.prepareStatement("select count(leaveDate) from leaveDates where customerUsername=? and hawkerUsername=?");
			statement.setString(1, leaveDate.getCustomerUsername());
			statement.setString(2, leaveDate.getHawkerUsername());
			resultSet=statement.executeQuery();
			if(resultSet.next()) {
				int i=resultSet.getInt(1);
				if(i>5) {
					return false;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Request getRequestAcceptDate(Request request) {
		try {
			statement=connection.prepareStatement("select * from requestAccept where customerUsername=? and hawkerUsername=?");
			statement.setString(1, request.getCustomerUsername());
			statement.setString(2, request.getHawkerUsername());
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				request.setRequestAcceptDate(resultSet.getDate(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return request;
	}

}
