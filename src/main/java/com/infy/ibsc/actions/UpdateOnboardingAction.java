package com.infy.ibsc.actions;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.OnboardingVO;
import com.infy.ibsc.vos.UserOnboardingVO;
import com.infy.ibsc.vos.UserVO;

public class UpdateOnboardingAction extends BaseAction{
	public UpdateOnboardingAction() {
		this.type      = IBConstants.ACTION_UPDATE_ONBOARDING;
		this.startPage = IBConstants.PAGE_MANAGE_USER;
		this.nextPage = IBConstants.PAGE_UPDATE_ONBOARDING;
		
	}
	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String empId = (String)req.getParameter("empId");
		logger.debug("empId="+empId);
		
		UserOnboardingVO onboardingvo = new UserOnboardingVO();
		onboardingvo.setEmp_id(Long.parseLong(empId));
		onboardingvo.findAll=false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERONBOARDING);
		ArrayList list = dao.find(onboardingvo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		session.setAttribute("Admin.UserOnboardingList", list);
		session.setAttribute("UpdateOB.EmpID", empId);
		
		return null;
	}
	
	
	
	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
	
	}
	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return this.nextPage;
	}		
}
