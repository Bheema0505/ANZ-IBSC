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
import com.infy.ibsc.util.TrainingUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.TrainingVO;
import com.infy.ibsc.vos.UserTrainingVO;
import com.infy.ibsc.vos.UserVO;

public class ManageTrainingDetailsAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public ManageTrainingDetailsAction() {
		this.type = IBConstants.ACTION_MANAGETRAINING_DETAILS;
		this.startPage = IBConstants.PAGE_ADMIN_MANAGETRAINING;
		this.nextPage = IBConstants. PAGE_MANAGETRAINING_DETAILS;
	}



	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		//UserVO user = (UserVO)session.getAttribute("UserVO");
		
		String tr_id = (String)req.getParameter("trainingId");
		logger.debug("tr_id="+tr_id);
		
		
		session.setAttribute("tr_id", tr_id);

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


