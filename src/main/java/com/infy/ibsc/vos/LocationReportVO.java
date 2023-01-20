package com.infy.ibsc.vos;

import java.util.Date;

import com.infy.ibsc.util.SQLUtil;
import com.infy.ibsc.util.StrUtil;

public class LocationReportVO extends ReportVO {

	public LocationReportVO() {
		super();
		this.reportStartDate = new Date();
		this.reportEndDate = reportStartDate;
	}


	private String location = null;
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLocation() {
		return StrUtil.nullToBlank(location);
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "ReportVO [location=" + location + ", count=" + count + "]";
	}



	@Override
	public String selectQuery() {
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT Location, COUNT(*) AS TOTAL_EMPLOYEES FROM IBSC_USER GROUP BY Location ");

		return buf.toString();
	}


	@Override
	public String getTitle() {
		return "Location Report";
	}

	
}
