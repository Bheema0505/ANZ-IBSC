package com.infy.ibsc.daos.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.util.DBUtil;
import com.infy.ibsc.vos.VO;

public abstract class SQLServerDAO extends DAO {

	@Override
	public int add(VO vo) {
		
		String sql = vo.insertQuery();
		logger.debug(this+": Executing query: "+sql);
		
		int rowInserted = DBUtil.execute(sql);
		return rowInserted;
	}

	@Override 
	public int edit(VO vo) {
		String sql = vo.updateQuery();
		logger.debug(this+": Executing query: "+sql);
		
		int rowUpdated = DBUtil.execute(sql);
		return rowUpdated;
	}

	@Override
	public ArrayList find(VO vo) {
		ArrayList list = new ArrayList();
		
			ResultSet rs=null;
			Connection con = null;
			String sql = vo.selectQuery();
			logger.debug(this+": Executing query: "+sql);
			
			try {
				con = DBUtil.getConnection();
				Statement stat = con.createStatement();
				stat.execute(sql);
				rs = stat.getResultSet();
				list = this.createFromRS(rs);
				stat.close();

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConnection(con);
			}
			return list;
	
	}

	protected abstract ArrayList createFromRS(ResultSet rs);

	@Override
	public int delete(VO vo) {
		String sql = vo.deleteQuery();
		logger.debug(this+": Executing query: "+sql);
		
		int rowDeleted = DBUtil.execute(sql);
		return rowDeleted;
	}

}
