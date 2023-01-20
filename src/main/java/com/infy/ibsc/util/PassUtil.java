package com.infy.ibsc.util;

public class PassUtil {
	public static String create(int length) {
		
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789@#$%^&*"
            + "abcdefghijklmnopqrstuvxyz";
    StringBuffer buf = new StringBuffer();
    
    for (int i = 0; i < length; i++) {
        int index = (int)(AlphaNumericString.length() * Math.random());
        buf.append(AlphaNumericString.charAt(index));
        
    }
    
    return buf.toString();
	}
}
