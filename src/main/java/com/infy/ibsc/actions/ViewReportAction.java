package com.infy.ibsc.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.ibsc.util.IBConstants;

public class ViewReportAction extends BaseAction{
	public ViewReportAction() {
		this.type      = IBConstants.ACTION_VIEW_REPORT;
		this.startPage = IBConstants.PAGE_ADMIN_HOME;
		this.nextPage = IBConstants.PAGE_VIEW_REPORT;
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return this.nextPage;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
