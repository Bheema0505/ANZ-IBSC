<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.OffboardReportVO"%>
<%@ page import="com.infy.ibsc.vos.ReportVO"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style type="text/css">
.date-filter {
	display: flex;
	gap: 1rem;
	justify-content: center;
	margin: 2rem 4.5rem 1rem;
}

.date-filter input {
	width: 9rem;
	background: lavender;
}

.date-filter span {
	color: cadetblue;
	font-weight: 500;
	font-size: 1.2rem;
}
</style>

</head>

<%
// here all page specific variables
String title = "Off-Board Report";

ArrayList list = (ArrayList) session.getAttribute("OffReportList");
String adminName = (String) session.getAttribute("admin.name");
ReportVO report = (ReportVO) session.getAttribute("ReportVO");
%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>
		
		<div class="date-filter">
			<input type=hidden name="actionStr" value="offboardreport">
			<span>Reporting period:</span>
			<input type="date" placeholder="dd-mm-yyyy"
				class="form-control form-control-sm" id="first-name-user-reg"
				name="report-start-date" value="<%=report.getReportStartDate()%>>">
			To <input type="date" placeholder="dd-mm-yyyy"
				class="form-control form-control-sm" id="last-name-user-reg"
				name="report-end-date" value="<%=report.getReportEndDate()%>>">
		</div>



		<div class="table-container">


			<table class="emp-table">
				<thead>
					<tr>
						<th>Employee</th>
						<th>Salary ID</th>
						<th>Current Squad</th>
						<th>Remarks</th>
						<th>Effective date of Release from ANZ</th>
						<th>Location</th>
						<th>Replacement</th>

					</tr>
				</thead>
				<tbody>


					<%
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							OffboardReportVO repVo = (OffboardReportVO) list.get(i);
							String name = repVo.getFirstName() + " " + repVo.getLastName();
							String AnzSquad = StrUtil.nullToBlank(repVo.getAnzSquad());
							String Location = StrUtil.nullToBlank(repVo.getLocation());
							String Remarks = StrUtil.nullToBlank(repVo.getRemarks());
							String Salaryid = StrUtil.nullToBlank(repVo.getSalaryid());
							String Replacement = StrUtil.nullToBlank(repVo.getReplacement());
							String Offboarding_date = StrUtil.nullToBlank(repVo.getOffboarding_date());
					%>
					<tr>
						<td><%=repVo.getName()%></td>
						<td><%=Salaryid%></td>
						<td><%=AnzSquad%></td>
						<td><%=Remarks%></td>
						<td><%=Offboarding_date%></td>
						<td><%=Location%></td>
						<td><%=Replacement%></td>

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

