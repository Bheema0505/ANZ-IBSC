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
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.DocumentVO;
import com.infy.ibsc.vos.UserVO;

public class ViewDocumentAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public ViewDocumentAction() {
		this.type      = IBConstants.ACTION_VIEW_DOCUMENTS;
		this.startPage = IBConstants.PAGE_USER_HOME;
		this.nextPage = IBConstants.PAGE_VIEW_DOCUMENTS;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		DocumentVO documentvo = new DocumentVO();
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_DOCUMENT);
		ArrayList list = dao.find(documentvo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		HttpSession session = req.getSession();
		session.setAttribute("DocumentList", list);
		
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
