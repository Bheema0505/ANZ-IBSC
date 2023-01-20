package com.infy.ibsc.daos.sqlserver;

import com.infy.ibsc.vos.VO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.UserOnboardingVO;
import com.infy.ibsc.vos.VO;

public class SQLServerUserOnboardingDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		UserOnboardingVO useronboardingvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					useronboardingvo = new UserOnboardingVO();
					useronboardingvo.setEmp_id(rs.getLong("Emp_Id"));
					useronboardingvo.setStep_Id(rs.getInt("Step_Id"));
					useronboardingvo.setOB_Status(rs.getString("OB_Status"));
					useronboardingvo.setAssigned_To(rs.getInt("Assigned_To"));
					useronboardingvo.setRemarks(rs.getString("Remarks"));
					
					list.add(useronboardingvo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("List=" + list);
		return list;
	}

}
