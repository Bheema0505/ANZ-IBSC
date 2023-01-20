<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- *************     boostrap    ************** -->

    <!--         CDN          -->

    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->

    <!--       OFFLINE        -->

    <link rel="stylesheet" href=" ../css/bootstrap.css">

    <!-- *************     css     ************** -->

    <style>
        body {
            background-image: radial-gradient(circle, #b5e5f7, #b6bbec);
            background-repeat: repeat;
            background-size: contain;

        }

        .container input {
            background-color: rgb(243, 243, 243);
            border-color: black;
            border-width: 2px;
            width: 100%;
            height: 50px;
        }

        .container .logo {
            width: 50%;
            margin-left: 20%;
        }

        .img-fluid {
            margin: 20px 0px;
        }

        .label-text {
            margin: 20px 0px;
        }

        .submit_btn {
            text-align: center;
            margin: 0px;
            width: 50%;
        }

        .btn-cont {
            display: flex;
            justify-content: center;
        }
        .err{
            	color: red;
            }


        .container input:focus {
            box-shadow: none;
        }
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
                    <input type=hidden name="actionStr" value="validateEmpID" > 
                    <h3 class="text-dark fw-bolder fs-4 mb-4 text-center "> Forgot Password</h3>

                    <div class=" mb-3">
                        <label for="emp-id" class="label-text"> Enter your Employee ID <span
                                style="color: red;">*</span></label>
                        <input type="text" autofocus="on" class="" id="emp-id" name="emp-id" placeholder="Enter here..." required>

                    </div>

                    <div class="btn-cont">
                        <button type="submit" class="btn btn-primary submit_btn w-90 my-4"
                            id="forg-pass-btn">Submit</button>
                    </div>

                </form>
            </div>
        </div>

       

</body>

</html>