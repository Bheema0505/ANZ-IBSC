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

public class RemoveUser extends BaseAction {
	LogUtil logger = new LogUtil();

	public RemoveUser() {
		this.type      = IBConstants.ACTION_REMOVE_USER;
		this.startPage = IBConstants.PAGE_REMOVE_USER;
		this.nextPage = IBConstants.PAGE_MANAGE_USER;
		}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		UserVO vo = new UserVO(0);
		String empId = (String) req.getParameter("delEmpId");
		System.out.println("empId="+empId);
		vo.setEmpId(Long.parseLong(empId));
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		int deleted = dao.delete(vo);
		
		logger.debug("deleted="+deleted);
		
		if(deleted == 1){
			this.setInfoMsg(req, "User "+empId+" has been successfully deleted.");
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


