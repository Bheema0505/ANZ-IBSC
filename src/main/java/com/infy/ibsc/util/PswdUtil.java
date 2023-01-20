package com.infy.ibsc.util;

public class PswdUtil {

	public static boolean Valid(String pass)
    {
 
       // length validation
        if (!((pass.length() >= 8)
              && (pass.length() <= 15))) {
            return false;
        }
 
        if (pass.contains(" ")) {
            return false;
        }
        
            int count = 0;
 
           
            for (int i = 0; i <= 9; i++) {
 
                // to convert int to string
                String str1 = Integer.toString(i);
 
                if (pass.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        
 
        if (!(pass.contains("@") || pass.contains("#")
              || pass.contains("!") || pass.contains("~")
              || pass.contains("$") || pass.contains("%")
              || pass.contains("^") || pass.contains("&")
              || pass.contains("*") || pass.contains("(")
              || pass.contains(")") || pass.contains("-")
              || pass.contains("+") || pass.contains("/")
              || pass.contains(":") || pass.contains(".")
              || pass.contains(", ") || pass.contains("<")
              || pass.contains(">") || pass.contains("?")
              || pass.contains("|"))) {
            return false;
        }
 
       
            count = 0;
 
            for (int i = 65; i <= 90; i++) {
 
                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);
                if (pass.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                return false;
            }
        
 
         
          count = 0;
 
            // checking small letters
            for (int j = 97; j <= 122; j++) {
 
                // type casting
                char c = (char)j;
                String str2 = Character.toString(c);
 
                if (pass.contains(str2)) {
                    count = 1;
               }
            }
            if (count == 0) {
                return false;
            }
       return true;
 
        
    }

	
	public static void main(String[] args) {

		String pass1 = "Kanak";

		if (Valid(pass1)) {
			System.out.println(pass1 + " - Valid Password");
		}
		else
			{
			System.out.println("invalid password");
			}
		}
	}
