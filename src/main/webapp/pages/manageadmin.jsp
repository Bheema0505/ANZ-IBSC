<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
<%@ page import="com.infy.ibsc.vos.AdminVO" %>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<!DOCTYPE html>
<html>
  <head>
  <%@include file="admincommon.jsp" %>
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

.ad-btn {
    min-width: 300px
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

@media (max-width: 768px) {
    .search-cont {
        justify-content: center;
    }

}

  </style>
  </head>
      
<%
// here all page specific variables
String title = "Manage Admin";
ArrayList list = (ArrayList)session.getAttribute("AdminList");
String adminName =  (String)session.getAttribute("admin.name");
%>


<body>
  <%@include file="adminleftbar.jsp" %>

  <section class="right-space">
  
    <div class="right-content">
      <i class='bx bx-menu'></i>
      <span class="welcome-text"><%=title %></span> 
                  <span class="user-name"><%=adminName %></span>
    </div>
 <div class="search-cont">
            <div class="addnewuser-btn">
            <a href="addnewadmin.jsp" class="link">
                <button class="btn btn-success"> Add New Admin</button>
                </a>
            </div>
            <%@include file="message.jsp" %>
           
	   <form action="../do" method="post">
	   
	    
            <div class="sub-cont">
<input type=hidden name="actionStr" value="searchadmin">
                <div class="inp-select">
                    <!-- <span>1. Search using :</span> -->
                    <select name="search-id" id="search-id">
                    	<option value="0" disabled selected hidden="true">Search Using</option>
                        <option value="emp-id">Employee Id</option>
                        <option value="first-name">First Name</option>
                        <option value="last-name">Last Name</option>
						<option value="email">Email id</option>
                    </select>
                </div>
                <div class="inp-1">
                    <input type="text" placeholder="Search..." value="" class="input" name="searchValue">
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
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Action</th>

                </tr>
            </thead>
            <tbody>
<%
    
        for(int i=0;i<list.size();i++){
        AdminVO Vo = (AdminVO)list.get(i);
        String name = Vo.getFirstName()+ " "+ Vo.getLastName();
        %>
					<tr>
						<td><%=Vo.getEmpId() %></td>
						<td><%=Vo.getFirstName() %></td>
						<td><%=Vo.getLastName() %></td>
						<td><%=Vo.getEmail() %></td>
						


						<td><a
							href="removeadmin.jsp?empId=<%=Vo.getEmpId()%>&empName=<%=name %>"
							class="link">
								<button class="btn btn-danger save-btn" id="save-btn"
									type="remove" form="my-profile-form">
									Remove</button>
						</a></td>



					</tr>
					<%
          }
        
					}
    else{
    // do nothing    
        
    }
   %>



            </tbody>

        </table>

    </div>
   
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