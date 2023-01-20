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
import com.infy.ibsc.vos.AdminVO;

public class AdminLoginAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public AdminLoginAction() {
		this.type      = IBConstants.ACTION_ADMIN_LOGIN;
		this.startPage = IBConstants.PAGE_ADMIN_LOGIN;
		this.nextPage = IBConstants.PAGE_ADMIN_HOME;
		requiresSession = false;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("AdminLoginAction: Inside ProcessAction");
		
		AdminVO vo = new AdminVO(0);
		vo.setEmpId(Long.parseLong(req.getParameter("empId")));
		String newPass = EncUtil.convert(req.getParameter("empPassword"));
		vo.setPass(newPass);
		vo.findAll=false;
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_ADMIN);
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		if(list.size() == 1){
		     vo = (AdminVO) list.get(0);
		    String admin = vo.getFirstName()+" "+vo.getLastName();
		     HttpSession session = req.getSession();
		    session.setAttribute("admin.name", admin);
		    // session.setAttribute("admin.role", " Admin");
		    // session.setAttribute("user.obstat", vo.getOb_Status());
		     session.setAttribute("IsValidSession", "TRUE");
		    // int completedTr = vo.getTotal_Trainings() - vo.getPending_Trainings();
		    // session.setAttribute("user.trainstat", completedTr+" completed out of "+vo.getTotal_Trainings());
		     
		     
		     
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
		// TODO Auto-generated method stub
		super.validate(req);
		
		String empIdStr = req.getParameter("empId");
		if(StrUtil.isNullOrBlank(empIdStr))
				throw new ValidationFailedException("ERR_01", "Employee id cannot be blank.");
		
		String pass = req.getParameter("empPassword");
		if(StrUtil.isNullOrBlank(pass))
			throw new ValidationFailedException("ERR_02", "Password cannot be blank");
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
