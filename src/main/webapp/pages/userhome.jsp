<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp" %>
</head>

<body>
  <%@include file="leftbar.jsp" %>
  
     <section class="right-space">
     <div class="right-content">
      <i class='bx bx-menu'></i>
      <span class="welcome-text">WELCOME TO IBSC</span> 
             <span class="user-name"><%=session.getAttribute("user.name") %></span>
      </div>
      
        <div class="container col-lg-12 col-md-12 col-sm-12 ">
            <div class="on-brd-txt">
                <span>Your On-Boarding Status is <span> <%=session.getAttribute("user.obstat") %></span></span>
            </div>
            <br>
            <div class="trng-txt">
             <span>Your Training status is <span> <%=session.getAttribute("user.trainstat") %></span> </span>
            </div>

        </div>
    </section>
  <script src="../js/home.js"></script>

</body>

</html>