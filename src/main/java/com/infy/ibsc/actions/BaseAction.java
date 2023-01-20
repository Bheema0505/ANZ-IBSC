package com.infy.ibsc.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.ibsc.framework.BaseObject;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.InvalidSessionException;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.SessionChecker;
import com.infy.ibsc.util.ValidationFailedException;

public abstract class BaseAction extends BaseObject {
	
	public String type;
	public String startPage="index.html";
	public String nextPage="index.html";
	public boolean multiNavigation=false;
	public boolean requiresSession=true;
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		logger.info(this+": ********************* Executing action *********************");
		 
		HttpSession session = req.getSession(); 
		session.removeAttribute("ERR_MSG");session.removeAttribute("INFO_MSG");
		if(multiNavigation) this.resetNavigation(req);
		
		try {
			logger.debug(this+": Starting validation ...");
			this.validate(req);
			logger.debug(this+": Completed validation ...");
			
			logger.debug(this+": Starting processing ...");
			HashMap params = new HashMap();
			params = this.processAction(req,resp);
			logger.debug(this+": Completed processing ...");
			
			nextPage = this.getNextPage(params);
			
			
		} catch (ValidationFailedException e) {
			e.printStackTrace();
			logger.error(this+": Error ocurred: "+e.getMessage());
			this.setErrorMsg(req,e.getMessage());
			this.nextPage = this.startPage;
		}
		logger.info(this+": --------------------- Completed action ----------------------");
		logger.info(this+": Transferring to next page: "+nextPage);
		return nextPage;
		
	}
	protected abstract String getNextPage(HashMap params);
	protected abstract HashMap processAction(HttpServletRequest req, HttpServletResponse resp);
	
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		
		String actionStr = req.getParameter("actionStr");
		if(actionStr == null )
			throw new ValidationFailedException("ERR_100", "Invalid action string");
		logger.debug(this+": actionStr = "+actionStr);
		
		try {
		if(requiresSession) {
			SessionChecker sChcker = new SessionChecker();
			sChcker.validate(req);}
		
		
		}catch (InvalidSessionException e) {
			this.nextPage = IBConstants.PAGE_ERROR	;	}
	}
	
	protected void setErrorMsg(HttpServletRequest req, String message) {
		HttpSession session = req.getSession();
		session.setAttribute("ERR_MSG", message);
	}	
	protected void setInfoMsg(HttpServletRequest req, String message) {
		HttpSession session = req.getSession();
		session.setAttribute("INFO_MSG", message);
	}
	
	protected void resetNavigation(HttpServletRequest req) {
		// default implementation.
	}
}
