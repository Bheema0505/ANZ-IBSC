package com.infy.ibsc.daos.sqlserver;

import com.infy.ibsc.vos.VO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.UserTrainingVO;
import com.infy.ibsc.vos.VO;

public class SQLServerUserTrainingDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		UserTrainingVO usertrainingvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					usertrainingvo = new UserTrainingVO();
					usertrainingvo.setUser_tr_id(rs.getString("User_Tr_ID"));
					usertrainingvo.setEmp_id(rs.getString("Emp_ID"));
					usertrainingvo.setStatus(rs.getString("Status"));
					usertrainingvo.setActual_date(rs.getString("Actual_Date"));
					usertrainingvo.setDue_date(rs.getString("Due_Date"));
					usertrainingvo.setTraining_id(rs.getString("Training_ID"));

					list.add(usertrainingvo);

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
