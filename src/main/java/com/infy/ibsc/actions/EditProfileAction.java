package com.infy.ibsc.actions;

import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.ServletException;
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
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;

public class EditProfileAction extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);
	
	public EditProfileAction() {
		this.type      = IBConstants.ACTION_EDIT_PROFILE;
		this.startPage = IBConstants.PAGE_VIEW_PROFILE;
		this.nextPage = IBConstants.PAGE_VIEW_PROFILE;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("EditProfileAction: Inside ProcessAction");
		HttpSession session = req.getSession();
		UserVO vo = (UserVO)session.getAttribute("UserVO");

		vo.setFirstName(req.getParameter("first-name"));
		vo.setLastName(req.getParameter("last-name"));
		vo.setEmail(req.getParameter("email-id"));
		vo.setLocation(req.getParameter("location"));
		
		vo.setAnzMailId(req.getParameter("anz-MailId"));
		vo.setAnzLanId(req.getParameter("anz-LanId"));
		vo.setAnzSquad(req.getParameter("anz-Squad"));
		vo.setProgram(req.getParameter("Program"));
		
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
	 int rowUpdated = dao.edit(vo);
		//logger.debug("List.size="+list.size());
		logger.debug("rowUpdated="+ rowUpdated);
		if(rowUpdated == 1){
			String user = vo.getFirstName()+" "+vo.getLastName();
		     
		     session.setAttribute("user.name", user);
		     session.setAttribute("UserVO", vo);
			
			//sthis.nextPage=userlogin.jsp
			this.setInfoMsg(req, "Profile updated successfully !!");
		}
		else {
			//serviceResponse.setOutcome(401); // unauthorized.
			this.nextPage = this.startPage;
			this.setErrorMsg(req, "ERR_06: Update failed");
			
		}
		
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		
		super.validate(req);
		HttpSession session = req.getSession();
		
		String fname= req.getParameter("first-name");
		if(StrUtil.isNullOrBlank(fname) || !fname.matches("[a-zA-Z ]+")) 
			throw new ValidationFailedException("ERR_01", "please enter a valid first name");
		vo.setFirstName(req.getParameter("first-name"));
		
		
		String lname = req.getParameter("last-name");
		if(StrUtil.isNullOrBlank(lname) || !lname.matches("[a-zA-Z ]+"))
			throw new ValidationFailedException("ERR_02", "Please enter a valid last name");
		vo.setLastName(req.getParameter("last-name"));
		
		
		String email = req.getParameter("email-id");
		if(StrUtil.isNullOrBlank(email) || !email.matches("[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+"))
			throw new ValidationFailedException("ERR_03", " Please Enter a valid email-id");
		vo.setEmail(req.getParameter("email-id"));
		
		String anzmailid = req.getParameter("anz-MailId");
		if(!StrUtil.isNullOrBlank(anzmailid) && !anzmailid.matches("[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+"))
			throw new ValidationFailedException("ERR_04", " Please Enter a valid anz-MailId. Example:User12@anz.com");
		vo.setAnzMailId(req.getParameter("anz-MailId"));
		
		String anzlanid = req.getParameter("anz-LanId");
		if(!StrUtil.isNullOrBlank(anzlanid) && !anzlanid.matches("[a-zA-Z0-9 ]+"))
			throw new ValidationFailedException("ERR_05", "Please enter a valid anz-LanId. Example:User123");
		vo.setAnzLanId(req.getParameter("anz-LanId"));
		
		String anzsquad = req.getParameter("anz-Squad");
		if(!StrUtil.isNullOrBlank(anzsquad) && !anzsquad.matches("[a-zA-Z ]+"))
			throw new ValidationFailedException("ERR_06", "Please enter a valid anz-Squad. Example:IBAP");
		vo.setAnzSquad(req.getParameter("anz-Squad"));
		
		String program = req.getParameter("Program");
		if(!StrUtil.isNullOrBlank(program) && !program.matches("[a-zA-Z ]+"))
			throw new ValidationFailedException("ERR_07", "Please enter a valid Program. Example:(DRO/BAU)");
		vo.setProgram(req.getParameter("Program"));
		
		
		
		
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	
	

	

}
