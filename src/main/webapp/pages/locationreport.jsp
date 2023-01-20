<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.LocationReportVO"%>
<%@ page import="com.infy.ibsc.vos.ReportVO"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<%@ page import="com.infy.ibsc.util.DateUtil"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">
<style>
.reporting-cont {
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 1.5rem;
	font-weight: 500;
    margin: 1.5rem 4.5rem 0 3rem;
    border: 1px solid #ddd;
}

.reporting-cont .report-text {
	padding: 0;
	margin: 0;
	color: royalblue;
}
.reporting-cont .report-text span{
	color: #ffc107;
}
</style>
</head>

<%
// here all page specific variables
String title = "Location Report";
String reportPeriod = DateUtil.getReportDate(new java.util.Date());



ArrayList list = (ArrayList) session.getAttribute("ReportList");
String adminName = (String) session.getAttribute("admin.name");

%>
<!-- "Reporting Period : " + -->


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>



		<div class="reporting-cont">
			<p class='report-text'>
				<span>Reporting Time: </span>
				 
				 <small><%=reportPeriod%></small> 
			
			</p>
		</div>



		<div class="table-container">




			<table class="emp-table">
				<thead>
					<tr>
						<th>Location</th>
						<th>Count of Employees</th>


					</tr>
				</thead>
				<tbody>


					<%
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							LocationReportVO repVo = (LocationReportVO) list.get(i);
							ReportVO Vo = (ReportVO) list.get(i);
					%>
					<tr>
						<td><%=repVo.getLocation()%></td>
						<td><%=repVo.getCount()%></td>



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

