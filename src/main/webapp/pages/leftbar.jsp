<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="sidebar close">
	<div class="logo-details">
		<img class="logo_name" id="logo" src="../images/ibsc-logo-anz.png" alt=" ANZ-logo" height="80px"> 
		<a href="userhome.jsp"><img src="../images/ibsc-logo-icon.png" alt="logo-icon" height="70px"></a>
	</div>
	<ul class=" nav-links">
		<li><a href="../do?actionStr=viewProfile" class="link"> <i
				class='bx bxs-user-rectangle'></i> <span class="link_name">My
					Profile</span>
		</a>
			<ul class="sub-menu blank">

				<li><a class="link_name" href="../do?actionStr=viewProfile">My
						Profile</a></li>
			</ul></li>
		<li><a href="../do?actionStr=onboarding" class="link"> <i
				class='bx bxs-bar-chart-alt-2'></i> <span class="link_name">OB
					Status</span>
		</a>
			<ul class="sub-menu blank">
				<li><a class="link_name" href="../do?actionStr=onboarding">On-Board
						Status</a></li>
			</ul></li>
		<li>
			<div class="iocn-link">
				<a href="../do?actionStr=viewTrainings" class="link"> <i
					class='bx bxs-book-open'></i> <span class="link_name">Training</span>
				</a> 
			</div>
			<ul class="sub-menu blank">
				<li><a class="link_name" href="../do?actionStr=viewTrainings">Training</a></li>
			</ul>
		</li>
		<li>
			<div class="iocn-link">
				<a href="../do?actionStr=viewDocuments" class="link"> <i
					class='bx bxs-file-doc'></i> <span class="link_name">Documents</span>
				</a>
				<!--  <i class='bx bxs-chevron-down arrow'></i> -->
			</div>
			<ul class="sub-menu blank">
				<li><a class="link_name" href="../do?actionStr=viewDocuments">Documents</a></li>
			</ul>
		</li>
		<li>
			<div class="iocn-link">
				<a href="../do?actionStr=favourites" class="link"> <i
					class='bx bxs-heart'></i> <span class="link_name">Favourites</span>
				</a> 
			</div>
			<ul class="sub-menu blank">
				<li><a class="link_name" href="../do?actionStr=favourites">Favourites</a></li>
			</ul>
		</li>
		<li>
		
			<div class="log-out-cont">
				<div class="log-out-img">
					<a href="../do?actionStr=logout"><img
						src="../images/log-out-icon.png" alt="log-out-icon"></a>
				</div>
				<div class="log-out-name">
					<a href="../do?actionStr=logout">
						<div class="log-out-text">Logout</div>
					</a>

				</div>
			</div>
		</li>
	</ul>
</div>