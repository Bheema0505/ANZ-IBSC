<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.AdminVO"%>
<%@ page import="com.infy.ibsc.vos.TrainingVO"%>
<%@ page import="com.infy.ibsc.vos.UserTrainingVO"%>
<%@ page import="com.infy.ibsc.util.TrainingUtil"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>
<%
TrainingUtil trUtil = TrainingUtil.getInstance();
UserVO vo = (UserVO) session.getAttribute("Search.UserVO");
TrainingVO trainingvo = trUtil.getTraining((String) session.getAttribute("tr_id"));
ArrayList list = (ArrayList) session.getAttribute("userlist");
%>

<style>
body {
	background-image: none !important;
	background-color: white;
	height: 100vh !important;
}

form {
	display: flex;
	flex-direction: row;
	align-items: start;
	width: 100%;
	height: auto;
	justify-content: space-evenly;
	padding: 10px;
}

.training-inf {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-evenly;
	height: 80vh;
	background-color: white;
	border-radius: 10px;
	padding: 20px 0;
	width: 800px;
}

.training-details, .training-description {
	border: 2px solid #ddd;
	padding: 20px;
	width: 90%;
	text-align: center;
	border-radius: 5px;
	margin: 20px;
	
	box-shadow: 0 0.5rem 1rem rgb(0 0 0/ 15%) !important;
}

.training-details label {
	width: 200px;
	text-align: left;
	padding: 10px;
	font-size: 1.4rem;
	font-weight: 500;
	color: royalBlue;
}

.training-details input {
	border: none;
	
	font-size: 1.1rem;
	width: Auto;
}

.training-details input:focus, .training-details input:active {
	outline: none;
}

.training-description p i {
	font-size: 1.5rem;
	vertical-align: middle;
	margin-right: 10px;
	color: yellowgreen;
}

.searching-user {
	width: 30%;
	height: 80vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: start;
	padding: 20px;
	background-color: #ddd;
	border-radius: 5px;
}

.searching-user span {
	color: Black;
	font-weight: 600;
	font-size: 1.5rem;
	padding: 0.3rem;
}

.searching-user .table-container {
	min-height: 100px;
	overflow: auto;
	max-height: 420px;
}

.search-container {
	display: flex;
	flex-direction: row;
	justify-content: center;
}

.search-container .inp-select select {
	width: 80px;
	height: 40px;
	margin: 0 10px;
}

.search-container .inp-1 input {
	width: 80%;
	margin: 0;
	padding: 0 5px;
	height: 40px;
}

.search-container .inp-1 button {
	margin: 0;
	padding: 0;
	background-color: royalblue;
	outline: royalblue;
	border-color: royalblue;
	width: 40px;
	position: absolute;
	display: inline-block;
	height: 40px;
}

.search-container .inp-1 button i {
	color: white;
	font-size: 1.3rem;
}
.table-container{
	margin-top: 10px;
}
.table-container .emp-table thead tr th {
	color: royalBlue;
	font-weight: 600;
	font-size: 1.2rem;
	padding: 0.3rem;
}

.table-container .emp-table thead tr {
	margin: 10px;
}

.info {
	height: 40px;
	background-color: #e3ffff;
	border-radius: 10px;
	width: 70%;
	display: flex;
	justify-content: center;
	align-items: center;
    margin: auto auto;
    margin-bottom: 20px;
}

.info h6 {
	color: green;
}

.searching-user button{
	font-size: 1.3rem;
	font-weight: 500;
	margin-top: 20px;
}


</style>


</head>

<%
String tr_id = trainingvo.getTr_id();
String name = trainingvo.getName();
String type = trainingvo.getType();
String duration = trainingvo.getDuration();
String reference = trainingvo.getReference();
%>

<body>

	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">



		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="user-name"><%=session.getAttribute("admin.name")%></span>
		</div>

		<div class="resp-msg">
			<%
			String infoMsg = (String) session.getAttribute("INFO_MSG");
			if (infoMsg != null) {
			%>
			<div class="info">
				<h6>
					<%=infoMsg%>
				</h6>
			</div>
			<%
			session.removeAttribute("INFO_MSG");
			}
			%>
		</div>

		<div class="assign-training-cont">
			<form class="rounded bg-white shadow" action="../do" method=post>
				<input type=hidden id="actionStr" name="actionStr"
					value="searchuser"> <input type=hidden name="startPage"
					value="trainingdDetails">

				<section class="training-inf">
					<div class="training-details">

						<label for="training-id">Training ID :</label> <input type="text"
							id="training-id" name="tr_id" value="<%=tr_id%>" readonly>
						<br> <label for="training-name">Name :</label> <input
							type="text" id="training-name" name="name" value="<%=name%>"
							readonly> <br> <label for="training-type">Type
							:</label> <input type="text" id="training-type" name="type"
							value="<%=type%>" readonly> <br> <label
							for="user-name">Duration :</label> <input type="text"
							id="user-name" name="duration" value="<%=duration%>" readonly>
						<br> <label for="training-reference">Reference :</label> <input
							type="text" id="training-reference" name="reference"
							value="<%=reference%>" readonly> <br>
					</div>
					<div class="training-description">
						<p>
							<i class="fa-solid fa-circle-exclamation"></i>search user to
							assign the above training
					</div>
				</section>
				<section class="searching-user">
					<span>Search User</span>
					<div class="search-container">

						<div class="inp-select">
							<select name="search-id" id="search-id">
								<option value="0" disabled selected hidden="true">Search
									Using</option>
								<option value="emp-id">Emp Id</option>
								<option value="first-name">First Name</option>
								<option value="last-name">Last Name</option>
								<option value="email">EMail id</option>
								<option value="ob-status">OnBoarding Status</option>
								<option value="squad">Squad Name</option>
								<option value="location">Location</option>

							</select>
						</div>
						<div class="inp-1 active-search">
							<input type="text" placeholder="Search..." value="" class="input"
								name="searchValue">
							<button class="searchbtn" type=submit>
								<i class='bx bx-search'></i>
							</button>
						</div>
					</div>
					<%
					if (list != null && list.size() > 0) {
					%>

					<div class="table-container">
						<table class="emp-table">
							<thead>
								<tr>
									<th>Emp ID</th>
									<th>FirstName</th>
									<!--   <th>LastName</th>-->
									<!-- 	<th>Mail ID</th> -->
									<th>OB Status</th>
									<!--    <th>SquadName</th> -->
									<!-- 	<th>Location</th> -->



								</tr>
							</thead>
							<tbody>



								<%
								for (int i = 0; i < list.size(); i++) {
									UserVO Vo = (UserVO) list.get(i);
									String name1 = Vo.getName();
									String firstName = StrUtil.nullToBlank(Vo.getFirstName());
									String lastName = StrUtil.nullToBlank(Vo.getLastName());
									String email = StrUtil.nullToBlank(Vo.getEmail());
									String squad = StrUtil.nullToBlank(Vo.getAnzSquad());
									String location = StrUtil.nullToBlank(Vo.getLocation());
								%>
								<tr>
									<td><%=Vo.getEmpId()%></td>
									<td><%=firstName%></td>
									<!-- 	<td><%=lastName%></td>-->
									<!-- 	<td><%=email%></td>-->
									<td><%=Vo.getOb_Status()%></td>
									<!--  <td><%=squad%></td>-->
									<!-- <td><%=location%></td> -->

								</tr>
								<%
								} // end of for
								%>
							</tbody>
						</table>

					</div>
					Due date (yyyy-MM-dd): <input type="text" name="duedate" >
					
					<button type="button" onclick="assign()"
						class="btn btn-warning rem-usr-submit-btn w-50 y-4">Assign
					</button>
				
					<%
					} //end of if
					%>
					</section>

			</form>
		</div>



	</section>
	<script src="../js/home.js"></script>

	<script>
	function assign(){
   	 document.getElementById('actionStr').value='adminRegisterTraining';
   	 document.forms[0].submit();
    }
        let searchCont = document.querySelector(".inp-1");
        let searchInput = document.querySelector(".input");
        let mngUserBtn = document.querySelector(".searchbtn");

        mngUserBtn.addEventListener("click", () => {
            searchCont.classList.add("active-search");
            searchInput.focus();
        });
    </script>
</body>

</html>