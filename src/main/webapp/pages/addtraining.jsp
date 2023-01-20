<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>
<!DOCTYPE html>
<html>

<head>

<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/message.css">




<style>
body {
	background: none;
}

.training-details-cont {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	margin: 3rem;
	border-radius: 5px;
}

.training-details {
	border-radius: 10px;
	padding: 3rem 3rem 1.5rem;
	text-align: center;
	box-shadow: 3px 4px 20px 5px rgb(0 0 0/ 10%);
}

.training-details h5 {
	font-size: 1.4rem;
	margin-bottom: 2rem;
	color: royalblue;
	font-weight: 500;
	border-bottom: 1px dotted;
	padding-bottom: 1rem;
}

.training-form {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

.training-form label {
	display: inline-block;
	width: 7rem;
	text-align: left;
	margin: 1rem 0;
	font-weight: 500;
	font-size: 1.1rem;
	color: darkslateblue;
}

.training-form input {
	width: 13rem;
	padding: 3px;
}

.training-form button {
	width: 50%;
	margin: 2rem 0 0;
}

.training-form input:focus, .training-form input:active {
	border: 1px solid royalblue;
	outline: 1px solid royalblue;
}
</style>
</head>

<%
// here all page specific variables
String title = "Add Training";
String adminName = (String) session.getAttribute("admin.name");
%>

<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">
		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>


		<!-- #############     ADD TRAINING  markup     ############## -->

<%@include file="message.jsp"%> 
		<div class="training-details-cont">
			<div class="training-details">

				<h5>Training Information</h5>

				<div class="training-form">
					<form action="../do" method="post" id="add-training-form">
						<input type=hidden name="actionStr" value="addtraining"> <label
							for="tr-id-training-reg">Tr_ID :</label> <input type="text"
							id="tr-id-training-reg" name="tr_id"> <br> <label
							for=" name-training-reg">Name :</label> <input type="text"
							id="name-training-reg" name="name"> <br> <label
							for="type-training-reg"> Type :</label> <input type="text"
							id="type-training-reg" name="type"> <br> <label
							for="duration-training-reg">Duration :</label> <input type="text"
							name="duration" id="duration-training-reg"> <br> <label
							for="reference-training-reg">Reference :</label> <input
							type="text" name="reference" id="reference-training-reg">
						<br>
						<button class="btn btn-primary save-btn" id="save-btn"
							type="submit" form="add-training-form">Save</button>
					</form>



				</div>

			</div>

		</div>


		<!-- #############     my profile markup end   ############## -->

	</section>


	<script src="../js/home.js"></script>

</body>

</html>