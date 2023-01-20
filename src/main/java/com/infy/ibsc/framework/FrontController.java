package com.infy.ibsc.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infy.ibsc.util.ActionHelper;
import com.infy.ibsc.util.LogUtil;

public class FrontController extends HttpServlet{
	LogUtil logger = new LogUtil();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug(this+": In DoGet method. Redirecting to doPost.");
		this.doPost(req, resp);
	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug(this+": In DoPost method");
		String nextPage =  ActionHelper.process(req,resp);
		logger.debug(this+": Next Page=" +nextPage);
		resp.sendRedirect(nextPage);
		}
}
