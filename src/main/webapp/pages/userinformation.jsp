<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>
<!DOCTYPE html>
<html>
<%
UserVO vo = (UserVO) session.getAttribute("Search.UserVO");
%>
<head>
<%@include file="admincommon.jsp"%>



<style>
/*######################    ADD TRAINING css starts   ######################*/
body {
	background-color: #fff !important;
	background-image: none !important;
}

.start-onboard {
	display: flex !important;
	width: 99%;
	margin: 40px auto 20px; /*for centering*/
	justify-content: flex-end;
}

.user-info-cont {
	background-color: white;
	width: 70%;
	height: auto;
	margin: 0 auto; /*for centering*/
	display: flex;
	flex-direction: column;
	padding: 40px;
	border-radius: 20px;
	box-shadow: 3px 4px 20px 5px rgba(0, 0, 0, 0.1);
}

.user-info-name {
	/* background-color: azure; */
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid rgb(65, 225, 212);
}

.user-info-name .name {
	display: flex;
	flex-direction: column;
}

.user-info-name .name h1 {
	color: rgb(12, 206, 206);
}

.user-info-name .emp-id {
	display: flex;
	color: royalblue;
	align-items: center;
}

.user-info-details {
	/* background-color: blanchedalmond; */
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	margin-top: 50px;
}

.user-info-details .user-info-infy, .user-info-details .user-info-anz {
	margin: 10px;
}

.user-info-details .user-info-infy hr, .user-info-details .user-info-anz hr
	{
	margin: 3px 0px 15px 0px;
}

.user-info-details .user-info-infy label, .user-info-details .user-info-anz label
	{
	font-weight: 550;
	font-family: 'Montserrat', sans-serif;
	color: cadetblue;
}

.user-info-details .user-info-infy input, .user-info-details .user-info-anz input,
	.user-info-details .user-info-anz select {
	border: none;
	padding: 4px 0px;
	width: 90%;
}

.user-info-details .user-info-infy input:focus, .user-info-details .user-info-anz input:focus
	{
	border: none;
	outline: none;
}

.user-info-details .user-info-infy {
	width: 100%;
}

.user-info-details .user-info-anz {
	width: 100%;
}
/* .user-info-cont .btn-footer{
				  display: grid;
				  width: 100%;
				  margin: 40px 0px 10px;
				  grid-template-columns: 1fr 1fr;
				  grid-template-rows: 1fr;
				  grid-gap: 10px;
				}
				.user-info-cont .btn-footer .edit-save-btns{
				  grid-column: 1/3;
				  display: flex;
				  justify-content: space-around;
				  margin-left: 100px;
				}
				.user-info-cont .btn-footer .edit-save-btns .edit{
				  width: 70px;
				}
				
				.user-info-cont .btn-footer .start-onboard{
				  display: flex;
				  justify-content: flex-end;
				} */
.info {
	height: 50px;
	background-color: #e3ffff;
	border-radius: 10px;
	width: 70%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.info h6 {
	colo r: green;
}

.resp-msg {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 30px;
	margin-top: 20px;
}

.user-info-cont .btn-footer {
	display: flex;
	flex-direction: row;
	justify-content: space-evenly;
	margin: 50px 0px 0px;
}

.user-info-cont .btn-footer .edit-btns button {
	width: 70px;
}

.err {
	color: red;
}
</style>
</head>



<body
	onLoad="document.getElementById('user-location').value='<%=vo.getLocation()%>';">
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">
		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text">UserInformation
				Data</span> <span class="user-name"> <%=session.getAttribute("admin.name")%>
			</span>

		</div>


		<!-- #############     USER INFORMATION markup     ############## -->
		<div class="resp-msg">
			<%
			String infoMsg = (String) session.getAttribute("INFO_MSG");
			if (infoMsg != null) {
			%>
			<div class="info">
				<h6>
					<%=infoMsg%></h6>
			</div>
			<%
			session.removeAttribute("INFO_MSG");
			}
			%>
		</div>
		<div class="resp-msg">
			<%
			String errMsg = (String) session.getAttribute("ERR_MSG");
			if (errMsg != null) {
			%>
			<div class="err">
				<h6>
					<%=errMsg%></h6>
			</div>
			<%
			session.removeAttribute("ERR_MSG");
			}
			%>
		</div>

		<form action="../do" method="post" id="user-information-form">
			<div class="complete-onboard">
				<%
				if ("Started".equals(vo.getOb_Status())) {
				%>
				<div class="edit-btn">
					<button class="btn btn-info" id="ob-btn" type="button"
						onClick="completeonboard()">Complete Onboarding</button>
				</div>
				<%
				}
				%>

			</div>

			<div class="start-onboard">
				<%
				if ("Pending".equals(vo.getOb_Status())) {
				%>
				<div class="edit-btn">
					<button class="btn btn-info" id="ob-btn" type="button"
						onClick="onboard()">Start Onboarding</button>
				</div>
				<%
				}
				%>

			</div>

			<div class="user-info-cont">
				<div class="user-info-name">
					<div class="name">
						<h1><%=vo.getFirstName()%>
							<%=vo.getLastName()%></h1>
						<h6>System Engineer</h6>
					</div>
					<div class="emp-id">
						<h2>
							<%=vo.getEmpId()%></h2>
					</div>

				</div>
				<div class="user-info-details">
					<div class="user-info-infy">
						<input type=hidden id="actionStr" name="actionStr"
							value="edituserinformation"> <label>ANZ Email :</label> <input
							type="text" name="anzMailId" value="<%=vo.getAnzMailId()%>"
							readonly disabled />
						<hr>
						<label>Infy Email :</label> <input type="text"
							value="<%=vo.getEmail()%>" readonly disabled />
						<hr>

					</div>
					<div class="user-info-anz">


						<label>Location :</label>
						<%-- <input type="text" />--%>


						<select name="location" class="editable" id="user-location"
							disabled>
							<option value="None" style="background-color: #d8d8d8;">Select
								location</option>
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

						<hr>
						<label>Squad Name :</label> <input type="text" name="anzSquad"
							value="<%=vo.getAnzSquad()%>" class="editable" disabled />
						<hr>

					</div>

				</div>
				<div class="btn-footer">
					<div class="edit-btns">
						<button type="button" class="btn btn-primary" id="edit-btn"
							onclick="editFunction()">Edit</button>
					</div>
					<div class="save-btns">
						<button type="submit" class="btn btn-primary" id="save-btn"
							disabled>Save</button>
					</div>
				</div>

			</div>


		</form>





	</section>


	<script src="../js/home.js"></script>
	<script>
         function onboard(){
        	 document.getElementById('actionStr').value='startOnboarding';
        	 document.forms[0].submit();
         }
         function completeonboard(){
             document.getElementById('actionStr').value='completeOnboarding';
             document.forms[0].submit();
         }
        function editFunction() {
            let inputs = document.querySelectorAll('input');
            let editableInputs = document.querySelectorAll('.editable');
            let selectLocation = document.querySelector('.editable');
            console.log(editableInputs);
         
            inputs.forEach(item => {
                item.removeAttribute('disabled');
                item.style.backgroundColor = 'white';
                //item.style.border = '1px solid royalBlue';
            })
            editableInputs.forEach(ediitem => {
                ediitem.style.border = '1px solid royalBlue'
            });
            selectLocation.removeAttribute('disabled')
			
            let savebtn = document.getElementById('save-btn');
            savebtn.removeAttribute('disabled');
            let editbtn = document.getElementById('edit-btn');
            editbtn.setAttribute('disabled', 'true');

            

        }


    </script>



</body>

</html>