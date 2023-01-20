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
import com.infy.ibsc.vos.TrainingVO;
import com.infy.ibsc.vos.UserTrainingVO;
import com.infy.ibsc.vos.UserVO;

public class ManageTrainingAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public ManageTrainingAction() {
		this.type = IBConstants.ACTION_ADMIN_MANAGETRAINING;
		this.startPage = IBConstants.PAGE_ADMIN_HOME;
		this.nextPage = IBConstants.PAGE_ADMIN_MANAGETRAINING;
	}



	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		//UserVO user = (UserVO)session.getAttribute("UserVO");
		TrainingVO trainingvo = new TrainingVO();
		trainingvo.findAll=true;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_TRAINING);
		ArrayList list = dao.find(trainingvo);
		
		logger.debug("List=" + list);
		
		session.setAttribute("TrainingList", list);

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


