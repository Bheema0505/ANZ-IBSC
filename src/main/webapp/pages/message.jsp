<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="error-container">
         	<div class="error-msg">
 					<% String errMsg=(String)session.getAttribute("ERR_MSG"); if(errMsg !=null){ %>
                        <p>
                            <%=errMsg %>
                        </p>
                        <% session.removeAttribute("ERR_MSG"); } %>
             </div>
             <div class="info-msg">
 					<% String infoMsg=(String)session.getAttribute("INFO_MSG"); if(infoMsg !=null){ %>
                            <p class=>
                                <%=infoMsg %>
                            </p>
                            <% session.removeAttribute("INFO_MSG"); } %>
		    </div>
		 </div>