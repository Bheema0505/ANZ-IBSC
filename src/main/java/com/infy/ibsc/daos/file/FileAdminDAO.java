package com.infy.ibsc.daos.file;

import com.infy.ibsc.vos.AdminVO;

import com.infy.ibsc.vos.VO;

public class FileAdminDAO extends FileDAO {

	@Override
	protected boolean isMatching(VO vo, VO voSrch) {
		System.out.println("FileAdminDAO: inside isMatching");
		boolean matching = true;
		AdminVO srchUser = (AdminVO) voSrch;
		AdminVO user = (AdminVO) vo;
		
		
		// Fields to be used for searching
		if(matching) {
			matching = this.match(user.getEmpId(), srchUser.getEmpId());
		}
		
		if(matching) {
			matching = this.match( user.getPass(), srchUser.getPass());
		}
		return matching;
		
		
	}
}
