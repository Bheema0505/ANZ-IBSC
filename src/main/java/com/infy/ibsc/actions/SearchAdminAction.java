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
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.AdminVO;

public class SearchAdminAction extends BaseAction {
	LogUtil logger = new LogUtil();

	public SearchAdminAction() {
		this.type = IBConstants.ACTION_SEARCH_ADMIN;
		this.startPage = IBConstants.PAGE_MANAGE_ADMIN;
		this.nextPage = IBConstants.PAGE_MANAGE_ADMIN;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {

		String search_id = req.getParameter("search-id");
		String search_value = req.getParameter("searchValue");
		logger.debug("search_id" + search_id);
		logger.debug("search_value" + search_value);
		AdminVO vo = new AdminVO(0);
		if (search_id != null && search_value != null) {
			if (search_id.equals("emp-id")) {
				vo.setEmpId(Long.parseLong(search_value));
			}
			if (search_id.equals("first-name")) {
				vo.setFirstName(search_value + "%");
			}
			if (search_id.equals("last-name")) {
				vo.setLastName(search_value + "%");
			}
			if (search_id.equals("email")) {
				vo.setEmail(search_value + "%");
			}

		}

		vo.findAll = false;
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_ADMIN);
		ArrayList list = dao.find(vo);
		logger.debug("List.size=" + list.size());
		logger.debug("List=" + list);
		String admin = vo.getFirstName() + " " + vo.getLastName();
		HttpSession session = req.getSession();
		session.setAttribute("AdminList", list);

		return null;
	}

	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
		AdminVO vo = new AdminVO(0);
		HttpSession session = req.getSession();
		session.removeAttribute("Add.AdminVO");
		session.removeAttribute("AdminList");

		try {
			String search_id = req.getParameter("search-id");
			String search_value = req.getParameter("searchValue");
			if (search_id.equals("emp-id")) {
				CommonUtil.validateEmployee(search_value);

			}

		} catch (ValidationFailedException e) {

			session.setAttribute("Add.AdminVO", vo);
			throw e;
		}

	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}

}
