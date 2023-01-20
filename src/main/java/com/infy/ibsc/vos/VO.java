package com.infy.ibsc.vos;

import com.infy.ibsc.framework.BaseObject;

public abstract class VO extends BaseObject{
	 public String fileName;public String table;
	 public  VO create(String line){return null;}
	 public abstract String getLine();
	 public String key;
	 public boolean findAll=true;
	 public abstract String getTitle();

	 public abstract String insertQuery();
	 public abstract String updateQuery();
	 public abstract String deleteQuery();
	 public abstract String selectQuery();
}
