<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <div class="sidebar close">
        <div class="logo-details">
            <img class="logo_name" id="logo" src="../images/ibsc-logo-anz.png" alt=" ANZ- logo" height="80px">
			<a href="adminhome.jsp"><img src="../images/ibsc-logo-icon.png" alt="logo-icon" height="70px"></a>
        </div>
        <ul class=" nav-links">
            
            <li>
                 <a href="../do?actionStr=manageuser" class="link">
                    <i class='bx bxs-user-detail'></i>
                    <span class="link_name">Manage User</span>
                </a>
                <ul class="sub-menu blank">
                    <li>
                    	<a class="link_name" href="../do?actionStr=manageuser" >Manage User</a>
                    </li>
                </ul>
            </li>
            
            
               <li>
                 <a href="../do?actionStr=manageAdmin" class="link">
                    <i class="fa-solid fa-users"></i>
                    <span class="link_name">Manage Admin</span>
                </a>
                <ul class="sub-menu blank">
                     <li>
                     	<a class="link_name" href="../do?actionStr=manageAdmin">Manage Admin</a>
                     </li>

                </ul>
           	 </li>
            
             <li>
                <a href="../do?actionStr=managetraining">
                    <i class='bx bxs-pie-chart-alt'></i>
                    <span class="link_name">Manage Training</span>
                </a>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="../do?actionStr=managetraining">Manage Training</a></li>
                </ul>
            </li>
            
            
            <li>
            
                <a href="../do?actionStr=viewreport">
                    <i class='bx bxs-report'></i>
                    <span class="link_name">Reports</span>
                </a>
                <ul class="sub-menu blank">
                    <li><a class="link_name" href="../do?actionStr=viewreport">Reports</a></li>
                </ul>
            </li>
            <li>
			<div class="log-out-cont">
				<div class="log-out-img">
					<a href="../do?actionStr=adminlogout"><img
						src="../images/log-out-icon.png" alt="log-out-icon"></a>
				</div>
				<div class="log-out-name">
					<a href="../do?actionStr=adminlogout">
						<div class="log-out-text">Logout</div>
					</a>

				</div>
			</div>
		</li>
      
        </ul>
    </div>