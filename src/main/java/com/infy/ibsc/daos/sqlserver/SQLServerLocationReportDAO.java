package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.DocumentVO;
import com.infy.ibsc.vos.LocationReportVO;
import com.infy.ibsc.vos.VO;

public class SQLServerLocationReportDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		LocationReportVO locreportvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					locreportvo = new LocationReportVO();

					locreportvo.setLocation(rs.getString("location"));
					locreportvo.setCount(rs.getInt("TOTAL_EMPLOYEES"));

					list.add(locreportvo);

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