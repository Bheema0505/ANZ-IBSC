<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <head>
        <title>User Login Form</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../css/message.css">
         <style>
               body {
            background-image: radial-gradient(circle, #b5e5f7, #b6bbec);
            background-repeat: repeat;
            background-size: contain;
        }

        .logo-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100px;
        }

        .logo-container img {
            height: 80px;
            width: auto;
        }

       </style>
    </head>
    <body>
        <section class="wrapper">
         <div class="logo-container">
                    <img src="../images/ibsc-logo-anz.png" alt="logo-image" class="img-fluid" />
         </div>
         <%@include file="message.jsp" %>
            <div class="container">
                <div class="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 ">
               

                <form class="rounded bg-white shadow p-5" action="../do" method="post">
                <input type=hidden name="actionStr" value="userLogin">
                    <h3 class="text-dark fw-bolder fs-4 mb-4 text-center "> Sign in as User</h3>
                    
                    <div class="form-floating mb-3">
                        <input type="text" autofocus="on" class="form-control" id="emp-id" name="emp-id" placeholder="Employee ID" >
                        <label for="emp-id">Employee ID <span style="color: red;">*</span></label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="emp-password" name="emp-password" placeholder="Password ">
                        <label for="emp-password">Password <span style="color: red;">*</span></label>
                    </div>

                    <div class="md-2 mt-2 text-end">
                        <a href="forgotpassword.jsp" class="text-primary fw-bold text-decoration-none"> Forgot Password ?</a>
                    </div>
                    <button type="submit" class="btn btn-primary submit_btn w-100 my-4">Log in</button>
                    <div class="fw-normal text-muted mb-4">
						Don't have an account ? <a href="mailto:ANZ_ibsc_pmo@infosys.com"
						
							class="text-primary fw-bold text-decoration-none"> Contact Admin </a>
							

					</div>
                </form>
                </div>
            </div>
</section>
       
      
    </body>
</html>