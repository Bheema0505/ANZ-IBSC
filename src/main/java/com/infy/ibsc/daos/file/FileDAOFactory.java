package com.infy.ibsc.daos.file;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.util.IBConstants;

public class FileDAOFactory extends DAOFactory {

	@Override
	public DAO getDAO(String daoName) {
		System.out.println("FileDAOFactory: Getting "+daoName);
		if(IBConstants.DAO_USER.equals(daoName)){
			return new FileUserDAO();
		}
		
		if(IBConstants.DAO_ADMIN.equals(daoName)){
			return new FileUserDAO();
		}
		return null;
	}

}
