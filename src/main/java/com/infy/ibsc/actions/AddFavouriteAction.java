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

public class AddFavouriteAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public AddFavouriteAction() {
		this.type = IBConstants.ACTION_ADD_FAVOURITE;
		this.startPage = IBConstants.PAGE_FAVOURITE;
		this.nextPage = IBConstants.PAGE_ADD_FAVOURITE;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("AddFavouritesAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		FavouritesVO vo = new FavouritesVO();
		UserVO user = (UserVO)session.getAttribute("UserVO");
		vo.setEmp_id(String.valueOf(user.getEmpId()));
		vo.setTitle(req.getParameter("title"));
		vo.setLink(req.getParameter("link"));
		vo.setType(req.getParameter("type"));

		System.out.println("VO=" + vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_FAVOURITES);
		
			int rowadd = dao.add(vo);

			logger.debug("rowadd=" + rowadd);
			if (rowadd == 1) {

				ArrayList list = (ArrayList) session.getAttribute("FavouritesList");
				list.add(vo);
				session.setAttribute("FavouritesList", list);
				// sthis.nextPage=userlogin.jsp
				this.setInfoMsg(req, "Favourities added successfully !!");
			} else {
				// serviceResponse.setOutcome(401); // unauthorized.
				this.nextPage = this.startPage;
				this.setErrorMsg(req, "ERR_06: Update failed");

			}
		
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
