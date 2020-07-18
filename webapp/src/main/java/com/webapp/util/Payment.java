package com.webapp.util;

import java.sql.Date;
import java.util.Calendar;


public class Payment {
	
	public boolean todayDateCheck(Date requestAcceptDate) {
		Date todayDate=new Date(System.currentTimeMillis());
		Calendar cal=Calendar.getInstance();
		cal.setTime(todayDate);
		int date1=cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(requestAcceptDate);
		int date2=cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(date1+" "+date2+" "+todayDate+" "+requestAcceptDate);
		if(!(todayDate.toString()).equals(requestAcceptDate.toString())&&date1==date2) {
			System.out.println("hii");
			return true;
		}
		return false;
	}

}
