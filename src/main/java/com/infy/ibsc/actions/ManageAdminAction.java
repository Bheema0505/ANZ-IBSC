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
import com.infy.ibsc.vos.AdminVO;
import com.infy.ibsc.vos.UserVO;



public class ManageAdminAction extends BaseAction {
    LogUtil logger = new LogUtil();



   public ManageAdminAction() {
        this.type      = IBConstants.ACTION_MANAGE_ADMIN;
        this.startPage = IBConstants.PAGE_ADMIN_HOME;
        this.nextPage = IBConstants.PAGE_MANAGE_ADMIN;
    }



   @Override
    protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
	    AdminVO vo = new AdminVO(0);
		vo.findAll=true;
		
		System.out.println("VO="+vo);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_ADMIN);
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		String admin = vo.getFirstName()+" "+vo.getLastName();
		HttpSession session = req.getSession();
        session.setAttribute("AdminList", list);
        
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