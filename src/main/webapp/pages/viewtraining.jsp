<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.TrainingVO"%>
<%@ page import="com.infy.ibsc.vos.UserTrainingVO"%>
<%@ page import="com.infy.ibsc.util.TrainingUtil"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>
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

.popup .popup-cont .data-cont input{
    display: inline-block;
    width: 200px;
    outline: none;
    margin: 8px 0;
   
    /* font-size: 1.2rem; */
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
String title = "My Trainings";

 ArrayList list = (ArrayList)session.getAttribute("UserTrainingList");
String tr_id = (String) request.getParameter("tr_id");
String name = (String) request.getParameter("name");
 String status = (String) request.getParameter("status");

%>


<body>
	<%@include file="leftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title %></span>
			<span class="user-name"><%=session.getAttribute("user.name") %></span>
		</div>
		<div class="table-container">



					<%
    if(list != null && list.size() > 0){
    %>
    			<table class="emp-table">
				<thead>
					<tr>
                        <th>Tr ID</th>
                        <th>Name</th>
                        <th>Type</th>
						<th>Status</th>
						<th>Actual Date</th>
						<th>Due Date</th>
						<th>Duration</th>
						<th>Reference</th>
					</tr>
				</thead>
				<tbody>
    
    	
    <% 
    	
    	TrainingUtil trUtil = TrainingUtil.getInstance();
    	for(int i=0;i<list.size();i++){
    	UserTrainingVO utrVo = (UserTrainingVO)list.get(i);  	
    	TrainingVO trVo =trUtil.getTraining(utrVo.getTraining_id());
    	String actual_date = StrUtil.nullToBlank(utrVo.getActual_date());
    	%>
					<tr>
					<td><%=trVo.getTr_id() %></td>
					<%
					  if("Completed".equals(utrVo.getStatus())){
					%>
					<td><%=trVo.getName()%></td>
					<% }else{ %>
					<td><a id="link" style="color: blue; cursor:pointer;" 
						href="javascript:popupdisplay('<%=trVo.getTr_id()%>','<%=trVo.getName()%>','<%=utrVo.getStatus()%>')">
                                <%=trVo.getName()%>
                            </a></td>
                            <%} %>
                            
					<td><%=trVo.getType() %></td>
						<td><%=utrVo.getStatus() %></td>				
						<td><%=actual_date%></td>
						<td><%=utrVo.getDue_date() %></td>
						<td><%=trVo.getDuration() %></td>
						<td><a href="<%=trVo.getReference()%>" target="_blank">Training link</a></td>
					</tr>
					<%
          }
    	%>
    		</tbody>
			</table>
    	<% 
    }
    else{
    	%>	
		<h3> No trainings are assigned to you yet. Please contact Admin at anz_ibsc_pmo@infosys.com</h3>
		<% 
    	
    }
        %>
		</div>
		
		<div class="popup">
		 <form action="../do" method=post>
		 <input type=hidden name="actionStr" value="completeTraining">
		  <input type=hidden name="tr_id" id="tr_id" value="">
		 
            <div class="popup-cont">
                <div class="close" onclick="closepopup()">
                    <img src="../images/closeimg.png" id="close-btn" >
                </div>
                <div class="data-cont">
                	
                    <label>Training ID:</label>
                    <input type="text"  value="" name="dtr_id" id="dtr_id" readonly disabled />
                    <label>Name:</label>
                    <input type="text" value="" name="name" id="name" readonly disabled />
                    <label>Status:</label>
                   <input type="text" value="" name="status" id="status" readonly disabled />
                    <label>Completion Date:</label> 
                    <input type="date" name="actual-date" placeholder="YYYY-MM-DD" required autofocus/>
                 <!--    <textarea placeholder="Add Completion Date" required name="actual-date"></textarea>  -->
                </div>
                
                <div class="popup-btns">
                    <button class="btn btn-primary" type="button" onclick="completeStep()" id="complete">Complete</button>
                </div>
            
                
            </div>
            </form>
        </div>
	</section>
	  <script>
	  
	  function completeStep(){
		  //document.getElementById('actionstr')
		  document.forms[0].submit();
	  }
	  function popupdisplay(tr_id,name,status){
		  	
	        let closePopup = document.getElementById("close-btn");
	        let rightspace = document.getElementsByTagName(".right-space");
	        let backdrop = document.querySelector(".popup");
	        let popuplinks = document.querySelectorAll("#link");
	        let backbtn = document.querySelectorAll("#back");
	        console.log(rightspace);
	        document.getElementById("tr_id").value=tr_id;
	        document.getElementById("dtr_id").value=tr_id;
	        backdrop.style.display = "flex";
	        document.getElementById("name").value=name;
	        document.getElementById("status").value=status;
	        //backdrop.style.display = "flex";
	  }
  function closepopup(){
		  let backdrop = document.querySelector(".popup");
		  backdrop.style.display = "none";
	  }
	
    </script>
</body>

</html>

