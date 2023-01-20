package com.infy.ibsc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.ibsc.actions.ActionFactory;
import com.infy.ibsc.actions.BaseAction;

public class ActionHelper {

	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		// Reading action String from HttpServletRequest
		String actionStr = req.getParameter("actionStr");
		LogUtil logger = new LogUtil();
		logger.debug("ActionHelper: actionStr="+actionStr);
		
		BaseAction action = ActionFactory.getAction(actionStr);
		return action.execute(req, resp);
	}

}
