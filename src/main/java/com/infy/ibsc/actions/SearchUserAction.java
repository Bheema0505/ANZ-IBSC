package com.infy.ibsc.actions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.CommonUtil;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.UserUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserVO;

public class SearchUserAction extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);

	public SearchUserAction() {
		this.type      = IBConstants.ACTION_SEARCH_USER;
		this.startPage = IBConstants.PAGE_MANAGE_USER;
		this.nextPage = IBConstants.PAGE_MANAGE_USER;
		this.multiNavigation = true; // multiple starting page for this ACTION.
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		String search_id = req.getParameter("search-id");
		String search_value=req.getParameter("searchValue");
		logger.debug("search_id"+search_id);
		logger.debug("search_value"+search_value);
		UserVO vo = new UserVO(0);
		if(search_id != null && search_value != null) {
			if(search_id.equals("emp-id")) {
				vo.setEmpId(Long.parseLong(search_value));
			}
			if(search_id.equals("first-name")) {
				vo.setFirstName(search_value+"%");
			}
			if(search_id.equals("last-name")) {
				vo.setLastName(search_value+"%");
			}
			if(search_id.equals("email")) {
				vo.setEmail(search_value+"%");
			}
			if(search_id.equals("ob-status")) {
			    vo.setOb_Status(search_value+"%");
			}
			if(search_id.equals("squad")) {
			    vo.setAnzSquad(search_value+"%");
			}
			if(search_id.equals("location")) {
			    vo.setLocation(search_value+"%");
			}
			
		}

		vo.findAll=false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		String user = vo.getFirstName()+" "+vo.getLastName();
		
		session.setAttribute("userlist", list);
	
		
		return null;
	}


	@Override
	protected void resetNavigation(HttpServletRequest req) {
		String search_start=req.getParameter("startPage");
	
		
		if(search_start != null && "addNewAdmin".equalsIgnoreCase(search_start)) {
			this.startPage = IBConstants.PAGE_ADD_NEW_ADMIN;
			this.nextPage  = IBConstants.PAGE_ADD_NEW_ADMIN;
		}
		if(search_start != null && "trainingdDetails".equalsIgnoreCase(search_start)) {
			this.startPage = IBConstants.PAGE_MANAGETRAINING_DETAILS;
			this.nextPage  = IBConstants.PAGE_MANAGETRAINING_DETAILS;
		}
	}

	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		
		// TODO Auto-generated method stub
		super.validate(req);
		
		HttpSession session = req.getSession();
		session.removeAttribute("Add.UserVO");
		session.removeAttribute("userlist");
		
		 try {
			 String search_id = req.getParameter("search-id");
				String search_value=req.getParameter("searchValue");
				if(search_id.equals("emp-id")) {
					CommonUtil.validateEmployee(search_value);
							
				}
				
		} catch (ValidationFailedException e) {
		  
		   session.setAttribute("Add.UserVO", vo);
		   throw e;
		}
	
		
	
		
		
		
		
	           
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
