<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<link rel="stylesheet" href="../../CSS/header.css">
	
<div id="header-area" class="section">
	<div class="icon">
		<a href="Main.html">
			<div class="photo"></div>
		</a>
	</div>
	<div class="section">
	<!-- <div id="menu-area" class="section"> -->
		<a href="Main.jsp">Main</a>
		<a href="SelfTest.jsp">자가진단</a>
		<a href="Inform.jsp">선별진료소 안내</a>
		<a href="MyPages.jsp">내정보</a>
		<%
			HttpSession sessionRank = request.getSession();
			sessionRank.getAttribute("member_rank");
			if(sessionRank.getAttribute("member_rank").equals("일반회원")){ 
		%>
		<a href="UserBoardList">게시판</a>
		<%}else{ %>
		<a href="AdminBoardList">관리자 게시판</a>
		<a href="#">회원 정보</a>
		<%} %>
		
		<%if (session.getAttribute("member_id") == null){ %>
		<h1>로그인이 필요합니다.</h1>
		<%}else{ %>
		<a href="Logout">로그아웃</a>
		<%} %>
		<hr>
	</div>
</div>