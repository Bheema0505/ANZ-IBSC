<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.OnboardReportVO"%>
<%@ page import="com.infy.ibsc.vos.ReportVO"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<%@ page import="com.infy.ibsc.util.DateUtil"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">
<style type="text/css">

	.date-filter{
		display: flex;
		gap: 1rem;
		justify-content: center;
		margin: 2rem 4.5rem 1rem;
	}
	.date-filter input{
		width: 9rem;
		background: lavender;
	}
	.date-filter span{
	    color: cadetblue;
	    font-weight: 500;
	    font-size: 1.2rem;
	}
</style>

</head>

<%
// here all page specific variables
String title = "On-board Report";

ArrayList list = (ArrayList) session.getAttribute("OnReportList");
String adminName = (String) session.getAttribute("admin.name");
ReportVO report = (ReportVO) session.getAttribute("ReportVO");
String report_start_date = DateUtil.getDateMMDDyyyy(report.getReportStartDate());
String report_end_date = DateUtil.getDateMMDDyyyy(report.getReportEndDate());

%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>
		<div class="date-filter">
			<input type=hidden name="actionStr" value="onboardreport">
			
			<span>Reporting period:</span>
			<input type="date" placeholder="dd-mm-yyyy"
				class="form-control form-control-sm" id="first-name-user-reg"
				name="report-start-date" value="<%= report_start_date %>"> 
			To <input type="date" placeholder="dd-mm-yyyy"
				class="form-control form-control-sm" id="last-name-user-reg"
				name="report-end-date" value="<%=report_end_date %>"> 
		</div>
		<div class="table-container">


			<table class="emp-table">
				<thead>
					<tr>

							<th>Employee</th>
							<th>OB Status</th>
							<th>Emp ID</th>
							<th>LAN ID</th>
							<th>Squad Name</th>
							<th>Role</th>
							<th>Location</th>
							<th>Date of Onboarding</th>


						</tr>
					</thead>
					<tbody>


						<%
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							OnboardReportVO repVo = (OnboardReportVO) list.get(i);
							String name = repVo.getFirstName() + " " + repVo.getLastName();
							String Ob_Status = StrUtil.nullToBlank(repVo.getOb_Status());
							String AnzSquad = StrUtil.nullToBlank(repVo.getAnzSquad());
							String Location = StrUtil.nullToBlank(repVo.getLocation());
							String AnzLanId = StrUtil.nullToBlank(repVo.getAnzLanId());
							String Onboarding_date = StrUtil.nullToBlank(repVo.getOnboarding_date());
					%>
						<tr>
							<td><%=repVo.getName()%></td>
							<td><%=Ob_Status%></td>
							<td><%=repVo.getEmpId()%></td>
							<td><%=AnzLanId%></td>
							<td><%=AnzSquad%></td>
							<td><%=repVo.getRole()%></td>
							<td><%=Location%></td>
							<td><%=Onboarding_date%></td>

						</tr>
						<%
					}

					} else {
					// do nothing	

					}
					%>
				</tbody>
			</table>

		</div>
	</section>
</body>

</html>

