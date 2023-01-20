package com.infy.ibsc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date addMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		// TODO Auto-generated method stub
		return cal.getTime();
	}
	
	public static String getReportDate(Date date) {
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		return sdf.format(date);
	}
	
	public static String getDateMMDDyyyy(Date date) {
		System.out.println("date="+date);
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}
	public static String getDateFromDatePicker(String dateFromDatePicker) {
		System.out.println("dateFromDatePicker="+dateFromDatePicker);
		SimpleDateFormat sdf1= new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf2.format(sdf1.parse(dateFromDatePicker).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	


	public static void main(String[] args) {
		System.out.println("current date is: "+new Date());
		System.out.println("After 4 month: "+DateUtil.addMonths(new Date(), 4));
	}

}
