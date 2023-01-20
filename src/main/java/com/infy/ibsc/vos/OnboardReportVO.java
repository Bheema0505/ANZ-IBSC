package com.infy.ibsc.vos;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.infy.ibsc.util.SQLUtil;

import com.infy.ibsc.util.StrUtil;

public class OnboardReportVO extends ReportVO {

	private String firstName = null;
	private String lastName = null;
	private long empId = 0;
	private String Ob_Status = null;
	private String anzLanId = null;
	private String anzSquad = null;
	private String location = null;
	private String role = "Engineer";
	private String onboarding_date = null;

	public String getName() {
		return firstName + " " + lastName;
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

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getOb_Status() {
		return Ob_Status;
	}

	public void setOb_Status(String ob_Status) {
		Ob_Status = ob_Status;
	}

	public String getAnzLanId() {
		return anzLanId;
	}

	public void setAnzLanId(String anzLanId) {
		this.anzLanId = anzLanId;
	}

	public String getAnzSquad() {
		return anzSquad;
	}

	public void setAnzSquad(String anzSquad) {
		this.anzSquad = anzSquad;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOnboarding_date() {
		return onboarding_date;
	}

	public void setOnboarding_date(String onboarding_date) {
		this.onboarding_date = onboarding_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ReportVO [firstName=" + firstName + ", lastName=" + lastName + ",empId=" + empId + ",Ob_Status="
				+ Ob_Status + ",location=" + location + ",anzLanId=" + anzLanId + ",anzSquad=" + anzSquad
				+ ",onboarding_date=" + onboarding_date + "]";
	}

	@Override
	public String selectQuery() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    String dt = sdf.format(new Date());
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * FROM IBSC_USER WHERE Ob_Status != 'Offboarded' and Ob_Status != 'Unregistered' ");
		buf.append(" AND Onboarding_Date >= '").append(sdf.format(reportStartDate)).append("'");
		buf.append(" AND Onboarding_Date <= '").append(sdf.format(reportEndDate)).append("'");

		return buf.toString();
	}

	@Override
	public String getTitle() {
		return "Onboarding Report";
	}

}
