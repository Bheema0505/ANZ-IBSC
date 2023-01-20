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

public class CompleteOnboardingAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public CompleteOnboardingAction() {
		this.type = IBConstants.ACTION_COMPLETE_ONBOARDING;
		this.startPage = IBConstants.PAGE_USER_INFORMATION;
		this.nextPage = IBConstants.PAGE_USER_INFORMATION;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("CompleteOnboardingAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		UserVO vo = (UserVO) session.getAttribute("Search.UserVO");
		Long empId = vo.getEmpId();
		
         boolean stepsComplete = checkSteps(vo);
         System.out.println("stepsComplete="+stepsComplete);
         boolean trainingscomplete = checkTrainings(vo);
         System.out.println("trainingscomplete="+trainingscomplete);
         
          if(stepsComplete && trainingscomplete){
        	 vo.setOb_Status("Completed");
        	 DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
        	 int rowUpdated = dao.edit(vo);
        	 if(rowUpdated == 1) {
        		 session.setAttribute("Search.UserVO", vo);
        		 this.setInfoMsg(req, "Onboarding completed successfully.");
        	 }
         }else {
        	 System.out.println("Validation failed");
        	 this.setErrorMsg(req, "Onboarding cannot be completed due to pending steps or trainings");
         } 
        
		return null;
	}

	
	private boolean checkTrainings(UserVO vo) {
		// TODO Auto-generated method stub
		UserTrainingVO trainingvo = new UserTrainingVO();
		trainingvo.setEmp_id(String.valueOf(vo.getEmpId()));
		TrainingUtil trUtil = TrainingUtil.getInstance();

		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERTRAINING);
		ArrayList list = dao.find(trainingvo);
		if (list != null && list.size() > 0) {

			int allMandatoryRecs = 0;
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				UserTrainingVO utrVo = (UserTrainingVO) list.get(i);
				TrainingVO trVo = trUtil.getTraining(utrVo.getTraining_id());
				if ("Mandatory".equalsIgnoreCase(trVo.getType())) {
					allMandatoryRecs++;
					if ("Completed".equalsIgnoreCase(utrVo.getStatus())) {
						count++;

					}
				}

			}
			System.out.println("allMandatoryRecs=" + allMandatoryRecs);
			System.out.println("count=" + count);
			if (allMandatoryRecs == count) {
				return true;
			}

		}
		
		return false;
	}

	private boolean checkSteps(UserVO vo) {
		// TODO Auto-generated method stub
		UserOnboardingVO onboardingvo = new UserOnboardingVO();
		onboardingvo.setEmp_id(vo.getEmpId());
		onboardingvo.findAll=false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERONBOARDING);
		ArrayList list = dao.find(onboardingvo);
		if (list != null && list.size() > 0) {
			int maxRecs = list.size(); int count = 0;
			for (int i = 0; i < list.size(); i++) {
				UserOnboardingVO uobVo = (UserOnboardingVO) list.get(i);
				if("Completed".equalsIgnoreCase(uobVo.getOB_Status())) {
					count ++;
				}
			}
			System.out.println("maxRecs="+maxRecs);
			System.out.println("count="+count);
			if(maxRecs == count) {return true;}
		}
		
		return false;
	}

	
	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		super.validate(req);
		HttpSession session = req.getSession();
		UserVO vo = (UserVO) session.getAttribute("Search.UserVO");
		if (!"Started".equalsIgnoreCase(vo.getOb_Status())) {
			
			throw new ValidationFailedException("ERR_61","Onboarding status is not valid to complete onboarding");
		}
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}

}