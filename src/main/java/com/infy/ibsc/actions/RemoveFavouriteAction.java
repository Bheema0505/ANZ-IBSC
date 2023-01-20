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
import com.infy.ibsc.vos.FavouritesVO;
import com.infy.ibsc.vos.UserVO;

public class RemoveFavouriteAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public RemoveFavouriteAction() {
		this.type      = IBConstants.ACTION_REMOVE_FAVOURITE;
		this.startPage = IBConstants.PAGE_FAVOURITE;
		this.nextPage = IBConstants.PAGE_FAVOURITE;
		}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("UserVO");
		FavouritesVO favvo = new FavouritesVO();
		String FavId = (String) req.getParameter("delFavid");
		String FavName = (String) req.getParameter("title");
		System.out.println("FavId="+FavId);
		favvo.setId(FavId);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_FAVOURITES);
		int deleted = dao.delete(favvo);
		
		logger.debug("deleted="+deleted);
		
		if(deleted == 1){
			this.setInfoMsg(req, "Favourite '"+FavName+"' has been successfully deleted.");
			favvo = new FavouritesVO();
			favvo.setEmp_id (String.valueOf(user.getEmpId()));
			ArrayList list = dao.find(favvo);
			session.setAttribute("FavouritesList", list);
		}
	
		
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		
		super.validate(req);
	
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}


