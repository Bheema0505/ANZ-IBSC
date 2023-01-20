<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.infy.ibsc.vos.FavouritesVO"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="common.jsp"%>
<link rel="stylesheet" href="../css/table.css">

<style>
.search-cont {
	margin-top: 40px;
	display: flex;
	/* background-color: antiquewhite; */
	justify-content: space-between;
	align-items: center;
	width: 95%;
	flex-wrap: wrap;
	flex-direction: row;
}

.ad-btn {
	min-width: 300px
}

.inp-select {
	background-color: azure;
	align-self: flex-end;
	margin-right: 20px;
}

.inp-select span {
	display: block;
}

.inp-select select {
	width: 200px;
	justify-self: center;
	height: 35px;
	font-size: 17px;
	background-color: #6984d6;
	color: white;
}

.inp-select select option {
	text-align: left;
	background-color: #fff;
	color: royalBlue;
}

.inp-select select option:hover {
	background-color: #lightBlue !important;
}

.inp-1 {
	position: relative;
}

.inp-1 .input {
	border: 2px solid royalblue;
	/* background-color: whitesmoke; */
	font-size: 18px;
	padding: 6px;
	height: 35px;
	width: 38px;
	transition: width 0.3s ease;
	border-radius: 15px 0 0 15px;
}

::placeholder {
	color: royalblue;
}

.inp-1 .searchbtn {
	border: 1px solid royalblue;
	cursor: pointer;
	font-size: 24px;
	position: absolute;
	top: 0;
	left: 0;
	width: 52px;
	height: 35px;
	transition: transform 0.3s ease;
	background-color: royalblue;
	border-radius: 4px;
}

.inp-1 .searchbtn i {
	color: white;
	font-size: 20px;
}

.inp-1.active-search .input {
	width: 250px;
	border-radius: 13px 0 0 13px;
	background-color: white;
}

.inp-1.active-search .searchbtn {
	transform: translateX(248px);
	border-radius: 0 13px 13px 0;
}

.sub-cont {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: space-evenly;
	text-align: center;
}

@media ( max-width : 768px) {
	.search-cont {
		justify-content: center;
	}
}

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
	min-height: 280px;
	width: 500px;
	flex-direction: column;
	border-radius: 15px;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
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
	/* display: flex;
    justify-content: center; */
	text-align: center;
	flex-direction: column;
	margin-bottom: 20px;
}

.popup .popup-cont .data-cont label {
	display: inline-block;
	width: 160px;
	text-align: left;
	/* margin-left: 50px; */
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
	margin: 50px 0;
}

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
	color: green;
}

.resp-msg {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 30px;
	margin-top: 20px;
}
</style>
</head>


<%
// here all page specific variables
String title = "Favourites";
String Id = (String) request.getParameter("Id");
ArrayList list = (ArrayList) session.getAttribute("FavouritesList");
%>


<body>
	<%@include file="leftbar.jsp"%>

	<section class="right-space">
		<form action="../do" method="post">
			<div class="right-content">
				<i class='bx bx-menu'></i> <span class="welcome-text"><%=title%></span>
				<span class="user-name"><%=session.getAttribute("user.name")%></span>
			</div>
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
			<div class="search-cont">
				<div class="addnewuser-btn">
					<a href="addfavourites.jsp" class="link">
						<button class="btn btn-success save-btn" id="save-btn"
							type="button" form="my-profile-form">Add Favourites</button>
					</a>
				</div>

				<div class="sub-cont">

					<input type=hidden id="actionStr" name="actionStr"
						value="searchfavourites">
					<div class="inp-select">
						<!-- <span>1. Search using :</span> -->
						<select name="search-id" id="search-id">
							<option value="0" disabled selected hidden="true">Search
								Using</option>
							<option value="Title">Title</option>
							<option value="Type">Type</option>

						</select>
					</div>
					<div class="inp-1">
						<input type="text" placeholder="Search..." value="" class="input"
							name="searchValue">
						<button class="searchbtn" type=submit>
							<i class='bx bx-search'></i>

						</button>
					</div>

				</div>


			</div>

			<div class="table-container">
				<%
				if (list != null && list.size() > 0) {
				%>
				<table class="emp-table">
					<thead>
						<tr>

							<th>Title</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>



						<%
						for (int i = 0; i < list.size(); i++) {
							FavouritesVO favVo = (FavouritesVO) list.get(i);
						%>
						<tr>

							<td><a href="<%=favVo.getLink()%>"> <%=favVo.getTitle()%></a>
							</td>
							<td><a
								href="javascript:popupdisplay('<%=favVo.getId()%>','<%=favVo.getTitle()%>','<%=favVo.getLink()%>')"
								class="link">
									<button class="btn btn-danger save-btn" id="save-btn"
										type="remove" form="my-profile-form">Remove</button>
							</a>
						</tr>
						<%
						}
						%>
					</tbody>

				</table>
				<%
				}

				else {
				%>
				<div class="no-data-found">
					<p>You have not added any favourites. Click on "Add Favourites"
						button to add.</p>
				</div>

				<%
				}
				%>


			</div>

			<div class="popup">

				<input type=hidden name="delFavid" id="Favid" value="<%=Id%>">

				<div class="popup-cont">
					<div class="close" onclick="closepopup()">
						<img src="../images/closeimg.png" id="close-btn">
					</div>
					<div class="data-cont">

						<label>Title :</label> <input value="" name="title" id="title"
							readonly /> <label>Link :</label> <input value="" name="link"
							id="link" readonly />

					</div>
					<div class="popup-btns">
						<button class="btn btn-primary" type="button" onclick="remove()"
							id="complete">Remove</button>
					</div>
				</div>
			</div>


		</form>

	</section>
	<script src="../js/home.js"></script>
	<script>
	let searchCont = document.querySelector(".inp-1");
    let searchInput = document.querySelector(".input");
    let searchBtn = document.querySelector(".searchbtn");

    searchBtn.addEventListener("click", () => {
    	if(searchCont.classList.contains("active-search")){
    		searchInput.focus();
    	}else{
    		 event.preventDefault()
    		 searchCont.classList.add("active-search");
    	}
  
    });
        function remove(){
  		  document.getElementById('actionStr').value="removefavourite";
  		  document.forms[0].submit();
  	  }
        
function popupdisplay(Id,Title,Link){
		  	
	        let closePopup = document.getElementById("close-btn");
	        let rightspace = document.getElementsByTagName(".right-space");
	        let backdrop = document.querySelector(".popup");
	        let popuplinks = document.querySelectorAll("#link");
	        let backbtn = document.querySelectorAll("#back");
	        console.log(rightspace);
	        document.getElementById("Favid").value=Id;
	        backdrop.style.display = "flex";
	        document.getElementById("title").value=Title;
	        backdrop.style.display = "flex";
	        document.getElementById("link").value=Link;
	        backdrop.style.display = "flex";
	  }
	  
	  function closepopup(){
		  let backdrop = document.querySelector(".popup");
		  backdrop.style.display = "none";
	  }
    </script>
</body>

</html>

