package com.infy.ibsc.actions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.UserVO;

public class ValidateSQAction extends BaseAction {
	
	LogUtil logger = new LogUtil();
	

	public ValidateSQAction() {
		this.type      = IBConstants.ACTION_VALIDATE_SQ;
		this.startPage = IBConstants.PAGE_VALIDATE_SQ;
		this.nextPage = IBConstants.PAGE_CHANGE_PASSWORD;
	}

	@Override
	protected String getNextPage(HashMap params) {
		// TODO Auto-generated method stub
		return this.nextPage;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ValidateSQAction: Inside ProcessAction");

		//UserVO vo = new UserVO(null);
		HttpSession session = req.getSession();
		UserVO vo = (UserVO) session.getAttribute("Forgot.UserVO");
		System.out.println("UserVO="+vo);
		String secQue = req.getParameter("sec-que");
		
		String ans = req.getParameter("sec-ans");
		String newAns = EncUtil.convert(ans);
		System.out.println(secQue +"="+newAns);
		System.out.println(vo.getCqno() +"="+vo.getCqans());
		if (secQue.equals(vo.getCqno()) && newAns.equals(vo.getCqans())) {
			this.nextPage = IBConstants.PAGE_CHANGE_PASSWORD;
			
		}
		else {
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_43: Invalid security credentials");
		}

		return null;
	}

	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		super.validate(req);
		
		String secQue = req.getParameter("sec-que");
		
		if(StrUtil.isNullOrBlank(secQue))
			throw new ValidationFailedException("ERR_41", "Security question cannot be blank.");
	
		String ans = req.getParameter("sec-ans");
		if(StrUtil.isNullOrBlank(ans))
			throw new ValidationFailedException("ERR_42", "Security Answer cannot be blank.");
	
	}

	
	
}
