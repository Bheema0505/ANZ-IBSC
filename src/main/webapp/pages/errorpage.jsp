<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<%-- <%@include file="common.jsp" %> --%>

<style>

body{
  margin: 0;
  padding: 0;
  font-family: "montserrat",sans-serif;
  min-height: 100vh;
}

.container{
  width: 100%;
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  text-align: center;
  color: #343434
}

.container h1{
  color: transparent;
  font-size: 160px;
  margin: 0;
  font-weight: 900;
  letter-spacing: 20px;
  background: royalblue url(../images/errortextbg.jpg) left repeat;
  background-size: cover;
  -webkit-text-fill-color: transparent;
  -webkit-background-clip: text;
  background-clip: text;
}

.container a{
  text-decoration: none;
  background: #98a8d8;
  color: #fff;
  padding: 12px 24px;
  display: inline-block;
  border-radius: 25px;
  font-size: 14px;
  text-transform: uppercase;
  transition: 0.4s;
}
.container p{
margin: 40px 0px 40px;
font-size: 20px;
}

.container a:hover{
  background: royalblue;
  scale: 1.1;
}


</style>


</head>

<%
// here all page specific variables


%>

<body>
 <%--  <%@include file="leftbar.jsp" %>  --%>
  
    <%-- <section class="right-space">
     <div class="right-content">
      <i class='bx bx-menu'></i>
      <span class="welcome-text">WELCOME TO IBSC</span> 
             <span class="user-name"><%=session.getAttribute("user.name") %></span>
      </div>  --%>
      
      
    <div class="container">
      <h2>Oops! Page not found.</h2>
      <h1>404</h1>
      <p>We can't find the page you're looking for.</p>
      <a href="userlogin.jsp">Back To Home</a>
    </div>

     
    </section>
    
 <%-- <script src="../js/home.js"></script>   --%>

</body>

</html>