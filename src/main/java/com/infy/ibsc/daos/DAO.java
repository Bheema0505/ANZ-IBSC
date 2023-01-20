package com.infy.ibsc.daos;

import java.util.ArrayList;

import com.infy.ibsc.framework.BaseObject;
import com.infy.ibsc.vos.VO;

public abstract class DAO extends BaseObject{
	
	public abstract int add(VO vo);
	
	public abstract int edit(VO vo);
	
	public abstract ArrayList find(VO vo);
	
	public abstract int delete(VO vo);
	
}
