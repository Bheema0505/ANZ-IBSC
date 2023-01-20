package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.OnboardReportVO;
import com.infy.ibsc.vos.VO;

public class SQLServerOnboardReportDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		OnboardReportVO obreportvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					obreportvo = new OnboardReportVO();
					obreportvo.setEmpId(rs.getLong("Emp_Id"));
					obreportvo.setFirstName(rs.getString("FirstName"));
					obreportvo.setLastName(rs.getString("LastName"));
					obreportvo.setOb_Status(rs.getString("Ob_Status"));
					obreportvo.setAnzSquad(rs.getString("ANZ_Squad"));
					obreportvo.setAnzLanId(rs.getString("ANZ_LAN_ID"));
					obreportvo.setLocation(rs.getString("location"));
					obreportvo.setOnboarding_date(rs.getString("onboarding_date"));
					

					list.add(obreportvo);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("List=" + list);
		return list;
	}

}