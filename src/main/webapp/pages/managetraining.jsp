<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.TrainingVO"%>
<%@ page import="com.infy.ibsc.vos.UserTrainingVO"%>
<%@ page import="com.infy.ibsc.util.TrainingUtil"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style>
.add-new-training-btn-cont{
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 20px 0 10px;
}
</style>
</head>

<%
// here all page specific variables
String title = "Manage Trainings";
ArrayList list = (ArrayList) session.getAttribute("TrainingList");
String adminName = (String) session.getAttribute("admin.name");
%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>


		<form action="../do" method="post"></form>


		<div class="add-new-training-btn-cont">
			<a href="addtraining.jsp" class="link">
				<button class="btn btn-success save-btn" id="save-btn" type="button"
					form="my-profile-form">ADD NEW TRAININGS</button>
			</a>
		</div>

		<div class="table-container">
			<table class="emp-table">
				<thead>
					<tr>
						<th>Tr_ID</th>
						<th>Name</th>
						<th>Type</th>

						<th>Duration</th>
						<th>Reference</th>
					</tr>
				</thead>
				<tbody>




					<%
					if (list != null && list.size() > 0) {
						TrainingUtil trUtil = TrainingUtil.getInstance();
						for (int i = 0; i < list.size(); i++) {
							TrainingVO trVo = (TrainingVO) list.get(i);
					%>
					<tr>
						<td><a
							href="../do?actionStr=managetrainingdetails&trainingId=<%=trVo.getTr_id()%>"><%=trVo.getTr_id()%></a></td>
						<td><a
							href=" ../do?actionStr=managetrainingdetails&trainingId=<%=trVo.getTr_id()%>"><%=trVo.getName()%></a></td>
						<td><%=trVo.getType()%></td>

						<td><%=trVo.getDuration()%></td>
						<td><%=trVo.getReference()%></td>



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
	<script src="../js/home.js"></script>


</body>

</html>

