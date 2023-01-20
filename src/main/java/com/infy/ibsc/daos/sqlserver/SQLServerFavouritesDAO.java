package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.FavouritesVO;
import com.infy.ibsc.vos.VO;

public class SQLServerFavouritesDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		FavouritesVO favouritesvo = null;
		
		if(rs != null) {
			try {
				while(rs.next()) {
					favouritesvo = new FavouritesVO();
					
					favouritesvo.setEmp_id(rs.getString("Emp_Id"));
					favouritesvo.setId(rs.getString("ID"));
					favouritesvo.setTitle(rs.getString("Title"));
					favouritesvo.setLink(rs.getString("Link"));
					favouritesvo.setType(rs.getString("Type"));
					
					
					list.add(favouritesvo);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println("List="+list);
		return list;
	}
	
	

}
