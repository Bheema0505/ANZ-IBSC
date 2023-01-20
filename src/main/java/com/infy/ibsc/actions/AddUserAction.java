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
import com.infy.ibsc.util.PassUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.UserUtil;
import com.infy.ibsc.util.ValidationFailedException;
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;

public class AddUserAction extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);
 
	public   AddUserAction() {
		this.type = IBConstants.ACTION_ADD_USER;
		this.startPage = IBConstants.PAGE_ADD_USER;
		this.nextPage = IBConstants.PAGE_ADD_USER;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("AddUserAction: Inside ProcessAction");
		vo.setOb_Status("Unregistered");
		String newpass = PassUtil.create(10);
		String newPass1 = EncUtil.convert(newpass);
		vo.setPass(newPass1);
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
	 int rowinserted = dao.add(vo);
		//logger.debug("List.size="+list.size());
		logger.debug("rowinserted="+ rowinserted);
		if(rowinserted == 1){
			(UserUtil.getInstance()).save(vo);
			
			this.setInfoMsg(req,   ""+newpass);
		}
		else {
	
			this.nextPage =this.startPage;
			this.setErrorMsg(req, "ERR_06: Registration failed");
			
		}
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
		HttpSession session = req.getSession();
		session.removeAttribute("Add.UserVO");
		
		 try {
				String empIdStr = req.getParameter("emp-id");
				if(CommonUtil.validateEmployee(empIdStr)) {
				     vo.setEmpId(Long.parseLong(req.getParameter("emp-id")));
				}
		} catch (ValidationFailedException e) {
		  
		   session.setAttribute("Add.UserVO", vo);
		   throw e;
		}
	
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
