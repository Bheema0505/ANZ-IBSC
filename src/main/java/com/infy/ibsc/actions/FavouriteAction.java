package com.infy.ibsc.actions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.vos.DocumentVO;
import com.infy.ibsc.vos.FavouritesVO;
import com.infy.ibsc.vos.UserVO;

public class FavouriteAction extends BaseAction{
	public FavouriteAction() {
		this.type      = IBConstants.ACTION_FAVOURITE;
		this.startPage = IBConstants.PAGE_FAVOURITE;
		this.nextPage = IBConstants.PAGE_FAVOURITE;
		
	}

	

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("FavouriteAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("UserVO");
		FavouritesVO favouritevo = new FavouritesVO();
		favouritevo.setEmp_id (String.valueOf(user.getEmpId()));
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_FAVOURITES);
		ArrayList list = dao.find(favouritevo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		
		session.setAttribute("FavouritesList", list);
		
		return null;
	}
	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return this.nextPage;
	}
	
}
