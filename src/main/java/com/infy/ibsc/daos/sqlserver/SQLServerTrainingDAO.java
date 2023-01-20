package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.TrainingVO;
import com.infy.ibsc.vos.VO;

public class SQLServerTrainingDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		TrainingVO trainingvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					trainingvo = new TrainingVO();
					trainingvo.setTr_id(rs.getString("Tr_Id"));
					trainingvo.setName(rs.getString("Name"));
					trainingvo.setType(rs.getString("Type"));
					trainingvo.setDuration(rs.getString("Duration"));
					trainingvo.setReference(rs.getString("Reference"));

					list.add(trainingvo);

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
