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

        .container input {
            background-color: rgb(243, 243, 243);
        }

        .add-usr-cont {
            width: 95%;
            height: 80vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .add-usr-cont form {
            width: 400px !important;
            height: auto;
            height: 300px;
            width: 400px;
            display: flex;
            justify-content: center;
           	background-color: #E7F6F2 !important;
            flex-direction: column;
            
        }

        .add-usr-cont form .add-user-txt {
            padding-bottom: 20px;


        }

        .add-usr-submit-btn {
            align-self: center;
            margin: 20px 0;
        }

			.err{
            	color: red;
            }
           
            .pass-text{
            	display: flex;
            	 justify-content: center;
	            align-items: center;
	             width: 99%;
            }
            .temp-pass {
	            display: flex;
	            justify-content: center;
	            flex-direction: column;
	            align-items: center;
	            height:auto;
	            width: 90%;
	            background-color: #e3ffff;
	            font-size: 15px;
	            justify-self: center;
	            font-weight: 300;
	           
			}
			.temp-pass .img-txt{
			 	display: flex;
	            justify-content: center;
	            flex-direction: column;
	            align-items: center;
			}
			.temp-pass .img-txt span{
				font-size: 28px;
				color: royalBlue;
				font-weight: 600;
			}
			.temp-pass .gen-pass{
			 	display: flex;
	            justify-content: center;
	            align-items: center;
			}
			.temp-pass .gen-pass span{
				font-weight: 300;
				
			}
			.temp-pass .gen-pass span .temporary-password{
				font-weight: 200;
				color: orange;
				font-family: 'Montserrat', sans-serif;
				 font-size: 18px;
				
			}
			
			  
	        @media (min-width: 300px) and (max-width: 800px) {
	            .add-usr-cont form {
	                width: 400px !important;
	            }
	        }
	         .add-usr-cont .field input:focus{
                box-shadow: none;
            }
    </style>

  
  </head>
      


<body>

  <%@include file="adminleftbar.jsp" %>

  <section class="right-space">
 
  
  
    <div class="right-content">
      <i class='bx bx-menu'></i>
     
                  <span class="user-name"><%=session.getAttribute("admin.name") %></span>
    </div>
  
  	 <% 
   String errMsg = (String)session.getAttribute("ERR_MSG");
   if(errMsg != null){
	   %>
	   <div class="err"><%=errMsg %></div>
	<%  session.removeAttribute("ERR_MSG");  
   }
   
   String infoMsg = (String)session.getAttribute("INFO_MSG");
   if(infoMsg != null){
	   %>
	   <div class="pass-text">
	   <div class="temp-pass">
			   <div class="img-txt">
			         <img src="../images/success.png" alt="succes iamge" width="70px" height="70px">
			   		 <span>User was succesfully added</span>
			   </div>
	   			<div class="gen-pass">
	  		 		<span>Kindly use this Temporary Password to LogIn 
	  		 		<span class="temporary-password"> <%=infoMsg %> </span>
	  		 		</span>
	  		 	</div>
	    </div>
	    
	    </div>
	 <% 
	session.removeAttribute("INFO_MSG");
   }

%>
	
	 <div class="add-usr-cont" >
       <form class="rounded bg-white shadow p-5" action="../do"
					method="post">
					<input type=hidden name="actionStr" value="adduser">
	
	            <span class="add-user-txt">Enter the Employee ID of the New User</span>
	            <div class="form-floating mb-3 field">
	
	                <input type=" text" autofocus="on" class="form-control w-100" id="add-usr-emp-id" placeholder="emp-id"
	                     name="emp-id" required>
	                <label for="add-usr-emp-id">emp-id <span style="color:red;">*</span></label>
	
	            </div>
	            <button type="submit" class="btn btn-primary add-usr-submit-btn w-75 y-4">Add</button>
	
	
	        </form>
	    </div>
	 
   

    </section>
    <script src="../js/home.js"></script>
</body>

</html>