package com.infy.ibsc.actions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserVO;

public class ValidateEmpIDAction extends BaseAction {
	LogUtil logger = new LogUtil();
	

	public ValidateEmpIDAction() {
		this.type      = IBConstants.ACTION_VALIDATE_EMPID;
		this.startPage = IBConstants.PAGE_FORGOT_PASSWORD;
		this.nextPage = IBConstants.PAGE_VALIDATE_SQ;
		requiresSession = false;
	}

	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return this.nextPage;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ValidateEmpIDAction: Inside ProcessAction");
		
		UserVO vo = new UserVO(0);
		vo.setEmpId(Long.parseLong(req.getParameter("emp-id")));
		vo.findAll=false;
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		if(list.size() == 1){
			UserVO vo2 = (UserVO)list.get(0);
			HttpSession session = req.getSession();
			session.setAttribute("Forgot.UserVO", vo2);
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_001: Please enter a valid registered employee ID");
			
		}

		return null;
	}

	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		HttpSession session = req.getSession();
		session.removeAttribute("Forgot.UserVO");
		super.validate(req);
		try {
		String empIdStr = req.getParameter("emp-id");
		if(StrUtil.isNullOrBlank(empIdStr) || !empIdStr.matches("[0-9]+") )
				throw new ValidationFailedException("ERR_001", "Please enter a valid registered employee ID");
		 session.setAttribute("user.empid",  empIdStr);
		
		} catch (ValidationFailedException e) {
			  
			   
			   throw e;
			}
		
		
	}



}
