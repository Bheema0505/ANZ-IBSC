package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.DocumentVO;
import com.infy.ibsc.vos.OffboardReportVO;
import com.infy.ibsc.vos.VO;

public class SQLServerOffboardReportDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		OffboardReportVO offreportvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					offreportvo = new OffboardReportVO();
					offreportvo.setFirstName(rs.getString("FirstName"));
					offreportvo.setLastName(rs.getString("LastName"));
					
					offreportvo.setLocation(rs.getString("location"));
					offreportvo.setAnzSquad(rs.getString("ANZ_Squad"));
					
					offreportvo.setOffboarding_date(rs.getString("offboarding_date"));

					list.add(offreportvo);

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