package com.infy.ibsc.util;

public class StrUtil {

	public static boolean isNullOrBlank(String empIdStr) {
		
		if(empIdStr != null && empIdStr.trim().length() > 0)
			return false;
		
		return true;
	}
public static boolean checkMaxLength(String inputStr,int maxLength) {
		
		if(inputStr != null && inputStr.length() <= maxLength)
			return true;
		
		return false;
	}


public static boolean checkMinLength(String inputStr,int minLength) {
	
	if(inputStr != null && inputStr.length() >= minLength)
		return true;
	
	return false;
}


public static String nullToBlank(String inputStr) {
	
	if(inputStr == null )
		return "";
	
	else return inputStr;
	
}

}
