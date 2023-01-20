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
import com.infy.ibsc.vos.UserVO;

public class AddTrainingAction  extends BaseAction {
	LogUtil logger = new LogUtil();


	public AddTrainingAction() {
		this.type = IBConstants.ACTION_ADMIN_ADDTRAINING;
		this.startPage = IBConstants.PAGE_ADMIN_ADDTRAINING;
		this.nextPage = IBConstants.PAGE_ADMIN_MANAGETRAINING;
	}



	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
	
		
		
		
		
		System.out.println("AddTrainingAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		TrainingVO vo = new TrainingVO();

		vo.setTr_id(req.getParameter("tr_id"));
		vo.setName(req.getParameter("name"));
		vo.setType(req.getParameter("type"));
		vo.setDuration(req.getParameter("duration"));
		vo.setReference(req.getParameter("reference"));
		
		
		
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_TRAINING);
		if(req.getParameter("tr_id")==null)
		{
		
		}
		else
		{
			
		
	 int rowadd = dao.add(vo);
		
		logger.debug("rowadd="+ rowadd);
		if(rowadd == 1){
			
		    ArrayList list = (ArrayList)session.getAttribute("TrainingList") ;
		    list.add(vo);
			session.setAttribute("TrainingList", list);
			//sthis.nextPage=userlogin.jsp
			this.setInfoMsg(req, "Training added successfully !!");
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_06: Update failed");
			
		}
		}	
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
