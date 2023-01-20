package com.infy.ibsc.actions;

import java.util.ArrayList;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infy.common.util.EncUtil;
import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.CommonUtil;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;
import com.infy.ibsc.util.PassUtil;
import com.infy.ibsc.util.StrUtil;
import com.infy.ibsc.util.UserUtil;
import com.infy.ibsc.util.ValidationFailedException;
import com.infy.ibsc.vos.AdminVO;
//import com.infy.ibsc.util.ValidationSuccessException;
import com.infy.ibsc.vos.UserVO;

public class AddNewAdminAction  extends BaseAction {
	LogUtil logger = new LogUtil();
	UserVO vo = new UserVO(0);
 
	public   AddNewAdminAction() {
		this.type = IBConstants.ACTION_ADD_NEW_ADMIN;
		this.startPage = IBConstants.PAGE_ADD_NEW_ADMIN;
		this.nextPage = IBConstants.PAGE_MANAGE_ADMIN;
	}

	@Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("AddAdminAction: Inside ProcessAction");
		//vo.setOb_Status("Unregistered");
		//String newpass = PassUtil.create(10);
		//String newPass1 = EncUtil.convert(newpass);
		//vo.setPass(newPass1);
		AdminVO vo = new AdminVO(0);
		String empid = (String)req.getParameter("emp-id");
		if(empid != null) {
			long employeeId = Long.parseLong(empid)	;		
			vo.setEmpId(employeeId);
			UserUtil userUtil = UserUtil.getInstance();
			UserVO user = userUtil.getUser(employeeId);
			vo.setFirstName(user.getFirstName());
			vo.setLastName(user.getLastName());
			vo.setEmail(user.getEmail());
			vo.setPass(user.getPass());
			
			System.out.println("VO="+vo);
			DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_ADMIN);
		 int rowinserted = dao.add(vo);
			//logger.debug("List.size="+list.size());
			logger.debug("rowinserted="+ rowinserted);
			if(rowinserted == 1){
				HttpSession session = req.getSession();
				ArrayList list = (ArrayList)session.getAttribute("AdminList");
				list.add(vo);
				
				this.setInfoMsg(req, "User "+empid+" has been added as Admin");
			}
			else {
		
				this.nextPage = this.startPage;
				this.setErrorMsg(req, "ERR_06: Registration failed");
				
			}
		}
		return null;
	}


	@Override
	protected void validate(HttpServletRequest req) throws ValidationFailedException {
		// TODO Auto-generated method stub
		super.validate(req);

				String empIdStr = req.getParameter("emp-id");
				if(CommonUtil.validateEmployee(empIdStr)) {
				  vo.setEmpId(Long.parseLong(req.getParameter("emp-id")));
				}
	
	}

	@Override
	protected String getNextPage(HashMap params) {
		return this.nextPage;
	}
	

	

}
