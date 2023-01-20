package com.infy.ibsc.util;

public class CommonUtil {
	

	public static boolean validateEmployee(String empIdStr) throws ValidationFailedException  {
		
		if(StrUtil.isNullOrBlank(empIdStr) || !empIdStr.matches("[0-9]+"))
			throw new ValidationFailedException("ERR_06", "Invalid employee ID");
	
	 if(!StrUtil.checkMaxLength(empIdStr,10)) 
            throw new ValidationFailedException("Employee ID cannot exceed 10 digits", empIdStr);
	 
	 
	 
	 return true;
        
	
	}
	
	
	

}
