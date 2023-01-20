<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%> 
<!DOCTYPE html>
<html>
<head>
<title>User Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- *************     boostrap    ************** -->

<!--         CDN          -->

<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->

<!--     OFFLINE     -->

<link rel="stylesheet" href="../css/bootstrap.css">
 <link rel="stylesheet" href="../css/message.css">

<!-- *************     css     ************** -->

<style>
body {
	background-image: linear-gradient(to bottom, #6ecef1, #dcedfc);
	background-repeat: repeat;
	background-size: contain;
}

input {
	margin-top: 5px;
}

.name-hint, .pass-hint {
	font-size: smaller;
	margin-left: 5px;
	margin-top: 2px;
}

.container-fluid input {
	background-color: rgb(243, 243, 243);
}

.container-fluid .logo {
	width: 50%;
	margin-left: 20%;
}
.err{
            	color: red;
            }

		.wrapper {
			padding-bottom: 50px;
			background-image: linear-gradient(to bottom, #6ecef1, #dcedfc);
			background-repeat: repeat;
			background-size: contain;
		}
		
		.dropdown {
			width: 100%;
			margin: 0px;
		}

		select {
			width: 100%;
			margin-top: 0px;
			/* margin-bottom: 15px; */
			height: 40px;
			font-size: 16px;
			background-color: rgb(243, 243, 243);
			border-radius: 5px;
			border: 1px solid #ced4da;
			
		}
		
		select option {
			background-color: #fff;
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

        .error-container {
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: large;
            color: orangered;
            font-weight: 600;
        }

        .error-container .error-msg {
            background-color: rgb(245, 198, 198);
            min-width: 40%;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
            border-radius: 4px;
            
        }

        .error-container .error-msg p{
            padding: 0;
            margin: 0;
        }
</style>


</head>
<body>
	<section class="wrapper">
		 <div class="logo-container">
                    <img src="../images/ibsc-logo-anz.png" alt="logo-image" class="img-fluid" />
         </div>
		 <div class="error-container">
         	<div class="error-msg">				
						 <%   String errMsg = (String)session.getAttribute("ERR_MSG");
						   if(errMsg != null){
							   %>
							   <p><%=errMsg %></p>
							<%  session.removeAttribute("ERR_MSG");  
						   }
						   String firstName = "";String lastName = "";
						   String emp_id = ""; String email_id="";
						   
						   
						   UserVO regUserVO = (UserVO)session.getAttribute("Register.UserVO");
						   
						   if(regUserVO != null ){
							   
							   if(regUserVO.getFirstName() != null)
							       firstName = regUserVO.getFirstName();
							   if(regUserVO.getLastName() != null)
							       lastName = regUserVO.getLastName();
							   if(regUserVO.getEmpId() > 0 )
								   emp_id += regUserVO.getEmpId();
							   if(regUserVO.getEmail() != null)
							       email_id = regUserVO.getEmail();
							   
						   }
						   else{
							   
							   emp_id += (String)session.getAttribute("user.empid");
						   } %>
		</div>	
		</div>
		<div class="container-fluid">
			<div
				class="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 ">

				<form class="rounded bg-white shadow p-5" action="../do"
					method="post">
					<input type=hidden name="actionStr" value="userRegister">
					<h3 class="text-dark fw-bolder fs-4 mb-4 text-center ">Create
						an account</h3>

					<div class="form-floating mb-3">
						<input type="text" autofocus="on" class="form-control"
							id="first-name-user-reg" name="first-name"
							placeholder="First name" value="<%=firstName %>"> <label
							for="first-name-user-reg">First name <span style="color: red;">*</span></label> <span
							class="name-hint text-muted fs-10">Enter your first and
							last names as per infy records</span>
					</div>
					<div class="form-floating mb-3">
						<input type="text" autofocus="on" class="form-control" 
							id="last-name-user-reg" name="last-name" placeholder="Last name" value="<%=lastName %>">
						<label for="last-name-user-reg">Last name <span style="color: red;">*</span></label>

					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control form-control-sm"
							id="emp-id-user-reg" name="emp-id" placeholder="Emp ID" value="<%=emp_id %>" disabled>
						<label for="emp-id-user-reg">Employee ID <span style="color: red;">*</span></label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" autofocus="on" class="form-control form-control-sm"
							id="emp-infy-mailid-user-reg" name="email-id"
							placeholder="Email ID" value="<%=email_id %>">
							<label
							for="emp-infy-mailid-user-reg">Infosys mail ID <span style="color: red;">*</span></label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="emp-pass-user-reg"
							name="password" placeholder="Password"> <label
							for="emp-pass-user-reg">Password <span style="color: red;">*</span></label> <span
							class="pass-hint text-muted fs-10">Choose a strong
							password</span>
					</div>

					<div class="form-floating mb-3">
						<input type="password" class="form-control"
							id="emp-pass-conf-user-reg" name="confirm-password"
							placeholder="ConfirmPassword"> <label
							for="emp-pass-conf-user-reg">Confirm Password <span style="color: red;">*</span></label>
					</div>
					<div class="dropdown">
						<label for="sec-que-user-reg" class="pass-hint text-muted fs-10">Answer
							a Security Question <span style="color: red;">*</span></label> <br> <select name="sec-que"
							id="sec-que-user-reg" class="mb-3">
							<option value="" disabled selected hidden>Choose one
								...</option>
							<option value="name">1. What is your pet name ?</option>
							<option value="colour" focus="on">2. What is your
								favourite colour ?</option>
							<option value="teacher">3. Who is your favourite teacher
								?</option>
							<option value="place">4. What is your favourite place ?</option>
							<option value="hero">5. Who is your childhood Super
								Hero ?</option>
						</select>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="sec-que-ans-user-reg"
							placeholder="enter your answer here" name="sec-answer"> <label
							for="sec-que-ans-user-reg">answer...</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control form-control-sm"
							id="location-user-reg" name="location" placeholder="Location">
						<label for="location-user-reg">Location<span style="color: red;">*</span></label>
					</div>
					<div class="form-check fw-bolder">
						<input class="form-check-input " type="checkbox" id="T&C" required>
						<label class="form-check-label" for="T&C"> agreed to Terms
							and conditions</label>
					</div>

					<button type="submit" class="btn btn-primary submit_btn w-100 my-4">Register</button>

					<div class="fw-normal text-muted mb-4">
						Already have an account ?<a href="userlogin.jsp"
						
							class="text-primary fw-bold text-decoration-none"> Login</a>
							

					</div>
				</form>
			</div>
		</div>

	</section>
                            
	<script>  

</script>  

</body>

</html>