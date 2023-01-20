package com.infy.ibsc.util;

//public class UserUtil {




//package com.infy.ibsc.util;
import java.util.ArrayList;

//import java.util.Date;
import java.util.HashMap;
//import java.util.Iterator;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.vos.UserVO;

public class UserUtil {
	

	private static UserUtil userUtil = new UserUtil();
	private UserUtil() {
		super();
	this.initCache();}
	public static UserUtil getInstance() {return userUtil;}
	HashMap hm = new HashMap();
	private void initCache() {
		System.out.println("Cache: Initiating Cache ...");
		UserVO uservo = new UserVO(0);
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_USER);
		ArrayList list = dao.find(uservo);
		 if(list != null && list.size() > 0){
		    	for(int i=0;i<list.size();i++){
		    	
		    		UserVO userVo2 = (UserVO)list.get(i);
		    	hm.put( userVo2.getEmpId(),userVo2);	
		    	}
		    }
		System.out.println("hm="+hm);
		
	}
	
	public UserVO getUser(long Emp_Id) {
		
		return (UserVO) 
		hm.get(Emp_Id);
		
	}
	public boolean IsRegisteredUser(long Emp_Id) {
		
		
		if(hm.get(Emp_Id)!=null)
			return true;
		else
			return false;
	}
	
	public void resetCache(){
		this.initCache();
	}
	
	public void save(UserVO userVO) {
		System.out.println("Saving in cache: "+userVO);
		hm.put( userVO.getEmpId(),userVO);	
		
	}
}


