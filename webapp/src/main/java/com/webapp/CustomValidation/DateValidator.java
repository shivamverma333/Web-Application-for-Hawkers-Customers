package com.webapp.CustomValidation;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateValidate,String>{

	@Override
	public void initialize(DateValidate constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.parse(value);
		}catch(ParseException e) {
			return false;
		}
		LocalDate currentDate=LocalDate.now();
		int day=currentDate.getDayOfMonth();
		int month=currentDate.getMonthValue();
		int year=currentDate.getYear();
		LocalDate leaveDate=LocalDate.parse(value);
		int leaveDay=leaveDate.getDayOfMonth();
		int leaveMonth=leaveDate.getMonthValue();
		int leaveYear=leaveDate.getYear();
		if(day>leaveDay||month!=leaveMonth||year!=leaveYear) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Date should lie between current date and end date of service month")
			.addConstraintViolation();
			return false;
		}
		return true;
	}
	

}
