<%@ page import="com.company.member.DTO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Member memberNAV = (Member)session.getAttribute("member"); %>
<% String pathNAV = request.getContextPath()+"/company"; %>
<!-- Nav -->
<nav id="menu">
	<ul class="links">
		<li><a href="<%=pathNAV%>/index2.jsp">Home</a></li>
		<li><a href="<%=request.getContextPath()%>/corona/MainMenu/Main.jsp">Ver 1.0</a></li>
		<%if(memberNAV != null){ %>
		<!-- 관리자인 경우 -->
			<%if(memberNAV.getMember_rank().equals("관리자")){ %>
		<li><a href="<%=request.getContextPath()%>/company/BoardListAdmin">관리자 게시판</a></li>
		<li><a href="<%=request.getContextPath()%>/company/BoardListUser">회원 게시판</a></li>
		<li><a href="<%=request.getContextPath()%>/company/MemberListAdmin">회원 정보</a></li>
		<li><a href="<%=request.getContextPath()%>/company/Chatting">코로나톡</a></li>
		<li><a href="<%=request.getContextPath()%>/company/ChatLog">코로나톡 로그</a></li>
		<li><a href="<%=request.getContextPath()%>/company/DatabaseConnectionInfo.jsp">DB Connection 정보</a></li>
			<%}else{ %>
		<!-- 관리자가 아닌 경우 -->
		<li><a href="<%=request.getContextPath()%>/company/Member/MemberInfo.jsp">내 정보</a></li>
		<li><a href="<%=request.getContextPath()%>/company/BoardListUser">게시판</a></li>
		<li><a href="<%=request.getContextPath()%>/company/CoronaSelfTest.jsp">코로나 자가진단</a></li>
		<li><a href="<%=request.getContextPath()%>/company/Chatting">코로나톡</a></li>
			<%} %>
		<%}else{ %>
		<!-- 로그인을 안했을 때 -->
		<li><a href="<%=request.getContextPath()%>/company/BoardListUser">게시판</a></li>
		<%} %>
		<li><a href="<%=request.getContextPath()%>/company/generic.jsp">Generic</a></li>
		<li><a href="<%=request.getContextPath()%>/company/elements.jsp">Elements</a></li>
		<li><a href="<%=request.getContextPath()%>/company/ReleaseNote.jsp">ReleaseNote</a></li>
	</ul>
</nav>