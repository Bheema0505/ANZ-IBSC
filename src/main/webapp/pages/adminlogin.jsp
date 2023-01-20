<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login Form</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
         <style>
            body {
                    background-color: rgb(220, 237, 252);
            }
            .container input{
                background-color: rgb(243, 243, 243);
            }
            .container .logo{
                width: 50%;
                margin-left: 20%;
            }
            .img-fluid{
                margin: 20px 0px;
            }
            .err{
            	color: red;
            }
             .info{
            	color: blue;
            }
            /* .container input:focus{
                box-shadow: none;
            } */
         </style>

    </head>
    <body>
        <section class="wrapper">
            <div class="container">
                <div class="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 ">
                <div class="logo">
                    <img src="../images/ibsc-logo-anz.png" alt="logo-image" class="img-fluid" />
                </div>
   <% 
   String errMsg = (String)session.getAttribute("ERR_MSG");
   if(errMsg != null){
	   %>
	   <div class="err"><%=errMsg %></div>
	   <% 
	 session.removeAttribute("ERR_MSG"); 
	   } 
   String infoMsg=(String)session.getAttribute("INFO_MSG"); 
      if(infoMsg !=null){ %>
                            <div class="info">
                                <%=infoMsg %>
                            </div>
                            <% session.removeAttribute("INFO_MSG"); } %>
                <form class="rounded bg-white shadow p-5" action="../do" method="post">
                <input type=hidden name="actionStr" value="adminlogin">
                    <h3 class="text-dark fw-bolder fs-4 mb-4 text-center "> Sign in as Admin</h3>
                    
                    <div class="form-floating mb-3">
                        <input type="text" autofocus="on" class="form-control" id="empId" name="empId" placeholder="Emp ID">
                        <label for="empId">Emp ID</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="empPassword" name="empPassword" placeholder="Password">
                        <label for="empPassword">Password</label>
                    </div>
                    <div class="md-2 mt-2 text-end">
                        <a href="forgotpassword.jsp" class="text-primary fw-bold text-decoration-none"> Forgot password ?</a>
                    </div>
                    <button type="submit" class="btn btn-primary submit_btn w-100 my-4">Log in</button>
                    
                </form>
                </div>
            </div>

       
        </script>
    </body>
</html>