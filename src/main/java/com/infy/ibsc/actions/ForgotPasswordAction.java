package com.infy.ibsc.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.ibsc.util.IBConstants;

public class ForgotPasswordAction extends BaseAction {

	public ForgotPasswordAction() {
		this.type = IBConstants.ACTION_FORGOT_PASSWORD;
		
	}


	


	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return "pages/changepassword.jsp";
	}


	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
