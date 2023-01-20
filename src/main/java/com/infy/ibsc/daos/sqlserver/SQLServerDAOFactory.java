package com.infy.ibsc.daos.sqlserver;

import com.infy.ibsc.daos.DAO;


import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.daos.file.FileUserDAO;
import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;

public class SQLServerDAOFactory extends DAOFactory {

	@Override
	public DAO getDAO(String daoName) {
		LogUtil logger = new LogUtil();
		logger.debug("SQLServerDAOFactory: Getting " + daoName);
		if (IBConstants.DAO_USER.equals(daoName)) {
			return new SQLServerUserDAO();
		}
		if (IBConstants.DAO_ADMIN.equals(daoName)) {
			return new SQLServerAdminDAO();
		}
		
		if (IBConstants.DAO_DOCUMENT.equals(daoName)) {
			return new SQLServerDocumentDAO();
		}
		if (IBConstants.DAO_TRAINING.equals(daoName)) {
			return new SQLServerTrainingDAO();
		}
		if (IBConstants.DAO_USERTRAINING.equals(daoName)) {
			return new SQLServerUserTrainingDAO();
		}
		if (IBConstants.DAO_ONBOARDING.equals(daoName)) {
            return new SQLServerOnboardingDAO();
        }
        if (IBConstants.DAO_USERONBOARDING.equals(daoName)) {
            return new SQLServerUserOnboardingDAO();
        }
        if (IBConstants.DAO_FAVOURITES.equals(daoName)) {
            return new SQLServerFavouritesDAO();
        }
        if (IBConstants.DAO_LOCATION_REPORT.equals(daoName)) {
            return new SQLServerLocationReportDAO();
        }
        if (IBConstants.DAO_ONBOARD_REPORT.equals(daoName)) {
            return new SQLServerOnboardReportDAO();
        }
        if (IBConstants.DAO_OFFBOARD_REPORT.equals(daoName)) {
            return new SQLServerOffboardReportDAO();
        }
		
		return null;

	}
}
