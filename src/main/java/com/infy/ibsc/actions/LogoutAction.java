package com.infy.ibsc.actions;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserVO;

public class LogoutAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public LogoutAction() {
		this.type      = IBConstants.ACTION_LOGOUT;
		this.startPage = IBConstants.PAGE_USER_HOME;
		this.nextPage = IBConstants.PAGE_USER_LOGIN;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("UserLogout: Inside ProcessAction");
		HttpSession session = req.getSession();
		session.removeAttribute("user.name");
		session.removeAttribute("user.role");
		session.removeAttribute("user.obstat");
		session.removeAttribute("UserVO");
		session.removeAttribute("IsValidSession");
	     
		//session.invalidate();
		
		this.setInfoMsg(req, "You have been successfully logged out.");
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
		
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
