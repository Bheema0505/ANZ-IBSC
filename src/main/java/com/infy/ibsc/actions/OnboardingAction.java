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

public class OnboardingAction extends BaseAction{
	public OnboardingAction() {
		this.type      = IBConstants.ACTION_ONBOARDING;
		this.startPage = IBConstants.PAGE_USER_HOME;
		this.nextPage = IBConstants.PAGE_ONBOARDING;
		
	}
	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("UserVO");
		UserOnboardingVO onboardingvo = new UserOnboardingVO();
		onboardingvo.setEmp_id(user.getEmpId());
		onboardingvo.findAll=false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERONBOARDING);
		ArrayList list = dao.find(onboardingvo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		session.setAttribute("UserOnboaringList", list);
		
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
