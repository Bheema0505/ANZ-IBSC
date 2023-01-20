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
import com.infy.ibsc.vos.LocationReportVO;

public class LocationReportAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public LocationReportAction() {
		this.type      = IBConstants.ACTION_LOCATION_REPORT;
		this.startPage = IBConstants.PAGE_VIEW_REPORT;
		this.nextPage = IBConstants.PAGE_LOCATION_REPORT;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		LocationReportVO reportvo = new LocationReportVO();
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_LOCATION_REPORT);
		ArrayList list = dao.find(reportvo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		HttpSession session = req.getSession();
		session.setAttribute("ReportList", list);
		
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
