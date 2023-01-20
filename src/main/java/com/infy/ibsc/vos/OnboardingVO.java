package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public class OnboardingVO extends VO {

	private int Step_Id = 0;
	private String Step_Desc = null;
	private String Applicable_Location = null;
	private String Applicable_Roles = null;
	private String Reference = null;
	
	private String assignee=null;

	public int getStep_Id() {
		return Step_Id;
	}

	public void setStep_Id(int Step_Id) {
		this.Step_Id = Step_Id;
	}

	public String getStep_Desc() {
		return Step_Desc;
	}

	public void setStep_Desc(String Step_Desc) {
		this.Step_Desc = Step_Desc;
	}

	public String getApplicable_Location() {
		return Applicable_Location;
	}

	public void setApplicable_Location(String Applicable_Location) {
		this.Applicable_Location = Applicable_Location;
	}

	public String getApplicable_Roles() {
		return Applicable_Roles;
	}

	public void setApplicable_Roles(String Applicable_Roles) {
		this.Applicable_Roles = Applicable_Roles;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String Reference) {
		this.Reference = Reference;
	}
	
	
	


	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}



	@Override
	public String toString() {
		return "OnboardingVO [Step_Id=" + Step_Id + ", Step_Desc=" + Step_Desc + ", Applicable_Location="
				+ Applicable_Location + ", Applicable_Roles=" + Applicable_Roles + ", Reference=" + Reference
				+ ", assignee=" + assignee + "]";
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.Step_Id);
		buf.append("\t");
		buf.append(this.Step_Desc);
		buf.append("\t");
		buf.append(this.Reference);
		buf.append("\t");
		buf.append(this.Applicable_Location);
		buf.append("\t");
		buf.append(this.Applicable_Roles);
		buf.append("\t");
		
		buf.append(this.assignee);
		buf.append("\t");
		
		return buf.toString();
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_OB_MASTER (Step_Id,Step_Desc,Reference,Applicable_Location,Applicable_Roles,Asignee)");
		buf.append(" SELECT ").append(Step_Id).append(",");
		buf.append("'").append(Step_Desc).append("',");
		buf.append("'").append(Reference).append("',");
		buf.append("'").append(Applicable_Location).append("',");
		buf.append("'").append(Applicable_Roles).append("',");
		buf.append("'").append(assignee).append("'");

		return buf.toString();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_OB_MASTER ");
		String criteria = "";
		criteria += SQLUtil.getFilterCriteria(criteria, "Step_Id", Step_Id);
		criteria += SQLUtil.getFilterCriteria(criteria, "Step_Desc", Step_Desc);
		criteria += SQLUtil.getFilterCriteria(criteria, "Reference", Reference);
		criteria += SQLUtil.getFilterCriteria(criteria, "Applicable_Location", Applicable_Location);
		criteria += SQLUtil.getFilterCriteria(criteria, "Applicable_Roles", Applicable_Roles);
		criteria += SQLUtil.getFilterCriteria(criteria, "Assignee", assignee);

		if (!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}

	/*
	 * @Override public String updateQuery() { StringBuffer buf = new
	 * StringBuffer(); buf.append(" UPDATE IBSC_Documents SET  ");
	 * buf.append(" SELECT ").append(document_id).append(",");
	 * buf.append("'").append(pass).append("',"); return buf.toString(); }
	 * 
	 * @Override public String deleteQuery() { StringBuffer buf = new
	 * StringBuffer();
	 * buf.append("DELETE FROM IBSC_USER WHERE Emp_Id=").append(empId);
	 * 
	 * return buf.toString(); }
	 * 
	 * @Override public String selectQuery() { StringBuffer buf = new
	 * StringBuffer(); buf.append("SELECT * from IBSC_USER "); String criteria = "";
	 * criteria += SQLUtil.getFilterCriteria(criteria, "Emp_Id", empId); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, "Pswd", pass); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, "firstName", firstName); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, "LastName", lastName); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, "Email_Id", email); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, " CQ", cqno); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, "  Ob_Status",Ob_Status); criteria +=
	 * SQLUtil.getFilterCriteria(criteria, " Ob_Status", Ob_Status);
	 * 
	 * if(!StrUtil.isNullOrBlank(criteria.trim())) {
	 * buf.append("WHERE ").append(criteria); }
	 * 
	 * return buf.toString(); }
	 */

}
