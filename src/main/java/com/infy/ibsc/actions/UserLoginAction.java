package com.infy.ibsc.actions;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.CommonUtil;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.UserUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserVO;

public class UserLoginAction extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);

	public UserLoginAction() {
		this.type      = IBConstants.ACTION_USER_LOGIN;
		this.startPage = IBConstants.PAGE_USER_LOGIN;
		this.nextPage = IBConstants.PAGE_USER_HOME;
		requiresSession = false; // this action happens outside session
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("UserLoginAction: Inside ProcessAction");
		
		UserVO vo = new UserVO(0);
		String emp_id = req.getParameter("emp-id");
		vo.setEmpId(Long.parseLong(emp_id));
		String newPass = EncUtil.convert(req.getParameter("emp-password"));
		vo.setPass(newPass);
		vo.findAll=false;
		
		logger.debug("UserLoginAction: VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		ArrayList list = dao.find(vo);
		logger.debug("UserLoginAction: List.size="+list.size());
		logger.debug("UserLoginAction: List="+list);
		if(list.size() == 1){
			HttpSession session = req.getSession();
		     vo = (UserVO) list.get(0);
		     String obStatus = vo.getOb_Status();
		     if("Unregistered".equals(obStatus)) {
		    	 this.nextPage = IBConstants.PAGE_USER_REGISTER;
		    	 session.setAttribute("user.empid", emp_id);
		     }else {
		     String user = vo.getFirstName()+" "+vo.getLastName();
		     
		     session.setAttribute("user.name", user);
		     session.setAttribute("user.role", "User");
		     session.setAttribute("user.obstat", vo.getOb_Status());
		     session.setAttribute("UserVO", vo);
		     session.setAttribute("IsValidSession", "TRUE");
		     int completedTr = vo.getTotal_Trainings() - vo.getPending_Trainings();
		     session.setAttribute("user.trainstat", completedTr+" completed out of "+vo.getTotal_Trainings());
		      
		     
		}
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_03: Invalid logon credentials");
			
		}
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		HttpSession session = req.getSession();
		session.removeAttribute("Log in.UserVO");
		super.validate(req);
		try {
		String empIdStr = req.getParameter("emp-id");
		if(CommonUtil.validateEmployee(empIdStr)) {
			 session.setAttribute("user.empid",  empIdStr);
			 long empId =  Long.parseLong(empIdStr);
			 UserUtil usrUtil = UserUtil.getInstance();
			 if(!usrUtil.IsRegisteredUser(empId)) {
				 throw new ValidationFailedException("ERR_01", "Please enter a valid registered employee ID");
			 }

		}
		 
		String pass = req.getParameter("emp-password");
		if(StrUtil.isNullOrBlank(pass))
			throw new ValidationFailedException("ERR_02", "Incorrect password");
		} catch (ValidationFailedException e) {
			  
			   session.setAttribute("Log in.UserVO", vo);
			   throw e;
			}
		
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
