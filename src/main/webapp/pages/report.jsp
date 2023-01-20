<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.util.StrUtil"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="admincommon.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style>

body {
    background-color: white !important;
    background-image: none !important;
}

.right-space .list-container{
   /* background-color: antiquewhite; */
   width: 95%;
   display: flex;
   justify-content: center;
   
}
.right-space .reportlist {
    /* background-color: lightblue; */
    border-collapse: collapse;
    font-size: 1em;
    max-width: 600px;
    width: 100%;
    border-radius: 5px 5px 0px 0px;
    overflow: hidden;
    /* box-shadow: 0 0 20px rgba(0, 0, 0, 0.15); */
    margin: 30px 10px 10px 50px; 
    text-align: center;
    display: flex;
    justify-content: center;

}

.right-space .reportlist ul{
    list-style: none;
    width: 100%;
}

.right-space .reportlist li{
    background-color: #dbdfdf;
    border-radius: 50px 10px 10px 50px;
    margin: 20px;
    height: 60px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: larger;
    /* padding: 20px; */
    max-width: 400px;

}
.right-space .reportlist li .inner{
    display: inline-block;
    width: 250px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    height: 100%;
}
.right-space .reportlist li div{
    display: inline-block;
    align-items: center;
}
.right-space .reportlist li .inner .number{
    width: 65px;
    padding: 0;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 100px;
}
.right-space .reportlist li .view-btn{
    padding: 10px 0px;
    height: 100%;
}

#no1{
    background-color: rgb(241, 202, 101);
}
#no2{
    background-color: burlywood;
}
#no3{
    background-color: deeppink;
}
</style>
</head>

<%
// here all page specific variables
String title = "Reports";
String adminName =  (String)session.getAttribute("admin.name");
%>


<body>
	<%@include file="adminleftbar.jsp"%>

	<section class="right-space">

		<div class="right-content">
			<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
			<span class="user-name"><%=adminName%></span>
		</div>
		 <div class="list-container">
            <div class="reportlist">
                <ul>
                    <li class="reportitems">
                        <div class="inner">
                            <div class="number" id="no1">1</div>
                            <div> Location Report</div>
                        </div>
                        <div class="view-btn"><a href="../do?actionStr=locationreport" >
                        <button class="btn btn-info">View</button></a></div>
                    </li>
                    <li class="reportitems">
                        <div class="inner">
                            <div class="number" id="no2">2</div>
                            <div> On-Board Report</div>
                        </div>
                        <div class="view-btn"><a href="../do?actionStr=onboardreport" >
                        <button class="btn btn-info">View</button></a></div>
                    </li>
                    <li class="reportitems">
                        <div class="inner">
                            <div class="number" id="no3">3</div>
                            <div>Off-Board Report</div>
                        </div>
                        <div class="view-btn"><a href="../do?actionStr=offboardreport" >
                        <button class="btn btn-info">View</button></a></div>
                    </li>
                </ul>
            </div>
        </div>
		

	</section>
	<script src="../js/home.js"></script>
	
</body>

</html>