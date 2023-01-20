<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.UserVO"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<%@ page import="com.infy.ibsc.vos.UserOnboardingVO"%>
<%@ page import="com.infy.ibsc.vos.OnboardingVO"%>
<%@ page import="com.infy.ibsc.util.OnboardingUtil"%>
<%@ page import="com.infy.ibsc.util.UserUtil"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style>

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
    position: fixed;
    top:20%
}
.popup .popup-cont .close{ 
    display: flex;
    justify-content: flex-end;
    margin-bottom: 50px;
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
    width: 160px;
    text-align: left;
    /* margin-left: 50px; */
    font-weight: 500;
    font-size: 18px;
}
.popup .popup-cont .data-cont label:nth-child(5){
 text-align: left;
 margin-right: 203px;
 margin-left: 0;
 margin-bottom: 10px;
}
.popup .popup-cont .data-cont input{
    display: inline-block;
    width: 200px;
    outline: none;
    border: none;
    text-align: center;
    margin: 8px 0;
    color: royalblue;
    font-size: 22px;
}
.popup .popup-cont .data-cont textarea{
    width: 72%;
    margin: 0 auto;
}
.popup .popup-cont .popup-btns{
    display: flex;
    justify-content: space-evenly;
    margin-bottom: 50px;
}





.err{
            	color: red;
            }

@media ( max-width : 768px) {
	.search-cont {
		justify-content: center;
	}
}
</style>
</head>

<%
// here all page specific variables
String title = "Update Onboarding";
ArrayList list = (ArrayList) session.getAttribute("Admin.UserOnboardingList");
String adminName =  (String)session.getAttribute("admin.name");
%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>
		<%@include file="message.jsp" %>
			

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
							if(ref.contains(",")){
								String arr[] = ref.split(",");
								hyperlink = "<a href=\""+arr[1]+"\" target=\"_blank\">" + arr[0]+"</a>";
							}
							else{
								//System.out.println("Inside else=");
								hyperlink = "<a href=\""+ref+"\" target=\"_blank\">" + ref+"</a>";
							}
					%>
					<tr>
						<td><%=uobVo.getStep_Id()%></td>
						<%
						if("Completed".equals(uobVo.getOB_Status())){
							%>
							<td><%=obVo.getStep_Desc()%></td>
							<%
						}
						else{
							%><td><a id="link" style="color: blue; cursor:pointer;" 
						href="javascript:popupdisplay('<%=uobVo.getStep_Id()%>','<%=obVo.getStep_Desc()%>','<%=uobVo.getRemarks()%>')">
                                <%=obVo.getStep_Desc()%>
                            </a></td>
                            <%
						}
						%>
						
						<td><%=uobVo.getOB_Status()%></td>
						<td><%=user.getName()%></td>
						<td><%=uobVo.getRemarks()%></td>
						<td><%=hyperlink%></a></td>
					</tr>

					<%
					}
					%>
					</table>
					<%
					
					} else {
					%>	
					<div id="onboard-not-started">
						<p> onboarding has not started yet. Check in database.</p>
					</div>
					<% 
					}
					%>
				
			



		</div>
	
		
		
		 <div class="popup">
		 <form action="../do" method=post>
			<input type=hidden name="actionStr" value="completestep">
	   <input type=hidden name="startPage" value="updateOnboarding">
	   <input type=hidden name="decision" id="decision" value="Accept">
		  <input type=hidden name="remarks"  id ="remarks" value="">
            <div class="popup-cont">
                <div class="close" onclick="closepopup()">
                    <img src="../images/OIP.jpg.png" id="close-btn" >
                </div>
                <div class="data-cont">
                	
                    <label>Step ID :</label>
                    <input value="" name="step-id" id="step-id" readonly />
                    <label>Step Description :</label>
                    <input value="" name="step-Description" id="step-Description" readonly />
                    
                    <label> Remarks :</label>
                    <textarea placeholder="Add Remarks" required name="onboard-step-remarks"></textarea>
                </div>
                <div class="popup-btns">
                    <button class="btn btn-primary" type="button" onclick="completeStep()" id="complete">Accept</button>
               <button class="btn btn-danger" type="button" onclick="rejectStep()" id="reject">Reject</button>
                </div>
            </div>
            </form>
        </div>


				
	</section>
	<script src="../js/home.js"></script>
		  <script>
	  
	  function completeStep(){
		  //document.getElementById('actionstr')
		  document.forms[0].submit();
	  }
	  function rejectStep(){
		  document.getElementById('decision').value='Reject';
		  document.forms[0].submit();
	  }
	  
	  function popupdisplay(stepId,StepDescription,remarks){
		  	
	        let closePopup = document.getElementById("close-btn");
	        let rightspace = document.getElementsByTagName(".right-space");
	        let backdrop = document.querySelector(".popup");
	        let popuplinks = document.querySelectorAll("#link");
	        let backbtn = document.querySelectorAll("#back");
	        console.log(rightspace);
	        document.getElementById("step-id").value=stepId;
	        backdrop.style.display = "flex";
	        document.getElementById("step-Description").value=StepDescription;
	        document.getElementById("remarks").value=remarks;
	        //backdrop.style.display = "flex";
	  }
	  
	  function closepopup(){
		  let backdrop = document.querySelector(".popup");
		  backdrop.style.display = "none";
	  }
	
    </script>
	
	
</body>

</html>