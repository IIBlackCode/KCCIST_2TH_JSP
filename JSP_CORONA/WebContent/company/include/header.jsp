<%@ page import="com.company.member.DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%Member member = (Member)session.getAttribute("member");%>
<%String pathHeader = request.getContextPath()+"/company"; %>
<header id="header">
	<a class="logo" href="<%=pathHeader%>/index.jsp">KMS COMPANY</a>
	<nav>
		<%if (member == null){ %>
		<a href="<%=pathHeader%>/Login.jsp">로그인</a>
		<a href="<%=pathHeader%>/Member/MemberJoin.jsp">회원가입</a>
		<%}else{ %>
		<%if(member.getMember_rank().equals("관리자")){ %>
			<a href="<%=pathHeader%>/Member/MemberInfo.jsp">[관리자]</a>
		<%}else{ %>
			<a href="<%=pathHeader%>/Member/MemberInfo.jsp">[<%=member.getMember_name()%>]</a>
		<%} %>
		<a href="<%=pathHeader%>/Logout">로그아웃</a>
		<%} %>
		<a href="#menu">Menu</a> 
	</nav>
</header>