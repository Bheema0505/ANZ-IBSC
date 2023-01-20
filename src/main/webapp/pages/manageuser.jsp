<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style>
.search-cont {
	margin-top: 40px;
	display: flex;
	/* background-color: antiquewhite; */
	justify-content: space-between;
	align-items: center;
	width: 95%;
	flex-wrap: wrap;
	flex-direction: row;
}

.addnewuser-btn {
	margin-left: 30px;
	margin-right: 20px;
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
	transition: all 0.5s ease;
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
	transition: all 0.5s ease;
	background-color: royalblue;
	border-radius: 4px;
}

.inp-1 .searchbtn i {
	color: white;
	font-size: 20px;
}

.inp-1.active-search .input {
	width: 250px;
	border-radius: 18px 0 0 18px;
	background-color: white;
}

.inp-1.active-search .searchbtn {
	transform: translateX(248px);
	border-radius: 0 18px 18px 0;
}

.sub-cont {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: space-evenly;
	text-align: center;
}
.err{
    color: red;
  }
            

@media ( max-width : 768px) {
	.search-cont {
		justify-content: center;
	}
}
</style>
</head>

<%
// here all page specific variables
String title = "Manage User";
ArrayList list = (ArrayList) session.getAttribute("userlist");
String adminName =  (String)session.getAttribute("admin.name");
%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">


		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>
		
		<%@include file="message.jsp"%>	
		
		<div class="search-cont">
			<div class="addnewuser-btn">
				<a href="adduser.jsp" class="link">
					<button class="btn btn-success save-btn" id="save-btn" type="button"
						form="my-profile-form">
						Add New User</button>
				</a>
			</div>
			
		


			<form action="../do" method="post" onSubmit="formHandler()">
				<div class="sub-cont">

					<input type=hidden name="actionStr" value="searchuser">
					<div class="inp-select">
						<!-- <span>1. Search using :</span> -->
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
					<div class="inp-1 ">
						<input type="text" placeholder="Search..." value="" class="input"
							name="searchValue">
						<button class="searchbtn" type=submit>
							<i class='bx bx-search'></i>
						</button>
					</div>

				</div>
			</form>
		</div>


		



					<%
					if (list != null && list.size() > 0) {
					%>
						<div class="table-container">
			<table class="emp-table">
				<thead>
					<tr>
						<th>Emp ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Mail ID</th>
						<th>OB Status</th>
						<th>Squad Name</th>
						<th>Location</th>
						<th>Action</th>


					</tr>
				</thead>
				<tbody>
						
					<% 
						for (int i = 0; i < list.size(); i++) {
							UserVO Vo = (UserVO) list.get(i);
							String name = Vo.getName();
							String firstName= StrUtil.nullToBlank(Vo.getFirstName());
							String lastName = StrUtil.nullToBlank(Vo.getLastName());
							String email    = StrUtil.nullToBlank(Vo.getEmail());
							String squad    = StrUtil.nullToBlank(Vo.getAnzSquad());
							String location = StrUtil.nullToBlank(Vo.getLocation());
							
							String actionURL =  "offboard.jsp?empId="+Vo.getEmpId()+"&empName="+name;
							String button = "Offboard";
							String buttonStyle = "btn-danger";
							
							if("Completed".equals(Vo.getOb_Status()) || "Started".equals(Vo.getOb_Status())) {
								actionURL =  "offboard.jsp?empId="+Vo.getEmpId()+"&empName="+name;
								button = "Offboard";
								buttonStyle = "btn-warning";
							}
							else{
								 actionURL =  "removeuser.jsp?empId="+Vo.getEmpId()+"&empName="+name; 
								 button = "Remove";
								 buttonStyle = "btn-danger";
							}
							
					%>
					<tr>
						<td><a
							href="../do?actionStr=userInformation&empId=<%=Vo.getEmpId()%>"><%=Vo.getEmpId()%></a></td>
						<td><%=firstName%></td>
						<td><%=lastName%></td>
						<td><%=email%></td>
						<%					
						if("Started".equals(Vo.getOb_Status())){
							%>
							<td><a
							href="../do?actionStr=updateOnboarding&empId=<%=Vo.getEmpId()%>">
							<%=Vo.getOb_Status()%></a></td>
							<%
						}else{ %>
						<td><%=Vo.getOb_Status()%></td>
						<% } // end of inner else
						%>
						<td><%=squad%></td>
						<td><%=location%></td>
						
						<%					
						if("Offboarded".equals(Vo.getOb_Status())){
							%>
							<td>NA</td></tr>
							
							<%
							
						}else{ %>
						
						<td><a href="<%=actionURL%>" class="link"> 
                            <button class="btn <%=buttonStyle%> save-btn" id="save-btn"
									type="button" form="my-profile-form">
										<%=button %></button></a></td>
						</tr>
            	
						<% } // end of inner else
						
							} // end of for
						%>
						</tbody>
			          </table>
						</div>
						<% 
						
						} //end of if%>
				
		
	</section>
	<script src="../js/home.js"></script>
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