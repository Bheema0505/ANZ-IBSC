package com.infy.ibsc.actions;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.DateUtil;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserTrainingVO;
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;

public class CompleteTrainingAction extends BaseAction {
	LogUtil logger = new LogUtil();
	
	public CompleteTrainingAction() {
		this.type      = IBConstants.ACTION_COMPLETE_TRAINING;
		this.startPage = IBConstants.PAGE_VIEW_TRAININGS;
		this.nextPage = IBConstants.PAGE_VIEW_TRAININGS;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("CompleteTrainingAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		UserVO vo = (UserVO)session.getAttribute("UserVO");
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERTRAINING);
		UserTrainingVO trainingvo = new UserTrainingVO();
		//trainingvo.setEmp_id (String.valueOf(vo.getEmpId()));
		String tr_id=req.getParameter("tr_id");
		String user_tr_id= vo.getEmpId()+"."+tr_id;
		trainingvo.setUser_tr_id(user_tr_id);
		trainingvo.setStatus("Completed");	
		//String actualDate=DateUtil.getDateFromDatePicker(req.getParameter("actual-date"));
		//trainingvo.setActual_date(actualDate);
		trainingvo.setActual_date(req.getParameter("actual-date"));
		
	 int rowUpdated = dao.edit(trainingvo);
		//logger.debug("List.size="+list.size());
		logger.debug("rowUpdated="+ rowUpdated);
		if(rowUpdated == 1){
			trainingvo = new UserTrainingVO();
			trainingvo.setEmp_id (String.valueOf(vo.getEmpId()));
			ArrayList list = dao.find(trainingvo);
			logger.debug("List.size=" + list.size());
			logger.debug("List=" + list);
			
			session.setAttribute("UserTrainingList", list);
			
			//sthis.nextPage=userlogin.jsp
			this.setInfoMsg(req, "Training updated successfully !!");
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_06: Update failed");
			
		}
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
		
	/*	String pass = req.getParameter("password");
		if(StrUtil.isNullOrBlank(pass))
			throw new ValidationFailedException("ERR_05", "Password cannot be blank");
		


	
		String cpass = req.getParameter("confirm-password");
		if(StrUtil.isNullOrBlank(cpass))
			throw new ValidationFailedException("ERR_07", "confirm Password cannot be blank");

		if(!(pass.equals(cpass))) {
			throw new ValidationFailedException("ERR_08", "password and confirm password not matching!!");
        } else
        {
        	System.out.println("password matched");
        }
		
	
		String fname= req.getParameter("first-name");
		if(StrUtil.isNullOrBlank(fname))
			throw new ValidationFailedException("ERR_01", "first name cannot be blank");
		
		String lname = req.getParameter("last-name");
		if(StrUtil.isNullOrBlank(lname))
			throw new ValidationFailedException("ERR_02", "last name cannot be blank");
		String empIdStr = req.getParameter("emp-id");
		if(StrUtil.isNullOrBlank(empIdStr))
				throw new ValidationFailedException("ERR_03", "Employee id cannot be blank.");
		
		
		String email = req.getParameter("email-id");
		if(StrUtil.isNullOrBlank(email))
			throw new ValidationFailedException("ERR_04", "email-id cannot be blank");*/
		
				
		
		
		
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
