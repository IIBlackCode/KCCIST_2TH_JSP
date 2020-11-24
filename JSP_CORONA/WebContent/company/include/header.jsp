<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<header id="header">
	<a class="logo" href="index.html">KMS COMPANY</a>
	<nav>
		<%if (session.getAttribute("member_id") == null){ %>
		<a href="Login.jsp">로그인</a>
		<a href="Join.jsp">회원가입</a>
		<%}else{ %>
		<a href="Logout">로그아웃</a>
		<%} %>
		<a href="#menu">Menu</a> 
	</nav>
</header>