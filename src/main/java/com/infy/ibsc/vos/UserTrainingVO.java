package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;

import com.infy.ibsc.util.StrUtil;

public class UserTrainingVO extends VO {

	private String user_tr_id = null;
	private String emp_id = null;
	private String status = null;
	private String actual_date = null;
	private String due_date = null;
	private String training_id = null;
	

	public String getUser_tr_id() {
		return user_tr_id;
	}

	public void setUser_tr_id(String user_tr_id) {
		this.user_tr_id = user_tr_id;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActual_date() {
		return actual_date;
	}

	public void setActual_date(String actual_date) {
		this.actual_date = actual_date;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getTraining_id() {
		return training_id;
	}

	public void setTraining_id(String training_id) {
		this.training_id = training_id;
	}

	@Override
	public String toString() {
		return "UserTrainingVO [user_tr_id=" + user_tr_id + ", emp_id=" + emp_id + ", status=" + status
				+ ", actual_date=" + actual_date + ", due_date=" + due_date + " , training_id=" + training_id + "]";
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.user_tr_id);
		buf.append("\t");
		buf.append(this.emp_id);
		buf.append("\t");
		buf.append(this.status);
		buf.append("\t");
		buf.append(this.actual_date);
		buf.append("\t");
		buf.append(this.due_date);
		buf.append("\t");
		buf.append(this.training_id);
		buf.append("\t");

		return buf.toString();
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_USER_Training (User_Tr_ID,Emp_ID,Status,Due_Date,Training_id)");
		buf.append(" SELECT '").append(user_tr_id).append("',");
		buf.append("").append(emp_id).append(",");
		buf.append("'").append(status).append("',");
		//buf.append("'").append(actual_date).append("',");
		buf.append("'").append(due_date).append("',");
		buf.append("'").append(training_id).append("'");

		return buf.toString();
	}

	@Override
	public String updateQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append(" UPDATE IBSC_USER_TRAINING SET  ");
		String sql = "";
		
		sql+=SQLUtil.getUpdateCriteria(sql,"Status", status);
		sql+=SQLUtil.getUpdateCriteria(sql,"Actual_Date",actual_date);
		sql+=SQLUtil.getUpdateCriteria(sql,"Due_Date",due_date);
		 
		
	    buf.append(sql);
		
		buf.append(" WHERE User_Tr_ID='").append(user_tr_id).append("'");
		
		return buf.toString();
	}


	@Override
	public String deleteQuery() {
		return null;
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_USER_Training ");
		String criteria = "";
		criteria += SQLUtil.getFilterCriteria(criteria, "User_Tr_ID", user_tr_id);
		criteria += SQLUtil.getFilterCriteria(criteria, "Emp_ID", emp_id);
		criteria += SQLUtil.getFilterCriteria(criteria, "Status", status);
		criteria += SQLUtil.getFilterCriteria(criteria, "Actual_Date", actual_date);
		criteria += SQLUtil.getFilterCriteria(criteria, "Due_Date", due_date);
		criteria += SQLUtil.getFilterCriteria(criteria, "Training_id", training_id);

		if (!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
