package com.infy.ibsc.vos;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.infy.ibsc.util.SQLUtil;

import com.infy.ibsc.util.StrUtil;

public class OffboardReportVO extends ReportVO {

	private String firstName = null;
	private String lastName = null;
	private String salaryid = null;
	private String anzSquad = null;
	private String location = null;
	private String remarks = null;
	private String replacement = null;
	private String offboarding_date = null;

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

	public String getSalaryid() {
		return salaryid;
	}

	public void setSalaryid(String salaryid) {
		this.salaryid = salaryid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAnzSquad() {
		return anzSquad;
	}

	public void setAnzSquad(String anzSquad) {
		this.anzSquad = anzSquad;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	public String getOffboarding_date() {
		return offboarding_date;
	}

	public void setOffboarding_date(String offboarding_date) {
		this.offboarding_date = offboarding_date;
	}

	@Override
	public String toString() {
		return "ReportVO [firstName=" + firstName + ", lastName=" + lastName + ",salaryid=" + salaryid + ",anzSquad="
				+ anzSquad + ",remarks=" + remarks + ",replacement=" + replacement + ",offboarding_date="
				+ offboarding_date + ",location=" + location + "]";
	}

	@Override
	public String selectQuery() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String dt = sdf.format(new Date());
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * FROM IBSC_USER WHERE Ob_Status = 'Offboarded' ");
		buf.append(" AND Offboarding_Date >= '").append(sdf.format(reportStartDate)).append("'");
		buf.append(" AND Offboarding_Date <= '").append(sdf.format(reportEndDate)).append("'");

		return buf.toString();
	}

	@Override
	public String getTitle() {
		return "Off-Board Report";
	}

}
