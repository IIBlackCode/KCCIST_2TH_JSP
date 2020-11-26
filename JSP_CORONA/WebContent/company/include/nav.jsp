<%@ page import="com.company.member.DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Nav -->
<nav id="menu">
	<ul class="links">
		<li><a href="index.jsp">Home</a></li>
		<% Member memberNAV = (Member)session.getAttribute("member"); %>
		<%if(memberNAV != null){ %>
		<!-- 관리자인 경우 -->
			<%if(memberNAV.getMember_rank().equals("관리자")){ %>
		<li><a href="BoardListAdmin">관리자 게시판</a></li>
		<li><a href="MemberListAdmin.jsp">회원 정보</a></li>
			<%}else{ %>
		<!-- 관리자가 아닌 경우 -->
		<li><a href="BoardListUser">게시판</a></li>
			<%} %>
		<%}else{ %>
		<!-- 로그인을 안했을 때 -->
		<li><a href="BoardListUser">게시판</a></li>
		<li><a href="CoronaSelfTest.jsp">코로나 자가진단</a></li>
		<%} %>
		<li><a href="generic.html">Generic</a></li>
		<li><a href="elements.jsp">Elements</a></li>
	</ul>
</nav>