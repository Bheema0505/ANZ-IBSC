package com.infy.ibsc.vos;

import java.util.Date;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public abstract class ReportVO extends VO {

	protected Date reportStartDate=new Date();
	protected Date reportEndDate = new Date();

	public Date getReportStartDate() {
		return reportStartDate;
	}


	public void setReportStartDate(Date reportStartDate) {
		this.reportStartDate = reportStartDate;
	}


	public Date getReportEndDate() {
		return reportEndDate;
	}


	public void setReportEndDate(Date reportEndDate) {
		this.reportEndDate = reportEndDate;
	}


	@Override
	public String getLine() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String insertQuery() {
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

}
