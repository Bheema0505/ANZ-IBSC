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
import com.infy.ibsc.util.PassUtil;
import com.infy.ibsc.util.PswdUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.UserUtil;
import com.infy.ibsc.util.ValidationFailedException;
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;

public class UserRegisterAction extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);

	public UserRegisterAction() {
		this.type      = IBConstants.ACTION_USER_REGISTER;
		this.startPage = IBConstants.PAGE_USER_REGISTER;
		this.nextPage = IBConstants.PAGE_USER_LOGIN;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("UserRegisterAction: Inside ProcessAction");
		
		vo.setCqno(req.getParameter("sec-que"));
		String newAns = EncUtil.convert(req.getParameter("sec-answer"));
		vo.setCqans(newAns);
		vo.setOb_Status("Pending");
		String location = req.getParameter("location");
		vo.setLocation(location);
		//vo.findAll=false;
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
	 int rowinserted = dao.edit(vo);
		//logger.debug("List.size="+list.size());
		logger.debug("rowinserted="+ rowinserted);
		if(rowinserted == 1){
			//VO vo2 = (VO)list.get(0);
			//serviceResponse.vo=vo2;
			//serviceResponse.setOutcome(200); // OK
			
			(UserUtil.getInstance()).save(vo);
			
			this.setInfoMsg(req, "You have been successfully registered to IBSC Web. Please login to continue.");
			
			
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_06: Registration failed");
			
		}
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);
		HttpSession session = req.getSession();
		//session.removeAttribute("Register.UserVO");
		
		 try {
			 String empIdStr = (String)session.getAttribute("user.empid");
				if(StrUtil.isNullOrBlank(empIdStr))
						throw new ValidationFailedException("ERR_03", "Employee id cannot be blank.");
				vo.setEmpId(Long.parseLong(empIdStr));
			 
				String fname= req.getParameter("first-name");
				
				if(StrUtil.isNullOrBlank(fname) || !fname.matches("[a-zA-Z ]+")) 
					throw new ValidationFailedException("ERR_01", "please enter a valid name");
				vo.setFirstName(req.getParameter("first-name"));
				
				
				String lname = req.getParameter("last-name");
				if(StrUtil.isNullOrBlank(lname) || !lname.matches("[a-zA-Z ]+"))
					throw new ValidationFailedException("ERR_02", "Please enter a valid last name");
				vo.setLastName(req.getParameter("last-name"));
				
				
				String email = req.getParameter("email-id");
				if(StrUtil.isNullOrBlank(email) || !email.matches("[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+"))
					throw new ValidationFailedException("ERR_04", " Please Enter a valid email-id");
				
				vo.setEmail(req.getParameter("email-id"));
				
				String pass = req.getParameter("password");
				if(StrUtil.isNullOrBlank(pass)|| !PswdUtil.Valid(pass))
					throw new ValidationFailedException("ERR_05", "Password is not matching its criteria. It must contain at least 1 Uppercase, 1 Lowercase, 1 special character and 1 number. Length should be between 8 and 15");
			
				String cpass = req.getParameter("confirm-password");
				if(StrUtil.isNullOrBlank(cpass))
					throw new ValidationFailedException("ERR_07", "confirm Password cannot be blank");
				if(!(pass.equals(cpass))) {
					throw new ValidationFailedException("ERR_08", "password and confirm password not matching!!");
		        }
		       
		       else if (!StrUtil.checkMinLength(pass,8)) {
		                throw new ValidationFailedException("Password should be at least 8 characters long", pass);
		            }

				String ans= req.getParameter("sec-answer");
				if(StrUtil.isNullOrBlank(ans) || !ans.matches("[a-zA-Z_]+"))
					throw new ValidationFailedException("ERR_09", "Please enter a valid answer");
				vo.setCqans(req.getParameter("sec-answer"));
				
		        
				String cq= req.getParameter("sec-que");
				if(StrUtil.isNullOrBlank(cq))
					throw new ValidationFailedException("ERR_10", "Question can not be blank");
				vo.setCqno(req.getParameter("sec-que"));
				
				String newPass = EncUtil.convert(req.getParameter("password"));
				vo.setPass(newPass);
				
				
				String loc= req.getParameter("location");
				if(StrUtil.isNullOrBlank(loc) || !loc.matches("[a-zA-Z_]+"))
					throw new ValidationFailedException("ERR_10", "Please enter a valid Location");
				vo.setLocation(loc);
				
			
		} catch (ValidationFailedException e) {
		  
		   session.setAttribute("Register.UserVO", vo);
		   throw e;
		}
	
		
	}

	

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
