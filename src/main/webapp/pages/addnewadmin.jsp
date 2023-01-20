
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style>
.sub-cont {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: flex-end;
	text-align: center;
	margin:10px 40px 5px 10px;
	width: 92%;
}
.inp-select {
	background-color: azure;
	align-self: flex-end;
	margin-right: 20px;
}

.inp-select span {
	display: block;
}

.inp-select select {
	width: 200px;
	justify-self: center;
	height: 35px;
	font-size: 17px;
	background-color: #6984d6;
	color: white;
	cursor: pointer;
}

.inp-select select option {
	text-align: left;
	background-color: #fff;
	color: royalBlue;
	cursor: pointer;
}

.inp-select select option:hover {
	background-color: #lightBlue !important;
}

.inp-1 {
	position: relative;
}

.inp-1 .input {
	border: 2px solid royalblue;
	/* background-color: whitesmoke; */
	font-size: 18px;
	padding: 6px;
	height: 35px;
	width: 38px;
	transition: width 0.3s ease;
	border-radius: 15px 0 0 15px;
}

::placeholder {
	color: royalblue;
}

.inp-1 .searchbtn {
    border: 1px solid royalblue;
    cursor: pointer;
    font-size: 24px;
    position: absolute;
    top: 0;
    left: 0;
    width: 52px;
    height: 35px;
    transition: transform 0.3s ease;
    background-color: royalblue;
    border-radius: 4px;

}

.inp-1 .searchbtn i {
    color: white;
    font-size: 20px;

}


.inp-1.active-search .input {
    width: 250px;
    border-radius: 13px 0 0 13px;
    background-color: white;

}

.inp-1.active-search .searchbtn {
    transform: translateX(228px);
    border-radius: 0 13px 13px 0;
}



@media ( max-width : 768px) {
	.search-cont {
		justify-content: center;
	}
	.err {
		color: red;
	}
}
</style>
</head>

<%
// here all page specific variables
String title = "Add New Admin";
ArrayList list = (ArrayList) session.getAttribute("userlist");
%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=session.getAttribute("admin.name")%></span>
		</div>
		

<%@include file="message.jsp"%>

			<form action="../do?" method=post>
			<div class="sub-cont">

				<input type=hidden name="actionStr" id="actionStr"
					value="searchuser"> <input type=hidden name="startPage"
					id="startPage" value="addNewAdmin">
				<div class="inp-select">
					<!-- <span>1. Search using :</span> -->
					<select name="search-id" id="search-id">
						<option value="">Search Using</option>

						<option value="emp-id">Emp id</option>
						<option value="first-name">First Name</option>
						<option value="last-name">Last Name</option>


					</select>
				</div>
				<div class="inp-1 ">
                    <input type="text" placeholder="Search..." value="" class="input" name="searchValue">
                    <button class="searchbtn" type=submit>
                        <i class='bx bx-search'></i>
                    </button>
                </div>
				<input type=hidden name="emp-id" id="empid">
			</div>
		
			<div class="table-container">
				<%
				if (list != null && list.size() > 0) {
				%>
				<table class="emp-table">
					<thead>
						<tr>
							<th>Emp ID</th>
							<th>Name</th>
							<th>Mail ID</th>

							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < list.size(); i++) {
							UserVO uservo = (UserVO) list.get(i);
							String name = uservo.getFirstName() + " " + uservo.getLastName();
						%>
						<tr>
							<td><%=uservo.getEmpId()%></td>
							<td><%=name%></td>
							<td><%=uservo.getEmail()%></td>


							<td><button type="button" class="btn btn-success"
									onclick="addAdmin('<%=uservo.getEmpId()%>');">Add</button></td>
						</tr>

						<%
						}
						%>
					</tbody>

				</table>
				<%
				}
				%>
			</div>
		</form>

	</section>
	<script src="../js/home.js"></script>
	<script type="text/javascript">
      function addAdmin(empid){
      	document.getElementById('empid').value=empid;
      	

      	document.getElementById('actionStr').value='addNewAdmin';
      	document.forms[0].submit();
      }</script>
	<script>
	  let searchCont = document.querySelector(".inp-1");
      let searchInput = document.querySelector(".input");
      let searchBtn = document.querySelector(".searchbtn");

      searchBtn.addEventListener("click", () => {
      	if(searchCont.classList.contains("active-search")){
      		
      		searchInput.focus();
      	}else{
      		 event.preventDefault()
      		 searchCont.classList.add("active-search");
      	} 
      });
      
        
    </script>
</body>

</html>		