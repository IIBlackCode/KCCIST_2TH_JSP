<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Nav -->
<nav id="menu">
	<ul class="links">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="MyInfo.jsp">내 정보</a></li>
		<li><a href="Login.jsp">Login</a></li>
		<li><a href="Join.jsp">Join</a></li>
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
		<li><a href="SelfTest.jsp">코로나 자가진단</a></li>
		<li><a href="generic.html">Generic</a></li>
		<li><a href="elements.html">Elements</a></li>
	</ul>
</nav>