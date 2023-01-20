package com.infy.ibsc.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionChecker {
	
	public void validate(HttpServletRequest req) throws InvalidSessionException
	{
		HttpSession session = req.getSession(false);
		String valid = (String)session.getAttribute("IsValidSession");
		
		if(!"TRUE".equalsIgnoreCase(valid)) {
			throw new InvalidSessionException("ERR_999","Invalid session");
		}
		else {
			System.out.println("Valid session found ...");
		}
		
	}

	public void validateJsp(HttpServletRequest req, HttpServletResponse res) {
		try {
			validate(req);
		} catch (InvalidSessionException e) {
			try {
				System.out.println("Redirecting to error page");
				//req.getRequestDispatcher(IBConstants.PAGE_ERROR).forward(req, res);
				res.sendRedirect(IBConstants.PAGE_ERROR);
			} catch (Exception e1) {
				System.out.println("Error while Redirecting to error page");
				e1.printStackTrace();
			}
		}
	}
	
}
