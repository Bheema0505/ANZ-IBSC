<!DOCTYPE html>
<html>
    <head>
        <title>ChangePassword</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- *************     boostrap    ************** -->

                        <!--         CDN          -->

        <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->
                       
                        <!--       OFFLINE        -->

         <link rel="stylesheet" href="../css/bootstrap.css">

         <!-- *************     css     ************** -->

         <style>
            body{
                background-image: radial-gradient(circle, #b5e5f7, #b6bbec);
                background-repeat: repeat;
                background-size: contain;
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
   }
   %>
               <form class="rounded bg-white shadow p-5" action="../do" method="post">
                <input type=hidden name="actionStr" value="changepassword">
                    <h3 class="text-dark fw-bolder fs-4 mb-4 text-center "> Change Password</h3>
                    
                    <div class="form-floating mb-3">
                        <input type="password" autofocus="on" class="form-control" id="new-change-password" name="new-change-password" placeholder="Password">
                        <label for="old password">New Password</label>
                        </div>
                        
                        <div class="form-floating mb-3">
                         <input type="password" class="form-control" id="cnfrm-change-password" name="cnfrm-change-password" placeholder="Confirm Password">
                       <label for="new password">Confirm Password</label>
                    </div>
                   
                   
                  
                    <button type="submit" class="btn btn-primary submit_btn w-100 my-4">Submit</button> 
                    <!-- <a href="userlogin.jsp" class="btn btn-primary submit_btn w-100 my-4"> Submit </a> -->
                        
                    <div class="form-floating mb-3">
                        <%-- --<input type="text" autofocus="on" class="form-control" id="email-id" placeholder="Email ID">-- --%>
                        <label></label>
                       
                    </div>

                    </div>
                </form>
                </div>
            </div>

       <script></script>

    </body>
</html>