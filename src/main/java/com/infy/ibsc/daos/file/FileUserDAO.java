package com.infy.ibsc.daos.file;

import com.infy.ibsc.vos.UserVO;

import com.infy.ibsc.vos.VO;

public class FileUserDAO extends FileDAO {

	@Override
	protected boolean isMatching(VO vo, VO voSrch) {
		System.out.println("FileUserDAO: inside isMatching");
		boolean matching = true;
		UserVO srchUser = (UserVO) voSrch;
		UserVO user = (UserVO) vo;
		
		
		// Fields to be used for searching
		if(matching) {
			matching = this.match(user.getEmpId(), srchUser.getEmpId());
		}
		
		if(matching) {
			matching = this.match( user.getPass(), srchUser.getPass());
		}
		
		if(matching) {
			matching = this.match( user.getFirstName(), srchUser.getFirstName());
		}
		
		if(matching) {
			matching = this.match( user.getLastName(), srchUser.getLastName());
		}
		if(matching) {
			matching = this.match(user.getCqno(), srchUser.getCqno());
		}
		if(matching) {
			matching = this.match(user.getCqans(), srchUser.getCqans());
		}
				
		return matching;
	}
}
