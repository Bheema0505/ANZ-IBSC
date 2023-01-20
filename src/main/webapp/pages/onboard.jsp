<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.OnboardingVO"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>
<%@ page import="com.infy.ibsc.vos.UserOnboardingVO"%>
<%@ page import="com.infy.ibsc.util.OnboardingUtil"%>
<%@ page import="com.infy.ibsc.util.UserUtil"%>




<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>
<link rel="stylesheet" href="../css/table.css?v=1">
<style>
body{
	min-height: 100%;
}
/*
.popup {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 20;
	background-color: rgba(0, 0, 0, 0.75);
	display: none;
	justify-content: center;
	align-items: center;
} 

.popup .popup-cont {
	background-color: white;
	display: flex;
	height: 350px;
	width: 500px;
	flex-direction: column;
	border-radius: 15px;

}

.popup .popup-cont .close {
	display: flex;
	justify-content: flex-end;
	margin-bottom: 50px;
}

.popup .popup-cont .close img {
	cursor: pointer;
	height: 20px;
	margin: 5px;
}

.popup .popup-cont .data-cont {
	text-align:center;
	flx-direction: column;
	margin-bottom: 20px;
}

.popup .popup-cont .data-cont label {
	display: inline-block;
	width: 160px;
	text-align: left;
	font-weight: 500;
	font-size: 18px;

}
.popup .popup-cont .data-cont label:nth-child(5) {
	text-align: left;
	margin-right: 203px;
	margin-left: 0;
	margin-bottom: 10px;
}

.popup .popup-cont .data-cont input {
	display: inline-block;
	width: 200px;
	outline: none;
	border: none;
	text-align: center;
	margin: 8px 0;
	color: royalblue;
	font-size: 22px;
}

.popup .popup-cont .data-cont textarea {
	width: 72%;
	margin: 0 auto;
}

.popup .popup-cont .popup-btns {
	display: flex;
	justify-content: space-evenly;
	margin-bottom: 50px;
}

*/

.popup {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 20;
    background-color: rgba(0, 0, 0, 0.75);
    display: none;
    justify-content: center;
    align-items: center;
  }


.popup .popup-cont{
  background-color: white;
    display: flex;
    height: 350px;
    width: 500px;
    flex-direction: column;
    border-radius: 15px;
    position: absolute;
    top: 50%;
    transform: translate(-50%, -50%);
    left: 50%;
}
.popup .popup-cont .close{ 
    display: flex;
    justify-content: flex-end;
    margin-bottom: 40px;
}
.popup .popup-cont .close img{
    cursor: pointer;
    height: 20px;
    margin:5px;
} 
.popup .popup-cont .data-cont{
    /* display: flex;
    justify-content: center; */
    text-align: center;
    flex-direction: column;
margin-bottom: 20px;
}
.popup .popup-cont .data-cont label{
    display: inline-block ;
    width: 200px;
    text-align: left;
     margin-left: 20px; 
    font-weight: 500;
   color: royalblue;
   font-size: 1.1rem;
}

.popup .popup-cont .data-cont input,
.popup .popup-cont .data-cont textarea{
    display: inline-block;
    width: 200px;
    outline: none;
    margin: 8px 0;
   
}
.popup .popup-cont .data-cont textarea{
   resize: none;
    margin: 0 auto;
}
.popup .popup-cont .popup-btns{
    display: flex;
    justify-content: space-evenly;
    margin-bottom: 50px;
}

input[type="text"]:disabled{
	 background-color: #f3f2f2;
	
} 


</style>
</head>

<%
// here all page specific variables
String title = "ON-BOARDING";
ArrayList list = (ArrayList) session.getAttribute("UserOnboaringList");

String StepId = (String) request.getParameter("StepId");
String StepDescription = (String) request.getParameter("StepDescription");
UserVO userVO = (UserVO) session.getAttribute("UserVO");
%>




<body>
	<%@include file="leftbar.jsp"%>



	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=session.getAttribute("user.name")%></span>
		</div>
		<%@include file="message.jsp"%>
		<div class="table-container">
			<%
			if (list != null && list.size() > 0) {
				OnboardingUtil obUtil = OnboardingUtil.getInstance();
				UserUtil userUtil = UserUtil.getInstance();
			%>
			<table class="emp-table">
				<thead>
					<tr>
						<th>Step Id</th>
						<th>Step Description</th>
						<th>Status</th>
						<th>Assigned To</th>
						<th>Remarks</th>
						<th>Reference</th>

					</tr>
				</thead>
				<tbody>

					<%
					for (int i = 0; i < list.size(); i++) {
						UserOnboardingVO uobVo = (UserOnboardingVO) list.get(i);
						OnboardingVO obVo = obUtil.getOnboarding(uobVo.getStep_Id());
						UserVO user = userUtil.getUser(uobVo.getAssigned_To());
						String hyperlink = "";
						String ref = obVo.getReference();
						//System.out.println("ref="+ref);
						if (ref.contains(",")) {
							String arr[] = ref.split(",");
							hyperlink = "<a href=\"" + arr[1] + "\">" + arr[0] + "</a>";
						} else {
							//System.out.println("Inside else=");
							hyperlink = "<a href=\"" + ref + "\">" + ref + "</a>";
						}
					%>
					<tr>
						<td><%=uobVo.getStep_Id()%></td>
						<%
						if ("Completed".equals(uobVo.getOB_Status()) || "Submitted".equals(uobVo.getOB_Status())
								|| uobVo.getAssigned_To() != userVO.getEmpId()) {
						%>
						<td><%=obVo.getStep_Desc()%></td>
						<%
						} else {
						%><td><a id="link" style="color: blue; cursor: pointer;"
							href="javascript:popupdisplay('<%=uobVo.getStep_Id()%>','<%=obVo.getStep_Desc()%>','<%=uobVo.getRemarks()%>')">
								<%=obVo.getStep_Desc()%>
						</a></td>
						<%
						}
						%>


						<td><%=uobVo.getOB_Status()%></td>
						<td><%=user.getName()%></td>
						<td style="font-size: 0.8em;"><%=uobVo.getRemarks()%></td>
						<td><%=hyperlink%></a></td>
					</tr>

					<%
					}
					%>
				
			</table>
			<%
			} else {
			%>
			<div class="no-data-found">
				<p>Your onboarding has not started yet. Please contact Admin at
					anz_ibsc_pmo@infosys.com</p>
			</div>
			<%
			}
			%>

		</div>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  Launch static backdrop modal
</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>

		<div class="popup">
			<form action="../do" method=post>
				<input type=hidden name="actionStr" value="completestep"> <input
					type=hidden name="remarks" id="remarks" value="">

				<div class="popup-cont">
					<div class="close" onclick="closepopup()">
						<img src="../images/closeimg.png" id="close-btn">
					</div>
					<div class="data-cont">
						<label>Step ID :</label> <input value="" name="step-id"
							id="step-id" readonly />
						<!--  <label>Step Description :</label>
						<div name="step-Description" id="step-Description"></div>  -->

						<label> Remarks :</label>
						<textarea placeholder="Add Remarks" required
							name="onboard-step-remarks"></textarea>
					</div>

					<!--  <label>Training ID:</label>
                    <input type="text"  value="" name="dtr_id" id="dtr_id" readonly disabled />
                    <label>Name:</label>
                    <input type="text" value="" name="name" id="name" readonly disabled />
                    <label>Status:</label>
                   <input type="text" value="" name="status" id="status" readonly disabled />
                    <label>Completion Date:</label> 
                    <input type="date" name="actual-date" placeholder="YYYY-MM-DD" required autofocus/>  -->
					<!--    <textarea placeholder="Add Completion Date" required name="actual-date"></textarea>  -->
					
					<div class="popup-btns">
					<button class="btn btn-primary" type="button"
						onclick="completeStep()" id="complete">Submit</button>
				</div>
				</div>

				
			</form>
		</div>





	</section>
	<script>
		function completeStep() {
			//document.getElementById('actionstr')
			document.forms[0].submit();
		}

		function popupdisplay(stepId, StepDescription, remarks) {

			let closePopup = document.getElementById("close-btn");
			let rightspace = document.getElementsByTagName(".right-space");
			let backdrop = document.querySelector(".popup");
			let popuplinks = document.querySelectorAll("#link");
			let backbtn = document.querySelectorAll("#back");
			console.log(rightspace);
			document.getElementById("step-id").value = stepId;
			backdrop.style.display = "flex";
			//document.getElementById("step-Description").innerHTML = StepDescription;
			document.getElementById("remarks").value = remarks;
			//backdrop.style.display = "flex";
			let body = document.getElementsByTagName("BODY");
			body.style.overflow = "hidden"
			
		}

		function closepopup() {
			let backdrop = document.querySelector(".popup");
			backdrop.style.display = "none";
		}
	</script> 

</body>

</html>

