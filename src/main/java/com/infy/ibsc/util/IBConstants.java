package com.infy.ibsc.util;

public interface IBConstants {

	public static final String DB 					= "SQLServer";
	public static final String PATH_LOG_FILE 		= "D:/IBSC/logs/log.txt";
	public static final String PATH_DATA_FILES 		= "D:/IBSC/data/";

	// Actions
	public static final String ACTION_USER_LOGIN	= "userLogin";
	public static final String ACTION_ADMIN_LOGIN = "adminlogin";
	public static final String ACTION_USER_REGISTER = "userRegister";
	 public static final String ACTION_FORGOT_PASSWORD = "forgotpassword";
	public static final String ACTION_VIEW_TRAININGS = "viewTrainings";
	public static final String ACTION_REMOVE_ADMIN = "removeAdmin";
	public static final String ACTION_CHANGE_PASSWORD = "changepassword";
	public static final String ACTION_MANAGE_USER = "manageuser";
	public static final String ACTION_REMOVE_USER = "removeuser";
	public static final String ACTION_VALIDATE_SQ = "validateSQ";
	public static final String ACTION_VALIDATE_EMPID = "validateEmpID";
	public static final String ACTION_LOGOUT = "logout";
	public static final String ACTION_ADMIN_LOGOUT = "adminlogout";
	public static final String ACTION_USER_HOME = "userHome";
	public static final String ACTION_FAVOURITE = "favourites";
	public static final String ACTION_ONBOARDING = "onboarding";
	public static final String ACTION_SEARCH_USER = "searchuser";
	public static final String ACTION_VIEW_PROFILE = "viewProfile";
	public  static final String ACTION_ADD_USER = "adduser";
	public  static final String ACTION_ADMIN_MANAGETRAINING ="managetraining";
	public  static final String ACTION_ADMIN_ADDTRAINING ="addtraining";
	public static final String ACTION_EDIT_USERINFORMATION = "edituserinformation";
	public static final String ACTION_SEARCH_ADMIN = "searchadmin";
	public static final String ACTION_COMPLETE_ONBOARDING = "completeOnboarding";
	public static final String ACTION_ADMIN_REGISTER_TRAINING = "adminRegisterTraining";
	public static final String ACTION_COMPLETE_TRAINING = "completeTraining";
	public static final String ACTION_VIEW_DOCUMENTS = "viewDocuments";
	public static final String ACTION_EDIT_PROFILE = "editProfile";
	public static final String ACTION_USER_INFORMATION = "userInformation";
	public static final String ACTION_START_ONBOARDING = "startOnboarding";
	public static final String ACTION_UPDATE_ONBOARDING = "updateOnboarding";
	public static final String ACTION_MANAGETRAINING_DETAILS = "managetrainingdetails";
	public static final String ACTION_SEARCH_DOCUMENT = "searchdocument";
	public static final String ACTION_MANAGE_ADMIN = "manageAdmin";
	public static final String ACTION_ADD_NEW_ADMIN = "addNewAdmin";
	public static final String ACTION_ADD_FAVOURITE = "addfavourite";
	public static final String ACTION_COMPLETE_STEP = "completestep";
	public static final String ACTION_REMOVE_FAVOURITE = "removefavourite";
	public static final String ACTION_SEARCH_FAVOURITE = "searchfavourites";
	public static final String ACTION_VIEW_REPORT = "viewreport";
	public static final String ACTION_LOCATION_REPORT = "locationreport";
	public static final String ACTION_ONBOARD_REPORT = "onboardreport";
	public static final String ACTION_OFFBOARD_REPORT = "offboardreport";
	public static final String ACTION_OFFBOARD_USER = "offboarduser";
	
	// JSP pages
	public static final String PAGE_USER_LOGIN		= "pages/userlogin.jsp";
	public static final String PAGE_ADMIN_LOGIN		= "pages/adminlogin.jsp";
	public static final String PAGE_USER_HOME		= "pages/userhome.jsp";
	public static final String PAGE_ADMIN_HOME		= "pages/adminhome.jsp";
	public static final String PAGE_FORGOT_PASSWORD		= "pages/forgotpassword.jsp";
	public static final String PAGE_ENTER_OTP		= "pages/enterotp.jsp";
	public static final String PAGE_CHANGE_PASSWORD		= "pages/changepassword.jsp";
	public static final String PAGE_VALIDATE_SQ= "pages/validateSQ.jsp";
	public static final String PAGE_USER_REGISTER	= "pages/registrationpage.jsp";
	public static final String PAGE_VIEW_TRAININGS = "pages/viewtraining.jsp";
	public static final String PAGE_REMOVE_ADMIN = "pages/removeadmin.jsp";
	public static final String PAGE_FAVOURITE = "pages/favourites.jsp";
	public static final String PAGE_ONBOARDING = "pages/onboard.jsp";
	public static final String PAGE_ADD_USER = "pages/adduser.jsp";
	public static final String PAGE_USER_INFORMATION = "pages/userinformation.jsp" ;
	public static final String PAGE_ADMIN_MANAGETRAINING = "pages/managetraining.jsp";
	public static final String PAGE_ADMIN_ADDTRAINING = "pages/addtraining.jsp";
	public static final String PAGE_ERROR = "pages/errorpage.jsp";


	public static final String PAGE_ADD_NEW_ADMIN = "pages/addnewadmin.jsp";
	public static final String PAGE_MANAGE_USER = "pages/manageuser.jsp";
	public static final String PAGE_REMOVE_USER = "pages/removeuser.jsp";
	public static final String PAGE_USER_LOGOUT = "pages/userLogout.jsp";
	public static final String PAGE_ADMIN_LOGOUT = "pages/adminLogout.jsp";
	public static final String PAGE_VIEW_PROFILE = "pages/viewprofile.jsp";
	public static final String PAGE_VIEW_DOCUMENTS = "pages/viewdocument.jsp";
	public static final String PAGE_MANAGE_ADMIN = "pages/manageadmin.jsp";
	
	public static final String PAGE_MANAGETRAINING_DETAILS = "pages/managetrainingdetails.jsp";
	public static final String PAGE_OFFBOARD_USER = "pages/offboard.jsp";
	public static final String PAGE_VIEW_REPORT = "pages/report.jsp";
	public static final String PAGE_LOCATION_REPORT = "pages/locationreport.jsp";
	public static final String PAGE_ONBOARD_REPORT = "pages/onboardreport.jsp";
	public static final String PAGE_OFFBOARD_REPORT = "pages/offboardreport.jsp	";
	public static final String PAGE_ADD_FAVOURITE = "pages/addfavourites.jsp";
	public static final String PAGE_UPDATE_ONBOARDING = "pages/updateonboarding.jsp";
	
	// DAOs
	public static final String DAO_USER 	= "UserDAO";
	public static final String DAO_ADMIN 	= "AdminDAO";
	public static final String DAO_DOCUMENT 	= "DocumentDAO";
	public static final String DAO_TRAINING 	= "TrainingDAO";
	public static final String DAO_USERTRAINING 	= "UserTrainingDAO";
    public static final String DAO_ONBOARDING = "OnboardingDAO";
    public static final String DAO_USERONBOARDING = "UserOnboardingDAO";
    public static final String DAO_FAVOURITES = "FavouritesDAO";
    public static final String DAO_LOCATION_REPORT = "LocationReportDAO";
	public static final String DAO_ONBOARD_REPORT = "OnboardReportDAO";
	public static final String DAO_OFFBOARD_REPORT = "OffboardReportDAO";
	
    public static final long DEFAULT_ADMIN 	= 222;
	
	
		
	
}

