package com.infy.ibsc.vos;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public class UserVO extends VO {

	private long empId = 0;
	private String pass = null;
	private String cpass;
	private String firstName = null;
	private String lastName = null;
	private String email = null;
	private String cqno = null;
	private String cqans = null;
	private String Ob_Status = null;
	private int Pending_Trainings = 0;
	private int Total_Trainings = 0;
	private String location = null;
	private String role = "Engineer";
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	private String anzMailId = null;
	private String anzLanId = null;
	private long anzEmpId = 0;
	private String anzSquad = null;
	private String program = null;
	
	
	public String getName() {
		return firstName + " " + lastName;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCqno() {
		return cqno;
	}

	public void setCqno(String cqno) {
		this.cqno = cqno;
	}

	public String getCqans() {
		return cqans;
	}

	public void setCqans(String cqans) {
		this.cqans = cqans;
	}
	
	public String getAnzMailId() {
		return anzMailId;
	}

	public void setAnzMailId(String anzMailId) {
		this.anzMailId = anzMailId;
	}

	public String getAnzLanId() {
		return anzLanId;
	}

	public void setAnzLanId(String anzLanId) {
		this.anzLanId = anzLanId;
	}

	public long getAnzEmpId() {
		return anzEmpId;
	}

	public void setAnzEmpId(long anzEmpId) {
		this.anzEmpId = anzEmpId;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	public String getAnzSquad() {
		return anzSquad;
	}

	public void setAnzSquad(String anzSquad) {
		this.anzSquad = anzSquad;
	}
	
	
	@Override
	public String toString() {
		return "UserVO [empId=" + empId + ", pass=" + pass + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Ob_Status=" + Ob_Status + ",Pending_Trainings=" + Pending_Trainings +",Total_Trainings=" + Total_Trainings +",location=" + location+"]";
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

	public String getcPass() {
		return cpass;
	}

	public void setcPass(String pass) {
		this.cpass = cpass;
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

	public String getOb_Status() {
		return Ob_Status;
	}

	public void setOb_Status(String ob_Status) {
		this.Ob_Status = ob_Status;
	}

	

	@Override
	public String getLine() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.empId);
		buf.append("\t");
		buf.append(this.pass);
		buf.append("\t");
		buf.append(this.firstName);
		buf.append("\t");
		buf.append(this.lastName);
		buf.append("\t");
		buf.append(this.email);
		buf.append("\t");
		buf.append(this.cqno);
		buf.append("\t");
		buf.append(this.cqans);
		buf.append("\t");
		buf.append(this.Ob_Status);
		buf.append("\t");
		buf.append(this.Pending_Trainings);
		buf.append("\t");
		buf.append(this.Total_Trainings);
		buf.append("\t");
		buf.append(this.location);
		buf.append("\t");

		return buf.toString();
	}

	@Override
	public String getTitle() {
		return "#EmpID	Passwd	FirstName	LastName	Email-id	Q NO.	Ans.	ob_status.	Pending_trainings.	Total_trainings	Location";
	}

	@Override
	public VO create(String line) {
		// ID Passwd FirstName LastName
		String[] arr = line.split("\t");

		UserVO vo = new UserVO(0);
		vo.setEmpId(Long.parseLong(arr[0]));
		vo.setPass(arr[1]);
		vo.setFirstName(arr[2]);
		vo.setLastName(arr[3]);
		vo.setEmail(arr[4]);
		vo.setCqno(arr[5]);
		vo.setCqans(arr[6]);
		vo.setOb_Status(arr[7]);
		vo.setPending_Trainings(Integer.parseInt(arr[8]));
		vo.setTotal_Trainings(Integer.parseInt(arr[9]));
		vo.setLocation(arr[10]);
		return vo;
	}

	public int getPending_Trainings() {
		return Pending_Trainings;
	}

	public void setPending_Trainings(int pending_Trainings) {
		Pending_Trainings = pending_Trainings;
	}

	public int getTotal_Trainings() {
		return Total_Trainings;
	}

	public void setTotal_Trainings(int total_Trainings) {
		Total_Trainings = total_Trainings;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UserVO(long empId) {
		super();
		this.empId = empId;
		this.fileName = "Users.txt";
		this.table = "IBSC_USER";
	}

	@Override
	public String insertQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("INSERT INTO IBSC_USER (Emp_Id,Pswd,FirstName,LastName,Email_id,CQ,Ans,Ob_Status,Pending_Trainings,Total_Trainings,Location)");
		buf.append(" SELECT ").append(empId).append(",");
		buf.append("'").append(pass).append("',");
		buf.append("'").append(StrUtil.nullToBlank(firstName)).append("',");
		buf.append("'").append(StrUtil.nullToBlank(lastName)).append("',");
		buf.append("'").append(StrUtil.nullToBlank(email)).append("',");
		buf.append("'").append(StrUtil.nullToBlank(cqno)).append("',");
		buf.append("'").append(StrUtil.nullToBlank(cqans)).append("',");
		buf.append("'").append(Ob_Status).append("',");
		buf.append(Pending_Trainings).append(",");
		buf.append(Total_Trainings).append(",");
		buf.append("'").append(StrUtil.nullToBlank(location)).append("'");

		return buf.toString();
	}

	@Override
	public String updateQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append(" UPDATE IBSC_USER SET  ");
		String sql = "";
		sql+=SQLUtil.getUpdateCriteria(sql,"Pswd", pass);
		sql+=SQLUtil.getUpdateCriteria(sql,"FirstName", firstName);
		sql+=SQLUtil.getUpdateCriteria(sql,"LastName", lastName);
		sql+=SQLUtil.getUpdateCriteria(sql,"Email_Id", email);
		sql+=SQLUtil.getUpdateCriteria(sql,"Ob_Status",Ob_Status);
		sql+=SQLUtil.getUpdateCriteria(sql,"Location",location);
		sql+=SQLUtil.getUpdateCriteria(sql,"Pending_Trainings",Pending_Trainings);
		sql+=SQLUtil.getUpdateCriteria(sql,"Total_Trainings",Total_Trainings);
		 
		
		sql+=SQLUtil.getUpdateCriteria(sql,"ANZ_Mail_ID", anzMailId);
		sql+=SQLUtil.getUpdateCriteria(sql,"ANZ_LAN_ID", anzLanId);
		sql+=SQLUtil.getUpdateCriteria(sql,"ANZ_Squad", anzSquad);
		sql+=SQLUtil.getUpdateCriteria(sql,"Program",program);
		
		sql+=SQLUtil.getUpdateCriteria(sql,"CQ",cqno);
		sql+=SQLUtil.getUpdateCriteria(sql,"Ans",cqans);

		buf.append(sql);
		
		buf.append(" WHERE Emp_Id=").append(empId);
		
		return buf.toString();
	}

	@Override
	public String deleteQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM IBSC_USER WHERE Emp_Id=").append(empId); 
		
		return buf.toString();
	}

	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * from IBSC_USER ");
		String criteria = "";
		
		if(!findAll) {
			criteria  += SQLUtil.getFilterCriteria(criteria, "Emp_Id", empId);
			criteria  += SQLUtil.getFilterCriteria(criteria, "Pswd", pass);
			criteria  += SQLUtil.getFilterCriteria(criteria, "firstName", firstName);
			criteria  += SQLUtil.getFilterCriteria(criteria, "LastName", lastName);
			criteria  += SQLUtil.getFilterCriteria(criteria, "Email_Id", email);
			criteria  += SQLUtil.getFilterCriteria(criteria, "Ob_Status",Ob_Status);
			criteria  += SQLUtil.getFilterCriteria(criteria, "ANZ_Squad",anzSquad);
			
			
			
			criteria  += SQLUtil.getFilterCriteria(criteria, "CQ",cqno);
			criteria  += SQLUtil.getFilterCriteria(criteria, "Ans",cqans);
			criteria  += SQLUtil.getFilterCriteria(criteria, " Pending_Trainings", Pending_Trainings );
			criteria  += SQLUtil.getFilterCriteria(criteria, "Total_Trainings", Total_Trainings);
			criteria  += SQLUtil.getFilterCriteria(criteria, "Location",location);
		}
		
		if(!StrUtil.isNullOrBlank(criteria.trim())) {
			buf.append("WHERE ").append(criteria);
		}

		return buf.toString();
	}

}
