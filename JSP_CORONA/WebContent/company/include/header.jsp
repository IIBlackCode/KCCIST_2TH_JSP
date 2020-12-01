<%@page import="com.company.member.DAO.IMemberDAO"%>
<%@ page import="com.company.member.DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Header -->
<%IMemberDAO dao = new IMemberDAO();%>
<%Member member = (Member)session.getAttribute("member");%>
<%String pathHeader = request.getContextPath()+"/company"; %>
<header id="header">
	<a class="logo" href="<%=pathHeader%>/index.jsp">COMPANY</a>
	<nav>
	
		<% 	if(dao.select_MemberList().isEmpty()){%>
		<a href="<%=pathHeader%>/Member/Join">관리자계정 생성 필요</a>
		<%}%>
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