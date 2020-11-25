<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Nav -->
<nav id="menu">
	<ul class="links">
		<li><a href="index.jsp">Home</a></li>
		<%
		if(session.getAttribute("member_id") != null){
			if(session.getAttribute("member_rank").equals("관리자")){
		%>
		<li><a href="BoardListAdmin">관리자 게시판</a></li>
		<li><a href="#">회원 정보</a></li>
			<%}else{%>
			<li><a href="BoardListUser">게시판</a></li>
			<li><a href="MyInfo.jsp">나의 회원 정보</a></li>
			<%} %>
		<%}else {%>
			<li><a href="BoardListUser">게시판</a></li>
		<%} %>
		<%
		session.getAttribute("member_rank");
		%>
		<li><a href="CoronaSelfTest.jsp">코로나 자가진단</a></li>
		<li><a href="generic.html">Generic</a></li>
		<li><a href="elements.html">Elements</a></li>
	</ul>
</nav>