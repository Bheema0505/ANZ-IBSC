package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.OnboardingVO;
import com.infy.ibsc.vos.VO;

public class SQLServerOnboardingDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		OnboardingVO onboardingvo = null;

		if (rs != null) {
			try {
				while (rs.next()) {
					onboardingvo = new OnboardingVO();
					onboardingvo.setStep_Id(rs.getInt("Step_Id"));
					onboardingvo.setStep_Desc(rs.getString("Step_Desc"));
					onboardingvo.setReference(rs.getString("Reference"));
					onboardingvo.setApplicable_Location(rs.getString("Applicable_Location"));
					onboardingvo.setApplicable_Roles(rs.getString("Applicable_Roles"));
					onboardingvo.setAssignee(rs.getString("Assignee"));

					list.add(onboardingvo);

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