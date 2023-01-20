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
import com.infy.ibsc.vos.TrainingVO;
import com.infy.ibsc.vos.UserVO;



public class UserInformationAction extends BaseAction {
    LogUtil logger = new LogUtil();



   public UserInformationAction() {
        this.type      = IBConstants.ACTION_USER_INFORMATION;
        this.startPage = IBConstants.PAGE_MANAGE_USER;
        this.nextPage = IBConstants.PAGE_USER_INFORMATION;
    }


   @Override
	protected HashMap processAction(HttpServletRequest req, HttpServletResponse resp) {
	   
		UserVO vo = new UserVO(0);
		String empId = (String)req.getParameter("empId");
		logger.debug("empId="+empId);
		vo.setEmpId(Long.parseLong(empId));
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		vo.findAll=false;
		ArrayList list = dao.find(vo);
		logger.debug("List.size="+list.size());
		logger.debug("List="+list);
		if(list.size() == 1) {
			vo = (UserVO)list.get(0);
			HttpSession session = req.getSession();
			session.setAttribute("Search.UserVO", vo);
		}
		String user = vo.getFirstName()+" "+vo.getLastName();
		
		
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