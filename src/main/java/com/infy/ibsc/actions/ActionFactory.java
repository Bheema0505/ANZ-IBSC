package com.infy.ibsc.actions;

import java.util.HashMap;

import com.infy.ibsc.util.IBConstants;
import com.infy.ibsc.util.LogUtil;

public class ActionFactory {
	private static HashMap actions = new HashMap();
	private static ActionFactory _instance = new ActionFactory();
    private ActionFactory() {this.load();}
	public static ActionFactory getInstance() {return _instance;}
	
	private void load() {
		actions.put(IBConstants.ACTION_USER_LOGIN, "com.infy.ibsc.actions.UserLoginAction");
		actions.put(IBConstants.ACTION_FORGOT_PASSWORD, "com.infy.ibsc.actions.ForgotPasswordAction");
		actions.put(IBConstants.ACTION_VALIDATE_EMPID, "com.infy.ibsc.actions.ValidateEmpIDAction");
		actions.put(IBConstants.ACTION_VALIDATE_SQ, "com.infy.ibsc.actions.ValidateSQAction");
		actions.put(IBConstants.ACTION_CHANGE_PASSWORD, "com.infy.ibsc.actions.ChangePasswordAction");
		actions.put(IBConstants.ACTION_ADMIN_LOGIN, "com.infy.ibsc.actions.AdminLoginAction");
		actions.put(IBConstants.ACTION_USER_REGISTER, "com.infy.ibsc.actions.UserRegisterAction");
		actions.put(IBConstants.ACTION_VIEW_TRAININGS, "com.infy.ibsc.actions.ViewTrainingAction");
		actions.put(IBConstants.ACTION_REMOVE_ADMIN, "com.infy.ibsc.actions.RemoveAdmin");
		actions.put(IBConstants.ACTION_REMOVE_USER, "com.infy.ibsc.actions.RemoveUser");
		actions.put(IBConstants.ACTION_LOGOUT, "com.infy.ibsc.actions.LogoutAction");
		actions.put(IBConstants.ACTION_FAVOURITE, "com.infy.ibsc.actions.FavouriteAction");
		actions.put(IBConstants.ACTION_ONBOARDING, "com.infy.ibsc.actions.OnboardingAction");
		actions.put(IBConstants.ACTION_VIEW_PROFILE, "com.infy.ibsc.actions.ViewProfileAction");
		actions.put(IBConstants.ACTION_USER_HOME, "com.infy.ibsc.actions.UserHomeAction");
		actions.put(IBConstants.ACTION_VIEW_DOCUMENTS, "com.infy.ibsc.actions.ViewDocumentAction");
		actions.put(IBConstants.ACTION_EDIT_PROFILE, "com.infy.ibsc.actions.EditProfileAction");
        actions.put(IBConstants.ACTION_ADD_USER, "com.infy.ibsc.actions.AddUserAction");	
        actions.put(IBConstants.ACTION_MANAGE_USER, "com.infy.ibsc.actions.ManageUserAction");
		actions.put(IBConstants.ACTION_SEARCH_USER, "com.infy.ibsc.actions.SearchUserAction");
		actions.put(IBConstants.ACTION_SEARCH_ADMIN, "com.infy.ibsc.actions.SearchAdminAction");
		actions.put(IBConstants.ACTION_SEARCH_DOCUMENT, "com.infy.ibsc.actions.SearchDocumentAction");
		actions.put(IBConstants.ACTION_MANAGE_ADMIN, "com.infy.ibsc.actions.ManageAdminAction");
		actions.put(IBConstants.ACTION_ADD_NEW_ADMIN, "com.infy.ibsc.actions.AddNewAdminAction");
		actions.put(IBConstants.ACTION_USER_INFORMATION, "com.infy.ibsc.actions.UserInformationAction");
		actions.put(IBConstants.ACTION_ADMIN_MANAGETRAINING, "com.infy.ibsc.actions.ManageTrainingAction");
		actions.put(IBConstants.ACTION_ADMIN_ADDTRAINING, "com.infy.ibsc.actions.AddTrainingAction");
		actions.put(IBConstants.ACTION_EDIT_USERINFORMATION, "com.infy.ibsc.actions.EditUserInformationAction");
		actions.put(IBConstants.ACTION_START_ONBOARDING, "com.infy.ibsc.actions.StartOnboardingAction");
		actions.put(IBConstants.ACTION_OFFBOARD_USER, "com.infy.ibsc.actions.OffboardUserAction");
		actions.put(IBConstants.ACTION_ADD_FAVOURITE, "com.infy.ibsc.actions.AddFavouriteAction");
		actions.put(IBConstants.ACTION_SEARCH_ADMIN, "com.infy.ibsc.actions.SearchAdminAction");
		actions.put(IBConstants.ACTION_ADMIN_LOGOUT, "com.infy.ibsc.actions.AdminLogoutAction");
		actions.put(IBConstants.ACTION_COMPLETE_ONBOARDING, "com.infy.ibsc.actions.CompleteOnboardingAction");
 		actions.put(IBConstants.ACTION_MANAGETRAINING_DETAILS, "com.infy.ibsc.actions.ManageTrainingDetailsAction");
		actions.put(IBConstants.ACTION_ADMIN_REGISTER_TRAINING, "com.infy.ibsc.actions.AdminRegisterTrainingAction");
		actions.put(IBConstants.ACTION_COMPLETE_TRAINING, "com.infy.ibsc.actions.CompleteTrainingAction");
		actions.put(IBConstants.ACTION_LOCATION_REPORT, "com.infy.ibsc.actions.LocationReportAction");
		actions.put(IBConstants.ACTION_VIEW_REPORT, "com.infy.ibsc.actions.ViewReportAction");
		actions.put(IBConstants.ACTION_ONBOARD_REPORT, "com.infy.ibsc.actions.OnboardReportAction");
		actions.put(IBConstants.ACTION_OFFBOARD_REPORT, "com.infy.ibsc.actions.OffboardReportAction");
		actions.put(IBConstants.ACTION_REMOVE_FAVOURITE, "com.infy.ibsc.actions.RemoveFavouriteAction");
		actions.put(IBConstants.ACTION_SEARCH_FAVOURITE, "com.infy.ibsc.actions.SearchFavouriteAction");
		actions.put(IBConstants.ACTION_UPDATE_ONBOARDING, "com.infy.ibsc.actions.UpdateOnboardingAction");
		actions.put(IBConstants.ACTION_COMPLETE_STEP, "com.infy.ibsc.actions.CompleteStepAction");
       
	}

	public static BaseAction getAction(String actionStr) {
		LogUtil logger = new LogUtil();
		String actionClass = (String)actions.get(actionStr);
		logger.debug("ActionFactory: actionClass="+actionClass);
	
		try {
			Class cls = Class.forName(actionClass);
			logger.debug("ActionFactory: Found class="+cls);
			BaseAction bAction = (BaseAction)cls.getConstructor(null).newInstance();
			logger.debug("ActionFactory: bAction="+bAction);
			return bAction;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
