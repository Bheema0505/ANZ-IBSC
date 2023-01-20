package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;

import com.infy.ibsc.util.StrUtil;

public class UserOnboardingVO extends VO {

	private int Step_Id = 0;
	private long emp_id = 0;
	private String OB_Status = null;
	private long Assigned_To = 0;
	private String Remarks = null;
	//private String reference = null;

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public int getStep_Id() {
		return Step_Id;
	}

	public void setStep_Id(int Step_Id) {
		this.Step_Id = Step_Id;
	}

	public String getOB_Status() {
		return OB_Status;
	}

	public void setOB_Status(String oB_Status) {
		this.OB_Status = oB_Status;
	}

	public long getAssigned_To() {
		return Assigned_To;
	}

	public void setAssigned_To(long assigned_To) {
		this.Assigned_To = assigned_To;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		this.Remarks = remarks;
	}



	@Override
	public String toString() {
		return "UserOnboardingVO [emp_id=" + emp_id + ", Step_Id=" + Step_Id + ", OB_Status=" + OB_Status
				+ ", Assigned_To=" + Assigned_To + " , Remarks=" + Remarks + "]";
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();

		buf.append(this.emp_id);
		buf.append("\t");
		buf.append(this.Step_Id);
		buf.append("\t");
		buf.append(this.OB_Status);
		buf.append("\t");
		buf.append(this.Assigned_To);
		buf.append("\t");
		buf.append(this.Remarks);
		buf.append("\t");

		return buf.toString();
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_OB_USER (Emp_Id,Step_Id,OB_Status,Assigned_To,Remarks)");
		buf.append(" SELECT ").append(emp_id).append(",");
		buf.append("").append(Step_Id).append(",");
		buf.append("'").append(OB_Status).append("',");
		buf.append("").append(Assigned_To).append(",");
		buf.append("'").append(Remarks).append("'");
		

		return buf.toString();
	}

	@Override
	public String updateQuery() {

		//return null;
		StringBuffer buf = new StringBuffer();
		buf.append("update IBSC_OB_USER set ");
		
		String sql = "";
		sql+=SQLUtil.getUpdateCriteria(sql,"OB_Status", OB_Status);
		sql+=SQLUtil.getUpdateCriteria(sql,"Assigned_To", Assigned_To);
		sql+=SQLUtil.getUpdateCriteria(sql,"Remarks", Remarks);
		

		buf.append(sql);
		
		buf.append(" WHERE Emp_Id=").append(emp_id);
		buf.append(" AND Step_Id=").append(Step_Id);
		

		return buf.toString();
	}

	@Override
	public String deleteQuery() {
		return null;
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_OB_USER ");
		String criteria = "";
		criteria += SQLUtil.getFilterCriteria(criteria, "Emp_Id", emp_id);
		criteria += SQLUtil.getFilterCriteria(criteria, "Step_Id", Step_Id);
		criteria += SQLUtil.getFilterCriteria(criteria, "OB_Status", OB_Status);
		criteria += SQLUtil.getFilterCriteria(criteria, "Assigned_To", Assigned_To);
		criteria += SQLUtil.getFilterCriteria(criteria, "Remarks", Remarks);
	
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
