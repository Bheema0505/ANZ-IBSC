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
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserVO;

public class OffboardUserAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public OffboardUserAction() {
		this.type      = IBConstants.ACTION_OFFBOARD_USER;
		this.startPage = IBConstants.PAGE_OFFBOARD_USER;
		this.nextPage = IBConstants.PAGE_MANAGE_USER;
		}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		UserVO vo = new UserVO(0);
		String empId = (String) req.getParameter("delEmpId");
		System.out.println("empId="+empId);
		vo.setEmpId(Long.parseLong(empId));
		vo.setOb_Status("Offboarded");
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		int updated = dao.edit(vo);
		
		logger.debug("updated="+updated);
		
		if(updated == 1){
			this.setInfoMsg(req, "User "+empId+" has been successfully offboarded.");
			vo = new UserVO(0);
			ArrayList list = dao.find(vo);
			HttpSession session = req.getSession();
			session.setAttribute("userlist", list);
		}
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		
		super.validate(req);
	
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}


