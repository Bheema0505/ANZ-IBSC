package com.infy.ibsc.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.OnboardingUtil;
import com.infy.ibsc.util.PassUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.TrainingUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.AdminVO;
import com.infy.ibsc.vos.OnboardingVO;
import com.infy.ibsc.vos.TrainingVO;
import com.infy.ibsc.vos.UserOnboardingVO;
import com.infy.ibsc.vos.UserTrainingVO;
import com.infy.ibsc.vos.UserVO;



public class AdminRegisterTrainingAction extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);

	public AdminRegisterTrainingAction() {
		this.type      = IBConstants.ACTION_ADMIN_REGISTER_TRAINING;
		this.startPage = IBConstants.PAGE_ADMIN_HOME;
		this.nextPage = IBConstants.PAGE_MANAGETRAINING_DETAILS;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("adminRegisterTraining: Inside ProcessAction");
		
		HttpSession session = req.getSession();
		
		ArrayList list = (ArrayList) session.getAttribute("userlist");
		TrainingUtil trUtil = TrainingUtil.getInstance();
		TrainingVO trainingvo = trUtil.getTraining((String) session.getAttribute("tr_id"));
		String dueDate = req.getParameter("duedate");
		int countTrainings = 0;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			UserVO user = (UserVO) iterator.next();
			System.out.println("Adding for emp id="+user.getEmpId());
			
			countTrainings += this.addTraining(user, trainingvo, dueDate);
		}
        	 
        	
  
        	 if(countTrainings > 0) {
        		
        		 this.setInfoMsg(req, "Training registered successfully ");
        	 }
        
		return null;
		
		
		
	}
	private int addTraining(UserVO vo, TrainingVO trVO, String dueDate) {
		int rowinserted = 0;
		
    	 
    	   UserTrainingVO utrVO = new UserTrainingVO();
    	   utrVO.setEmp_id(""+vo.getEmpId());
    	   utrVO.setTraining_id(trVO.getTr_id());
    	   utrVO.setUser_tr_id(vo.getEmpId()+"."+trVO.getTr_id());
    	   utrVO.setStatus("Registered");
    	   // 2023-05-27
    	   //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// dt = sdf.format(new Date());
    	   utrVO.setDue_date(dueDate);
    	   
    	   DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERTRAINING);
			rowinserted = dao.add(utrVO);
			System.out.println("rowinserted=" + rowinserted);
    	return rowinserted;
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
