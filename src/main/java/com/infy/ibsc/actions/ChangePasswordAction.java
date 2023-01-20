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
import com.infy.ibsc.util.PswdUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.PassUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.AdminVO;
import com.infy.ibsc.vos.UserVO;

public class ChangePasswordAction extends BaseAction {
	LogUtil logger = new LogUtil();
	

public ChangePasswordAction() {
		this.type      = IBConstants.ACTION_CHANGE_PASSWORD;
		this.startPage = IBConstants.PAGE_CHANGE_PASSWORD;
		this.nextPage = IBConstants.PAGE_USER_LOGIN;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ChangePasswordAction: Inside ProcessAction");
		
		HttpSession session = req.getSession();
		UserVO vo = (UserVO) session.getAttribute("Forgot.UserVO");
		if(vo == null ) {
			vo = (UserVO)session.getAttribute("UserVO");
		}
		
		
		String newPass = EncUtil.convert(req.getParameter("new-change-password"));
        vo.setPass(newPass);
        //vo.setCnfrmpass(req.getParameter("cnfrmpass"));
        
        System.out.println("VO="+vo);
        DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
     int rowupdated = dao.edit(vo);
        //logger.debug("List.size="+list.size());
        logger.debug("row updated="+ rowupdated);
        if(rowupdated == 1){
            this.setInfoMsg(req, "You have sucessfully changed your password");
            this.nextPage = IBConstants.PAGE_USER_LOGIN;
            AdminVO adminVO = new AdminVO(vo.getEmpId());
            adminVO.setPass(vo.getPass());
            dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_ADMIN);
            rowupdated = dao.edit(adminVO);
            
            
            
        }
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_50: changing password failed");
			
		}
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
		HttpSession session = req.getSession();
		

		 try {
		
		String pass = req.getParameter("new-change-password");
		if(StrUtil.isNullOrBlank(pass)|| !PswdUtil.Valid(pass))
			throw new ValidationFailedException("ERR_055", "Password is not matching its criteria. It must contain at least 1 Uppercase, 1 Lowercase, 1 special character and 1 number. Length should be between 8 and 15");
	
		String cpass = req.getParameter("cnfrm-change-password");
		if(StrUtil.isNullOrBlank(cpass))
			throw new ValidationFailedException("ERR_057", "confirm Password cannot be blank");
		if(!(pass.equals(cpass))) {
			throw new ValidationFailedException("ERR_058", "password and confirm password not matching!!");
        }
        
       else if ( StrUtil.checkMaxLength(pass,8)) {
                throw new ValidationFailedException("Password should be at least 8 characters long", pass);
            }
		
	} catch (ValidationFailedException e) {
	  
		 throw e;
	}

		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
