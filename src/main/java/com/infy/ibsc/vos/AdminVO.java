package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public class AdminVO extends VO {
	
	private long empId 	= 0;
	private String pass = null;
	private String firstName = null;
	private String lastName = null;
	private String email = null;
	
	

	@Override
	public String toString() {
		return "AdminVO [empId=" + empId + ", pass=" + pass + ", firstName="+ firstName+ ", lastName="+ lastName+ ", email="+ email+ "]";
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.empId);buf.append("\t");
		buf.append(this.pass);buf.append("\t");
		
		
		return buf.toString();
	}

	@Override
	public String getTitle() {
		return "#EmpID	Password";
	}
	@Override
	public VO create(String line) {
		// ID	Passwd	FirstName LastName 
		String [] arr = line.split("\t");
		
		AdminVO vo = new AdminVO(0);
		vo.setEmpId(Long.parseLong(arr[0]));
		vo.setPass(arr[1]);
		
		return vo;
	}

	public AdminVO(long empId) {
		super();
		this.empId = empId;
		this.fileName="Users.txt";
		this.table="IBSC_ADMIN";
	}


	//@Override
	/*public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_ADMIN (Emp_Id,Pswd,FirstName,LastName,Email_Id,CQ,Ans,Ob_Status,Pending_Trainings,Total_Trainings)");
		buf.append(" SELECT ").append(empId).append(",");
		buf.append("'").append(pass).append("',");
		buf.append("'").append(firstName).append("',");
		buf.append("'").append(lastName).append("',");
		buf.append("'").append(email).append("',");
		buf.append("'").append(cqno).append("',");
		buf.append("'").append(cqans).append("',");
		buf.append("'").append(Ob_Status).append("',");
		buf.append("'").append(Pending_Trainings).append("',");
		buf.append("'").append(Total_Trainings).append("'");

		return buf.toString();
	}*/

	@Override
	/*public String updateQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append(" UPDATE IBSC_USER SET  ");
		buf.append(" SELECT ").append(empId).append(",");
		buf.append("'").append(pass).append("',");
		return buf.toString();
	}

	@Override
	public String deleteQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM IBSC_USER WHERE Emp_Id=").append(empId); 
		
		return buf.toString();
	}*/

//	@Overrid
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_ADMIN ");
		String criteria = "";
		criteria  += SQLUtil.getFilterCriteria(criteria, "Emp_Id", empId);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Password", pass);
		criteria  += SQLUtil.getFilterCriteria(criteria, "FirstName", firstName);
		criteria  += SQLUtil.getFilterCriteria(criteria, "LastName", lastName);
		criteria  += SQLUtil.getFilterCriteria(criteria, "Email_Id", email);
		
		
		if(!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_ADMIN (Emp_Id,Password, Email_Id,Firstname, Lastname) ");
		buf.append(" VALUES ( ").append(empId).append(",");
		buf.append("'").append(pass).append("',");
		buf.append("'").append(email).append("',");
		buf.append("'").append(firstName).append("',");
		buf.append("'").append(lastName).append("')");
	
		return buf.toString();
	}

	@Override
	public String updateQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("UPDATE IBSC_ADMIN SET  Password='").append(this.pass).append("'");
		buf.append(" WHERE Emp_Id=").append(empId);
		return buf.toString();
	}

	@Override
	public String deleteQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM IBSC_ADMIN");
		buf.append(" WHERE Emp_Id=").append(empId);
		return buf.toString();
		
	}


	
}
