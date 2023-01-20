package com.infy.ibsc.daos;

import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.daos.file.FileDAOFactory;
import com.infy.ibsc.daos.sqlserver.SQLServerDAOFactory;
import com.infy.ibsc.util.IBConstants;

public abstract class DAOFactory {

	public static DAOFactory getInstance() {
		if(IBConstants.DB.equals("File")){
			return new FileDAOFactory();
		}
		else if(IBConstants.DB.equals("SQLServer")){
			return new SQLServerDAOFactory();
		}
		return null;
	}

	public abstract DAO getDAO(String daoEmpployee);

}
