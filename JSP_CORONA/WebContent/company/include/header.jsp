<%@ page import="com.company.member.DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%
	Member member = (Member)session.getAttribute("member");
%>
<header id="header">
	<a class="logo" href="index.jsp">KMS COMPANY</a>
	<nav>
		<%if (member == null){ %>
		<a href="Login.jsp">로그인</a>
		<a href="MemberJoin.jsp">회원가입</a>
		<%}else{ %>
		<%if(member.getMember_rank().equals("관리자")){ %>
			<a href="#">[관리자]</a>
		<%}else{ %>
			<a href="MemberInfo.jsp">[<%=member.getMember_name()%>]</a>
		<%} %>
		<a href="Logout">로그아웃</a>
		<%} %>
		<a href="#menu">Menu</a> 
	</nav>
</header>