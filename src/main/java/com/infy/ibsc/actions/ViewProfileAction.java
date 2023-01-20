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

public class ViewProfileAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public ViewProfileAction() {
		this.type      = IBConstants.ACTION_VIEW_PROFILE;
		this.startPage = IBConstants.PAGE_USER_HOME;
		this.nextPage = IBConstants.PAGE_VIEW_PROFILE;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ViewProfileAction: Inside ProcessAction");
		
		/*UserVO vo = new UserVO(0);
		vo.setEmpId(Long.parseLong(req.getParameter("emp-id")));
		String newPass = EncUtil.convert(req.getParameter("emp-password"));
		vo.setPass(newPass);
		vo.findAll=false;
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		if(list.size() == 1){
		     vo = (UserVO) list.get(0);
		     String user = vo.getFirstName()+" "+vo.getLastName();
		     HttpSession session = req.getSession();
		     session.setAttribute("user.name", user);
		     session.setAttribute("user.role", "User");
		     session.setAttribute("user.obstat", vo.getOb_Status());
		     session.setAttribute("UserVO", vo);
		     int completedTr = vo.getTotal_Trainings() - vo.getPending_Trainings();
		     session.setAttribute("user.trainstat", completedTr+" completed out of "+vo.getTotal_Trainings());
		     
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_03: Invalid logon credentials");
			
		}*/
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
