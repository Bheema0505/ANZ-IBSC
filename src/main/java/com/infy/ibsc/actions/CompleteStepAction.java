package com.infy.ibsc.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
//import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.PassUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.ValidationFailedException;
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;*/
import javax.servlet.http.HttpSession;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.vos.UserOnboardingVO;
import com.infy.ibsc.vos.UserVO;



public class CompleteStepAction extends BaseAction {

	
	
	public   CompleteStepAction() {
		this.type = IBConstants.ACTION_COMPLETE_STEP;
		this.startPage = IBConstants.PAGE_ONBOARDING;
		this.nextPage = IBConstants.PAGE_ONBOARDING;
	}
	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return this.nextPage;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("CompleteStepAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		UserOnboardingVO uobVO = new UserOnboardingVO();
		long emp_id = 0;

		String start_page=req.getParameter("startPage");
		if(start_page != null && "updateOnboarding".equalsIgnoreCase(start_page)) {
			this.startPage = IBConstants.PAGE_UPDATE_ONBOARDING;
			this.nextPage  = IBConstants.PAGE_UPDATE_ONBOARDING;
			String empID = (String)session.getAttribute("UpdateOB.EmpID");
			emp_id = Long.parseLong(empID);
			
			String decision = req.getParameter("decision");
			if("Reject".equalsIgnoreCase(decision)) {
				uobVO.setOB_Status("Rejected");
			}
			else {uobVO.setOB_Status("Completed");}
		}
		else {
			UserVO vo = (UserVO)session.getAttribute("UserVO");
			emp_id = vo.getEmpId();
			
			uobVO.setOB_Status("Submitted");
		}
		
		uobVO.setEmp_id(emp_id);
		int stepid = Integer.parseInt(req.getParameter("step-id"));
		uobVO.setStep_Id(stepid);
		
		String remarks= req.getParameter("remarks");
		String remarks2= req.getParameter("onboard-step-remarks");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM");
		String dt = sdf.format(new Date());
		uobVO.setRemarks(remarks+"<br>[" + dt + "] "+remarks2);
		System.out.println("uobVO="+uobVO);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USERONBOARDING);
   	    int rowUpdated = dao.edit(uobVO);
		logger.debug("rowUpdated="+ rowUpdated);
		if(rowUpdated == 1){
				UserOnboardingVO onboardingvo = new UserOnboardingVO();
				onboardingvo.setEmp_id(emp_id);
				onboardingvo.findAll=false;
				ArrayList list = dao.find(onboardingvo);
				logger.debug("List.size="+list.size());
				logger.debug("List="+list);
				if(start_page != null && "updateOnboarding".equalsIgnoreCase(start_page)) {
					session.setAttribute("Admin.UserOnboardingList", list);
				}else {
					session.setAttribute("UserOnboaringList", list);
				}
				

			
			//sthis.nextPage=userlogin.jsp
			this.setInfoMsg(req, "Step updated successfully !!");
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_06: Update failed");
			
		}
		return null;

		
		
	}

}
