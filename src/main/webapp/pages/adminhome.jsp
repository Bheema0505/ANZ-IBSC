<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>

<head>
<%@include file="admincommon.jsp"%>
<%
// here all page specific variables
String title = "WELCOME to IBSC";
String adminName = (String) session.getAttribute("admin.name");
%>
<style type="text/css">
.actions-text {
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	
}
.actions-text span {
	font-weight: 500;
	font-size: 1.4rem;
}
</style>

</head>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">
		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>

		<div class="actions-text">
			<span>You've logged in as an Admin. 
			<br>Explore the sidebar to
				perform relevant actions</span>

		</div>

    </section>
  


  <script src="../js/home.js"></script>

</body>
</html>