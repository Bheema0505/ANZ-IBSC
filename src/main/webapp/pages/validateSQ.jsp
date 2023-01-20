<!DOCTYPE html>
<html>

<head>
    <title>Security Questions</title>
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
        body {
            background-image: radial-gradient(circle, #b5e5f7, #b6bbec);
            background-repeat: repeat;
            background-size: contain;

        }

        .container {
            padding: 0px;
            display: flex;
            justify-content: center;


        }

        .container .logo {
            width: 45%;
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

        .sec-que-cont {
            width: 600px;
            margin: 0px;
        }

        .container input:focus {
            box-shadow: none;
        }

        h5 {
            font-size: 15px;
            margin: 15px 0px;
        }

        .ans-field,
        select {
            width: 100%;
            height: 40px;
            margin-bottom: 10px;
            border-radius: 5px;
        }

        .btn {
            width: 60%;
        }
    </style>

</head>

<body>
    <section class="wrapper">
        <div class="container">
            <div class="col-sm-8 offset-sm-2 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4 sec-que-cont">
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
                    <input type=hidden name="actionStr" value="validateSQ" > 
                    <label for="security-Questions">
                        <h5>Select a Security Question which you have opted at the time of registration:</h5>
                    </label>
                    <br>
                    <select name="sec-que" id="security-Questions">
                        <option value="" disabled selected hidden>Choose one ....</option>
                        <option value="name">What is your pet name ?</option>
                        <option value="colour">What is your favourite colour ?</option>
                        <option value="teacher">Who is your favourite teacher ?</option>
                        <option value="place">What is your favourite place ?</option>
                        <option value="birthday">When is your birthday?</option>
                    </select>
                   
                        <div class="form-floating mb-3">
                              <!-- <label for="security-questions">Enter your an</label>-->
                           <input type="text" class="form-control" id="sec-ans" name="sec-ans"
							placeholder="enter your answer here"> <label
							for="sec-que">answer...</label>

                        </div>
                        <div class="btn-cont">
                           <!--   <button class=" btn btn-primary img-fluid" type="button" id="sec-que-btn">Submit</button> 
                           <input type=submit value ="Submit"/>-->
                            <button type="submit" class="btn btn-primary submit_btn w-100 my-4">Submit</button> 
                        </div>
                    </form>
            </div>
        </div>

       

</body>

</html>