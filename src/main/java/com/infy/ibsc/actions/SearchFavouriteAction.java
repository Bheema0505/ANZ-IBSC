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

public class SearchFavouriteAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public SearchFavouriteAction() {
		this.type      = IBConstants.ACTION_SEARCH_FAVOURITE;
		this.startPage = IBConstants.PAGE_FAVOURITE;
		this.nextPage = IBConstants.PAGE_FAVOURITE;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		
		String search_id = req.getParameter("search-id");
		String search_value=req.getParameter("searchValue");
		logger.debug("search_id"+search_id);
		logger.debug("search_value"+search_value);
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("UserVO");
		FavouritesVO favouritevo = new FavouritesVO();
		favouritevo.setEmp_id (String.valueOf(user.getEmpId()));
		if(search_id != null && search_value != null) {
			if(search_id.equals("Title")) {
				favouritevo.setTitle(search_value+"%");
			}
			if(search_id.equals("Type")) {
				favouritevo.setType(search_value+"%");
			}
			
			
		}

		favouritevo.findAll=false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_FAVOURITES);
		ArrayList list = dao.find(favouritevo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		String favourite = favouritevo.getTitle()+" "+favouritevo.getType();
		session.setAttribute("FavouritesList", list);
		
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

