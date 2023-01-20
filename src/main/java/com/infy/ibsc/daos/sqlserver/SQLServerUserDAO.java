package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.UserVO;
import com.infy.ibsc.vos.VO;

public class SQLServerUserDAO extends SQLServerDAO{


	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		UserVO uservo = null;
		
		if(rs != null) {
			try {
				while(rs.next()) {
					uservo = new UserVO(0);
					uservo.setEmpId(rs.getLong("Emp_Id"));
					uservo.setPass(rs.getString("Pswd"));
					uservo.setFirstName(rs.getString("FirstName"));
					uservo.setLastName(rs.getString("LastName"));
					uservo.setEmail(rs.getString("Email_Id"));
					uservo.setCqno(rs.getString("CQ"));
					uservo.setCqans(rs.getString("Ans"));
					uservo.setOb_Status(rs.getString("Ob_Status"));
					uservo.setPending_Trainings(rs.getInt("Pending_Trainings"));
					uservo.setTotal_Trainings(rs.getInt("Total_Trainings"));
					uservo.setLocation(rs.getString("Location"));
					uservo.setAnzSquad(rs.getString("ANZ_Squad"));
					uservo.setAnzMailId(rs.getString("ANZ_Mail_ID"));
					uservo.setAnzLanId(rs.getString("ANZ_LAN_ID"));
					uservo.setProgram(rs.getString("Program"));
					
					
					list.add(uservo);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		logger.debug("SQLServerUserDAO: List="+list);
		return list;
	}
	
	}
	


