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
import com.infy.ibsc.vos.DocumentVO;

public class SearchDocumentAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public SearchDocumentAction() {
		this.type      = IBConstants.ACTION_SEARCH_DOCUMENT;
		this.startPage = IBConstants.PAGE_USER_HOME;
		this.nextPage = IBConstants.PAGE_VIEW_DOCUMENTS;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		
		String search_id = req.getParameter("search-id");
		String search_value=req.getParameter("searchValue");
		logger.debug("search_id"+search_id);
		logger.debug("search_value"+search_value);
		DocumentVO vo = new DocumentVO();
		if(search_id != null && search_value != null) {
			if(search_id.equals("Topic_Name")) {
				vo.setTopic_name(search_value+"%");
			}
			if(search_id.equals("Document_ID")) {
				vo.setDocument_id(search_value+"%");
			}
			
			
		}

		vo.findAll=false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_DOCUMENT);
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		String document = vo.getTopic_name()+" "+vo.getDocument_id();
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

