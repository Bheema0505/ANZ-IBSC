package com.infy.ibsc.util;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.infy.ibsc.daos.DAO;
import com.infy.ibsc.daos.DAOFactory;
import com.infy.ibsc.vos.TrainingVO;


public class TrainingUtil {

	private static TrainingUtil trUtil = new TrainingUtil();


	private TrainingUtil() {super();this.initCache();}
	
	public static TrainingUtil getInstance() {return trUtil;}
	
	HashMap hm = new HashMap();
	
	private void initCache() {
		System.out.println("Cache: Initiating Cache ...");
		TrainingVO trainingvo = new TrainingVO();
		DAO dao = DAOFactory.getInstance().getDAO(IBConstants.DAO_TRAINING);
		ArrayList list = dao.find(trainingvo);
		 if(list != null && list.size() > 0){
		    	for(int i=0;i<list.size();i++){
		    	
		    	TrainingVO trVo = (TrainingVO)list.get(i);
		    	hm.put(trVo.getTr_id(), trVo);
		    	}
		    }
		System.out.println("hm="+hm);
		
	}
	
	public TrainingVO getTraining(String tr_id) {
		
		return (TrainingVO) 
		hm.get(tr_id);
	}
	
	public Iterator iterator() {
		return hm.keySet().iterator();
	}
}

