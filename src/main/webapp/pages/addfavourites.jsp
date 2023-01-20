<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.FavouritesVO"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>

<style>
body {
	background-image: none !important;
	background-color: white;
	height: 100vh !important;
}

.container input {
	background-color: rgb(243, 243, 243);
}

.add-fav-cont {
	width: 95%;
	height: 80vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.add-fav-cont form {
	max-width: 500px !important;
	height: auto;
	text-align:center;
	min-width: 400px;
	display: flex;
	justify-content: center;
	background-color: #E7F6F2 !important;
	flex-direction: column;
}

.add-fav-cont form .add-fav-txt {
	padding-bottom: 50px;
	font-size: 1.3rem;
	font-weight: 600;
	color: royalBlue;
	
}
.add-fav-cont form label {
	width: 100px;
	padding: 10px;
	font-weight: 500;
	font-size: 1.2rem;
	text-align: left;
	
}
.add-fav-cont form input,
.add-fav-cont form select{
	width: 250px;
}
.add-fav-submit-btn {
	align-self: center;
	margin: 50px 0 20px 0;
}

.err {
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
			

.add-fav-cont .field input:focus {
	box-shadow: none;
}
</style>


</head>



<body>

	<%@include file="leftbar.jsp"%>

	<section class="right-space">



		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="user-name"><%=session.getAttribute("user.name") %></span>
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
					<img src="../images/success.png" alt="succes iamge" width="70px"
						height="70px"> <span>Favourites added successfully </span>
				</div>

			</div>

		</div>
		<% 
	session.removeAttribute("INFO_MSG");
   }

%>

		<div class="add-fav-cont">
			<form class="rounded bg-white shadow p-5" action="../do"
				method="post">
				<input type=hidden name="actionStr" value="addfavourite"> <span
					class="add-fav-txt">Enter below details to add favourites</span>

				<div >
				 <label for="add-fav-title">Title :</label>
                   <input type="text" autofocus id="add-fav-title" placeholder="title"
	                     name="title" required>
	                     <br>
	                     <label for="add-fav-link">Link : </label>
                   <input type="text" autofocus  id="add-fav-link" placeholder="link"
	                     name="link" required>
	                     <br>
	                     <label for="add-fav-type">Type : </label>
                   <select name="type" id="add-fav-type" >
				                        <option value="None" style="background-color:#d8d8d8;">Select type</option>
				                        <option value="Document">Document</option>
					                    <option value="Training">Training</option>
					                    <option value="Others">Others</option>
                                </select>
                                   

				</div>
				<button type="submit"
					class="btn btn-primary add-fav-submit-btn w-75 y-4">Add</button>


			</form>
		</div>



	</section>
	<script src="../js/home.js"></script>
</body>

</html>