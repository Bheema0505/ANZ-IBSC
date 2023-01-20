package com.infy.ibsc.util;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.vos.OnboardingVO;


public class OnboardingUtil {

	private static OnboardingUtil obUtil = new OnboardingUtil();
	private OnboardingUtil() {super();this.initCache();}
	public static OnboardingUtil getInstance() {return obUtil;}
	HashMap hm = new HashMap();
	private void initCache() {
		System.out.println("Cache: Initiating Cache ...");
		OnboardingVO onboardingvo = new OnboardingVO();
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_ONBOARDING);
		ArrayList list = dao.find(onboardingvo);
		 if(list != null && list.size() > 0){
		    	for(int i=0;i<list.size();i++){
		    	
		    	OnboardingVO obVo = (OnboardingVO)list.get(i);
		    	hm.put(obVo.getStep_Id(), obVo);
		    	}
		    }
		System.out.println("hm="+hm);
		
	}
	
	public OnboardingVO getOnboarding(int Step_Id) {
		
		return (OnboardingVO) 
		hm.get(Step_Id);
	}
	
	public Iterator iterator() {
		return hm.keySet().iterator();
	}
	
}


