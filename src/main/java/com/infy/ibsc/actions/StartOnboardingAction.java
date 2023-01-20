package com.infy.ibsc.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.DateUtil;
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
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;

public class StartOnboardingAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public StartOnboardingAction() {
		this.type = IBConstants.ACTION_START_ONBOARDING;
		this.startPage = IBConstants.PAGE_USER_INFORMATION;
		this.nextPage = IBConstants.PAGE_USER_INFORMATION;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("StartOnboardingAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		UserVO vo = (UserVO) session.getAttribute("Search.UserVO");
		Long empId = vo.getEmpId();
		OnboardingUtil obUtil = OnboardingUtil.getInstance();
		int count = 0;
		for (Iterator iterator = obUtil.iterator(); iterator.hasNext();) {
			Integer stepId = (Integer) iterator.next();
			System.out.println("stepId=" + stepId);
			OnboardingVO obVO = obUtil.getOnboarding(stepId.intValue());
			count += this.addStep(vo, obVO);
		}
		TrainingUtil trUtil = TrainingUtil.getInstance();
		int countTrainings = 0;
		for (Iterator iterator = trUtil.iterator(); iterator.hasNext();) {
			String trId = (String) iterator.next();
			System.out.println("trId=" + trId);
			TrainingVO trVO = trUtil.getTraining(trId); 
			countTrainings += this.addTraining(vo, trVO);
		}
         System.out.println("count="+count);
         if(count > 0) {
        	 vo.setOb_Status("Started");
        	 vo.setTotal_Trainings(countTrainings);
        	 vo.setPending_Trainings(countTrainings);
        	 DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
        	 int rowUpdated = dao.edit(vo);
        	 if(rowUpdated == 1) {
        		 session.setAttribute("Search.UserVO", vo);
        		 this.setInfoMsg(req, "Onboarding initiated successfully for "+vo.getFirstName()+" "+vo.getLastName());
        	 }
         }
        
		return null;
	}

	private int addTraining(UserVO vo, TrainingVO trVO) {
		int rowinserted = 0;
		
       if("Mandatory".equalsIgnoreCase(trVO.getType())) {
    	   UserTrainingVO utrVO = new UserTrainingVO();
    	   utrVO.setEmp_id(""+vo.getEmpId());
    	   utrVO.setTraining_id(trVO.getTr_id());
    	   utrVO.setUser_tr_id(vo.getEmpId()+"."+trVO.getTr_id());
    	   utrVO.setStatus("Registered");
    	   // 2023-05-27
    	  
 	   String format = "yyyy-MM-dd";
 	   SimpleDateFormat sdf = new SimpleDateFormat(format);
 	   String desiredDate= sdf.format(DateUtil.addMonths(new Date(),1 ));
 	  utrVO.setDue_date(desiredDate);
    	   
    	   
    	   DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERTRAINING);
			rowinserted = dao.add(utrVO);
			System.out.println("rowinserted=" + rowinserted);
       }
		return rowinserted;
	}

	private int addStep(UserVO vo2, OnboardingVO obVO) {

		String applicableLocation = obVO.getApplicable_Location().toUpperCase();
		String applicableRoles = obVO.getApplicable_Roles().toUpperCase();
		int rowinserted = 0;
		String location= StrUtil.nullToBlank(vo2.getLocation()).toUpperCase();
		String role = StrUtil.nullToBlank(vo2.getRole()).toUpperCase();

		if (("ALL".equalsIgnoreCase(applicableLocation) || applicableLocation.contains(location))

				&& (("ALL".equalsIgnoreCase(applicableRoles) || applicableRoles.contains(role)))) {
			UserOnboardingVO uobVo = new UserOnboardingVO();
			uobVo.setEmp_id(vo2.getEmpId());
			uobVo.setOB_Status("Pending");
			uobVo.setStep_Id(obVO.getStep_Id());
			if ("USER".equalsIgnoreCase(obVO.getAssignee())) {
				uobVo.setAssigned_To(vo2.getEmpId());
			} else {
				uobVo.setAssigned_To(IBConstants.DEFAULT_ADMIN);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM");
			String desiredDate = sdf.format(new Date());
			uobVo.setRemarks("[" + desiredDate + "] Added step. ");
			if(obVO.getStep_Id() == 1) {
				uobVo.setOB_Status("Completed");
				uobVo.setRemarks("[" + desiredDate + "] Onboarding started ");
			}
			DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERONBOARDING);
			rowinserted = dao.add(uobVo);
			System.out.println("rowinserted=" + rowinserted);
		}
            return rowinserted;
	}

	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		super.validate(req);
		// nothing to validate
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}

}
