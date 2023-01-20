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
import com.infy.ibsc.vos.TrainingVO;
import com.infy.ibsc.vos.UserTrainingVO;
import com.infy.ibsc.vos.UserVO;

public class ViewTrainingAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public ViewTrainingAction() {
		this.type = IBConstants.ACTION_VIEW_TRAININGS;
		this.startPage = IBConstants.PAGE_USER_HOME;
		this.nextPage = IBConstants.PAGE_VIEW_TRAININGS;
	}



	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("UserVO");
		UserTrainingVO trainingvo = new UserTrainingVO();
		trainingvo.setEmp_id (String.valueOf(user.getEmpId()));
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERTRAINING);
		ArrayList list = dao.find(trainingvo);
		logger.debug("List.size=" + list.size());
		logger.debug("List=" + list);
		
		session.setAttribute("UserTrainingList", list);

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
