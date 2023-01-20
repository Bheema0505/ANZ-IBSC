package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.AdminVO;
import com.infy.ibsc.vos.VO;

public class SQLServerAdminDAO extends SQLServerDAO{


	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		AdminVO adminvo = null;
		
		if(rs != null) {
			try {
				while(rs.next()) {
					adminvo = new AdminVO(0);
					adminvo.setEmpId(rs.getLong("Emp_Id"));
					adminvo.setPass(rs.getString("Password"));
					adminvo.setFirstName(rs.getString("FirstName"));
					adminvo.setLastName(rs.getString("LastName"));
					adminvo.setEmail(rs.getString("Email_Id"));
					
					list.add(adminvo);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		logger.debug("SQLServerAdminDAO: List="+list);
		return list;
	}
	
	

}
