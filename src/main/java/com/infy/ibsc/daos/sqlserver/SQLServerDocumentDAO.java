package com.infy.ibsc.daos.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.DocumentVO;
import com.infy.ibsc.vos.VO;

public class SQLServerDocumentDAO extends SQLServerDAO {

	@Override
	protected ArrayList createFromRS(ResultSet rs) {
		ArrayList list = new ArrayList();
		DocumentVO documentvo = null;
		
		if(rs != null) {
			try {
				while(rs.next()) {
					documentvo = new DocumentVO();
					
					documentvo.setDocument_id(rs.getString("Document_ID"));
					documentvo.setTopic_name(rs.getString("Topic_Name"));
					documentvo.setLink(rs.getString("Link"));
					documentvo.setType(rs.getString("Type"));
					
					
					list.add(documentvo);
					
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