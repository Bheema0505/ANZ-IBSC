<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="com.infy.ibsc.vos.UserVO" %>
    <%@ page import="com.infy.ibsc.util.SessionChecker" %>
    <%@ page import="com.infy.ibsc.util.StrUtil" %>
 
    
<!DOCTYPE html>
<html>

<head>

    <%@include file="common.jsp" %>

<%
// here all page specific variables
String title = "My Profile";
String menu = "Profile";

UserVO user = (UserVO)session.getAttribute("UserVO");
String anzmailid = StrUtil.nullToBlank(user.getAnzMailId());
String anzlanid    = StrUtil.nullToBlank(user.getAnzLanId());
String squad    = StrUtil.nullToBlank(user.getAnzSquad());
String program = StrUtil.nullToBlank(user.getProgram());


%>


<style>
/*######################    MY Profile css starts   ######################*/
body {
	background-color: #fff !important;
	background-image: none !important;
}

.viewprofile-cont {
	margin: 1.5rem auto;
    width: 95%;
	box-shadow: 3px 4px 20px 5px rgb(0 0 0/ 10%);
	padding: 1rem 0 2rem;
	border-radius: 5px;
}

.container {
	height: 100%;
	margin: 0px;
	padding: 0px;
	width: auto;
	display: flex;
	flex-direction: column;
	/* background-color: rgb(255, 255, 255); */
	align-items: center;
}

/* profile section start */
.grid-image-profile {
	display: flex;
	justify-content: center;
	align-items: center;
	position: relative;
	margin-bottom: 50px;
}

.myprofile-icon label input {
	display: none;
	/* visibility: hidden; */
}

.grid-image-profile .myprofile-icon label i {
	position: absolute;
	margin-top: 20px;
	margin-right: 20px;
}

.grid-image-profile .myprofile-icon i:hover {
	font-size: 20px;
}

.grid-image-profile .myprofile-icon img:hover {
	height: 110px;
	width: 110px;
}

/* profile section end */

/* infy details start */
form {
	display: flex;
	flex-direction: row;
	justify-content: space-evenly;
	flex-wrap: wrap;
}

.infy-details {
	display: flex;
	flex-direction: column;
}

.infy-details .infy-text {
	margin-bottom: 40px;
	color: royalblue;
	align-self: center;
}

.infy-details .form label {
	width: 120px;
	display: inline-block;
	margin: 10px;
	font-size: 15px;
}

.infy-details .form {
	align-self: flex-start;
	text-align: start;
}

.infy-details .form input {
	margin: 10px;
	width: 220px;
	display: inline-block;
	border: none;
	border-bottom: solid 1px blue;
	background-color: rgb(236, 241, 241);
	border-radius: 0px;
}

.infy-details .form select {
	margin: 10px;
	width: 220px;
	display: inline-block;
	border: none;
	background-color: rgb(236, 241, 241);
	border-radius: 0px;
}

.infy-details .form select::-webkit-scrollbar {
	display: none;
}

/* infy details end */

/* anz details start */
.anz-details {
	display: flex;
	flex-direction: column;
}

.anz-details .anz-text {
	margin-bottom: 40px;
	color: royalblue;
	align-self: center;
}

.anz-details .form {
	align-self: flex-start;
	text-align: start;
}

.anz-details .form label {
	width: 100px;
	display: inline-block;
	margin: 10px;
	font-size: 15px;
}

.anz-details .form input {
	margin: 10px;
	width: 220px;
	display: inline-block;
	background-color: none;
	border: none;
	border-bottom: solid 1px blue;
	background-color: rgb(236, 241, 241);
	border-radius: 0px;
}

/* anz details end */

/* footer start */
.footer-1 {
	height: 50px;
	width: 90%;
	display: grid;
	grid-template-rows: 1fr;
	grid-template-columns: 1fr 1fr;
	column-gap: 100px;
	margin-top: 30px;
	padding-bottom: 1rem;
}

.edit-btn {
	grid-column: 1/2;
	align-self: center;
	justify-self: flex-end;
}

#edit-btn {
	width: 100px;
}

.save-btn {
	align-self: center;
	justify-self: flex-start;
}

#save-btn {
	width: 100px;
}

@media ( max-width : 995px) {
	form {
		display: flex;
		flex-direction: column;
		text-align: center;
	}
	.infy-details {
		margin-bottom: 50px;
		text-align: center;
	}
	.infy-details .form {
		align-self: center;
		text-align: center;
	}
	.anz-details .form {
		align-self: center;
		text-align: center;
	}
	.infy-details .form label {
		width: 120px;
		text-align: left;
		/* display: inline-block; */
	}
	.anz-details .form label {
		width: 100px;
		text-align: left;
		display: inline-block;
	}
}

.chng-pass-txt {
	margin: 0 auto;
    width: 95%;
	display: flex;
	justify-content: center;
	align-items: center;
	border: 2px solid #ddd;
	box-shadow: 0 0.5rem 1rem rgb(0 0 0/ 15%) !important;
	border-radius: 5px;
}

}
p {
	margin-top: 1rem;
	margin-bottom: 1rem;
}

.chng-pass-txt p {
	color: rgb(63, 34, 34);
	word-spacing: 5px;
	letter-spacing: 0.6px;
	padding: 0 !important;
	margin: 1rem !important;
}

.chng-pass-txt p span {
	line-height: -15px;
	font-size: 15px;
	vertical-align: middle;
	/* always change the icon vertical alignment */
}

.chng-pass-txt i {
	color: rgb(221, 221, 94);
	font-size: 25px;
	vertical-align: middle;
}

.chng-pass-txt p a {
	color: rgb(4, 189, 202);
	text-decoration: none;
	word-spacing: 0;
	letter-spacing: 0px;
	font-size: 16px;
	font-family: 'Montserrat', sans-serif;
}

.chng-pass-txt p a:hover {
	color: royalblue;
}

.info {
	height: 50px;
	background-color: #e3ffff;
	border-radius: 10px;
	width: 70%;
	display: flex;
	justify-content: center;
	align-items: center;
	transition: display 0.5s ease;
}

}
.info h6 {
	color: green;
	margin-bottom: 0.5rem !important;
}

.resp-msg {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 30px;
	margin-top: 20px;
	transition: display 0.5s ease;

}

#edit-btn:disabled, #save-btn:disabled {
	background-color: #afadad;
	cursor: not-allowed!;
	outline: none;
	border: none;
}
input[type="text"]:read-only{
	box-shadow: none;
}

/* ######################    MY Profile css end  ###################### */
</style>
</head>


<body
	onLoad="document.getElementById('user-location').value='<%=user.getLocation()%>';">
	<%@include file="leftbar.jsp"%>

	<section class="right-space">
		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text">My
				Profile</span> <span class="user-name"> <%=session.getAttribute("user.name")%>
			</span>

		</div>


		<!-- #############     my profile markup     ############## -->

	 <%@include file="message.jsp" %>
		

		<div class="chng-pass-txt">
			<p>
				<i class="fa-solid fa-triangle-exclamation"></i> <span>you
					can simply change your password by clicking on <a
					href="changepassword.jsp">Change Password</a>
				</span>
			</p>
		</div>
		<div class="viewprofile-cont">

			<div class="grid-image-profile">
				<div class="myprofile-icon">
					<img src="../images/myprofile-icon.png" alt="profile-icon"
						width="100px" height="100px"> <label for="file"> <input
						type="file" id="file"> <i class='bx bxs-edit'></i>
					</label>

				</div>
			</div>

			<div class="form-content">
				<form action="../do" method="post" id="my-profile-form" onSubmit="submitHandler()">
					<div class="infy-details">
						<div class="infy-text">
							<h5>Infosys Details:</h5>
						</div>

                                <div class="form">
                                    <input type=hidden name="actionStr" value="editProfile">

                                    <label for="first-name-user-reg">First Name :</label>
                                    <input type="text" class="form-control form-control-sm" id="first-name-user-reg"
                                        name="first-name" value="<%=user.getFirstName()%>" disabled>
                                    <br>
                                    <label for=" last-name-user-reg">Last Name :</label>
                                    <input type="text" class="form-control form-control-sm" id="last-name-user-reg"
                                        name="last-name" value="<%=user.getLastName()%>" disabled>
                                    <br>
                                    <label for="emp-id-user-reg"> Infosys Employee ID :</label>
                                    <input type="text" class="form-control form-control-sm" id="emp-id-user-reg"
                                        name="emp-id" value="<%=user.getEmpId()%>" disabled readonly>
                                    <br>
                                    <label for="emp-infy-mailid-user-reg">Infosys Mail ID :</label>
                                    <input type="text" class="form-control form-control-sm" name="email-id"
                                        id="emp-infy-mailid-user-reg" value="<%=user.getEmail()%>" disabled>
                                    <br>
                                    <label for="emp-location-user-reg">Location:</label>
                  
				                    <select name="location" id="user-location" disabled>
				                        <option value="None" style="background-color:#d8d8d8;">Select location</option>
				                        <option value="Banglore">Banglore</option>
					                    <option value="Bhubaneshwar">Bhubaneshwar</option>
					                    <option value="Chandigarh">Chandigarh</option>
					                    <option value="Chennai">Chennai</option>
					                    <option value="Gurgaon">Gurgaon</option>
					                    <option value="Hubballi">Hubballi</option>
					                    <option value="Hyderabad">Hyderabad</option>
					                    <option value="Indore">Indore</option>
					                    <option value="Jaipur">Jaipur</option>
					                    <option value="Mangaluru">Mangaluru</option>
					                    <option value="Mumbai">Mumbai</option>
					                    <option value="Mysuru">Mysuru</option>
					                    <option value="Nagpur">Nagpur</option>
					                    <option value="Pune">Pune</option>
					                    <option value="Tiruvananthapuram">Tiruvananthapuram</option>
				                    </select>
                                </div>
                            </div>
                            <div class=" anz-details">
                                <div class="anz-text">
                                    <h5>ANZ Details:</h5>
                                </div>
                                <div class="form">
                                <input type=hidden name="actionStr" value="editProfile" >

           
            
                <label for="anz-mail-id">ANZ Mail ID :</label>
                <input type="text" class="form-control form-control-sm" id="anz-mail-id" name="anz-MailId" contenteditable="True"
                    value="<%=anzmailid%>" disabled>
                <br>
                <label for="anz-lan-id">ANZ LAN ID:</label>
                <input type="text" class="form-control form-control-sm" id="anz-lan-id" name="anz-LanId" contenteditable="True"
                    value="<%=anzlanid%>" disabled>
                <br>
                <label for="anz-emp-id"> ANZ Employee ID :</label>
                <input type="text" class="form-control form-control-sm" id="anz-emp-id" name="anz-EmpId" placeholder="For Admin use " contenteditable="True"
                 value="<%=user.getAnzEmpId()%>"   disabled readonly>
                <br>
                <label for="anz-squad-name"> ANZ Squad :</label>
                <input type="text" class="form-control form-control-sm" id="anz-squad-name" name="anz-Squad" contenteditable="True"
                    value="<%=squad%>" disabled>
                <br>
                <label for="anz-prog-name"> Program :</label>
                <input type="text" class="form-control form-control-sm" id="anz-prog-name" name="Program" contenteditable="True"
                    value="<%=program%>" disabled>
                <!-- <input type=" text" placeholder="Program name(DRO/ BAU"> -->

						</div>
						<br>


					</div>
				</form>
			</div>
			<div class="footer-1">
				<div class="edit-btn">
					<button class="btn btn-primary" id="edit-btn" type="button"
						onClick="editFunction()">Edit</button>
				</div>
				<div class="save-btn">
					<button class="btn btn-primary save-btn" id="save-btn"
						type="submit" form="my-profile-form" disabled onClick="saveFunction()">Save</button>
				</div>

    </div>
    


</div>

<!-- #############     my profile markup end   ############## -->
    
  </section>

        <script>
            function editFunction() {
                let savebtn = document.getElementById('save-btn');
                let setlocation = document.getElementById('user-location');
                let editbtn = document.getElementById('edit-btn');
                let inputs = document.querySelectorAll('input');
                inputs.forEach(item => {
                    item.removeAttribute('disabled');
                    item.style.backgroundColor = 'white';
                    item.style.border = '1px solid royalBlue';
                })
                savebtn.removeAttribute('disabled');
                setlocation.removeAttribute('disabled');
                setlocation.style.backgroundColor = 'white';
                setlocation.style.border = '1px solid royalBlue';
                editbtn.setAttribute('disabled','true');
            
            }
            function saveFunction() {
            	  
            	  
            	  setTimeout(() => {
            		  let respMsg = document.querySelector(".resp-msg");
                      respMsg.style.display = 'none';
                      
                   }, 10000);
            }
           
          
            

    </script>
	<script src="../js/home.js"></script>

</body>

</html>