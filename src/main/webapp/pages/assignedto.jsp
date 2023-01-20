<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.OnboardingVO"%>
<%@ page import="com.infy.ibsc.vos.UserOnboardingVO"%>
<%@ page import="com.infy.ibsc.util.OnboardingUtil"%>



<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>
<link rel="stylesheet" href="../css/table.css">
</head>

<%
// here all page specific variables
String title = "ON-BOARDING";
ArrayList list = (ArrayList) session.getAttribute("UserOnboaringList");
%>




<body>
	<%@include file="leftbar.jsp"%>



	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=session.getAttribute("user.name")%></span>
		</div>
		<div class="table-container">
			<table class="emp-table">
				<thead>
					<tr>
						<th>S.NO</th>
						<th>Employee Name</th>
						<th>Applicalbe Roles</th>
						<th>Applicable Location</th>

					</tr>
				</thead>
				<tbody>




					<%
					if (list != null && list.size() > 0) {
						OnboardingUtil obUtil = OnboardingUtil.getInstance();

						for (int i = 0; i < list.size(); i++) {
							UserOnboardingVO uobVo = (UserOnboardingVO) list.get(i);
							OnboardingVO obVo = obUtil.getOnboarding(uobVo.getStep_Id());
					%>
					<tr>
						<td><%=obVo.getStep_Id()%></td>
						<td><%=obVo.getAssignee()%></td>
						<td><%=obVo.getApplicable_Roles()%></td>
						<td><%=obVo.getApplicable_Location()%></td>
					</tr>

					<%
					}

					} else {
					// do nothing	

					}
					%>
				
			</table>



		</div>
	</section>
</body>



</html>

