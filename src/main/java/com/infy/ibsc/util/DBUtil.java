package com.infy.ibsc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
public static String dbURL = "jdbc:sqlserver://HYDPCM642D:52005;databaseName=IB_TRANS_F11_FEBA1";
public static String dbUser = "ececuserANZ";
public static String dbPass = "niedhG54321";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		LogUtil logger = new LogUtil();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(dbURL, dbUser,dbPass);

		logger.debug("DBUtil: Returning connection ..");
		return con;
	}

	public static int execute(String sqlString) {
		int rowUpdated = 0;
		LogUtil logger = new LogUtil();
		logger.debug("DBUtil: Executing query: "+sqlString);
		Connection con = null;
		try {
			con = getConnection();
			Statement sql = con.createStatement();
			sql.execute(sqlString);
			rowUpdated = sql.getUpdateCount();
			sql.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		logger.debug("DBUtil: Rows affected="+rowUpdated);
		return rowUpdated;
	}
	
	
	public static void closeConnection(Connection con) {
		try {
			if(con != null)
			    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
