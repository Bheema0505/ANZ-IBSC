<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
<%@ page import="com.infy.ibsc.vos.DocumentVO" %>

<!DOCTYPE html>
<html>
  <head>
  <%@include file="common.jsp" %>

 <style>
        body {
            background-image: none !important;
            background-color: white;
            height: 100vh !important;
        }

		 .rem-usr-cont {
            width: 95%;
            height: 80vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
           
        }
         .rem-usr-cont form {
         background-color: #E7F6F2 !important;
         }
           .rem-usr-cont form span{
           		   font-size: 20px;
           		   padding: 25px 0px;
           		   color: salmon;
           		   font-weight: 500;
           }
           .rem-usr-cont .user-inf{
           		text-align: center;
           		margin: 30px 0px;
           }
           .rem-usr-cont .user-inf label{
					width: 80px;
                    display: inline-block;
                    margin: 10px;
                    font-size: 15px;
		}
		.rem-usr-cont .user-inf input{
					width: 140px;
                    display: inline-block;
                    margin: 5px;
                    padding: 0px 10px;
                    font-size: 18px;
                    font-weight:600;
                    border:none;
                    background-color: #E7F6F2;
                    color: royalBlue;  	
		}
		.rem-usr-cont .user-inf input:focus{
					border:none;
					outline:none;
		}
		.rem-usr-submit-btn{
			margin: 20px 10px 10px 0px;
		}
		       .remove-user-warn-txt {
                    /* background-color: rgb(200, 209, 236); */
                    height: 35px;
                    width: 90%;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                     margin-left: 40px;
                    margin-top: 40px;
                    margin-bottom: 10px
                    border-radius: 8px;
                    flex-wrap: wrap;
          
                }

                .remove-user-warn-txt p {
                    color: rgb(63, 34, 34);
                    word-spacing: 5px;
                    letter-spacing: 0.6px;
                    padding: 5px;
                }

                .remove-user-warn-txt p span {
                    line-height: -15px;
                    font-size: 15px;
                    vertical-align: middle;
                    /* always change the icon vertical alignment */

                }

                .remove-user-warn-txt i {
                    color: rgb(221, 221, 94);
                    font-size: 25px;
                    vertical-align: middle;

                }

                .remove-user-warn-txt p span span{
                    color: black;
                    background-color:yellow;
                    border-radius: 15px;
                    padding: 0 10px;
                }

               
			.err{
            	color: red;
            }
           
           
	        @media (min-width: 300px) and (max-width: 800px) {
	            .rem-usr-cont form {
	                width: 400px !important;
	            }
	            .rem-usr-cont .user-inf input{
	            width: 150px;
	            }
	        }
	        
    </style>

  
  </head>
      
<%
String empId = (String) request.getParameter("empId");
String empName = (String) request.getParameter("empName");

%>

<body>

  <%@include file="adminleftbar.jsp" %>

  <section class="right-space">
 
  
  
    <div class="right-content">
      <i class='bx bx-menu'></i>
      <span class="user-name"><%=session.getAttribute("user.name") %></span>
    </div>
  
  			<div class="remove-user-warn-txt">

                <p><i class="fa-solid fa-triangle-exclamation"></i> <span>By clicking on  
                <span> Remove</span>, Below user won't be able to perform any further actions in IBSC application </span></p>
            </div>
	
	 <div class="rem-usr-cont" >
	 	<form class="rounded bg-white shadow p-5" action="../do" method=post>
	 	 <input type=hidden name="actionStr" value="removeuser">
	 	  <input type=hidden name="delEmpId" value="<%=empId %>">
	            <span class="add-user-txt">Are you sure, you want to remove this user?</span>
	           
	 				 <div class="user-inf">
                         			<label for="user-empid">Emp ID :</label>
                                    <input type="text" id="user-empid"
                                        name="first-name" value="<%=empId %>" readonly>
                                    <br>
                                    <label for="user-name">Name :</label>
                                    <input type="text" id="user-name"
                                        name="last-name" value="<%=empName %>" readonly>
                                    <br>
					</div>
	            <button type="submit" class="btn btn-warning rem-usr-submit-btn w-50 y-4">Remove</button>
			</form>
	    </div>
	 
   

    </section>
    <script src="../js/home.js"></script>
</body>

</html>