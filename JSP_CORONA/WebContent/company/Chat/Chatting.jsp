<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="DataBaseConnection.DTO.DataBaseConnection"%>
<%@ page session="true"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Generic Page - Industrious by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/company/assets/css/main.css" />
</head>
<body class="is-preload">

	<!-- HEADER -->
	<%@include file="/company/include/header.jsp"%>

	<!-- Nav -->
	<%@include file="/company/include/nav.jsp"%>

	<!-- Heading -->
	<div id="heading">
		<h1>CHATTING Page</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="content">
			
				<header>
					<h2>CHATTING</h2>
				</header>
				
				<!-- 로그인한 상태일 경우와 비로그인 상태일 경우의 chat_id설정 -->
				<c:if test="${(login.id ne '') and !(empty login.id)}">
					<input type="hidden" value='${login.id }' id='chat_id' />
				</c:if>
				<c:if test="${(login.id eq '') or (empty login.id)}">
					<input type="hidden" value=<%=member.getMember_name()%> id='chat_id' />
				</c:if>
				
				<!--     채팅창 -->
				<% if(member.getMember_id().equals("megazone")||member.getMember_id().equals("관리자")){ %>
					<div id="_chatbox_megazone" style="display: none">
						<fieldset>
							<div id="messageWindow" style="overflow: auto; height:250px;"></div>
							<br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
							<input type="submit" value="send" onclick="send()" />
						</fieldset>
					</div>
					<h5>MEGAZONECLOUD 전용 채팅</h5>
					<img style="width: 30%" class="chat_megazone" src="<%=request.getContextPath()%>/company/images/MEGAZONE CLOUD CI_03.png" />
				
				<%}if(member.getMember_id().equals("관리자")||member.getMember_id() !=("megazone")){ %>
					<hr>
					<div id="_chatbox" style="display: none">
						<fieldset>
							<div id="messageWindow"></div>
							<br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
							<input type="submit" value="send" onclick="send()" />
						</fieldset>
					</div>
					<img class="chat" src="<%=request.getContextPath()%>/company/images/chat.png" />
				<%}else{%>
					<hr>
					<div id="_chatbox" style="display: none">
						<fieldset>
							<div id="messageWindow"></div>
							<br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
							<input type="submit" value="send" onclick="send()" />
						</fieldset>
					</div>
					<img class="chat" src="<%=request.getContextPath()%>/company/images/chat.png" />
				<%}%>
				
			</div>
	</section>
	
	<%-- <section id="main" class="wrapper">
		<div class="inner">
			<div class="content">
			
				<header>
					<h2>CHATTING</h2>
				</header>
				<!-- 로그인한 상태일 경우와 비로그인 상태일 경우의 chat_id설정 -->
				<c:if test="${(login.id ne '') and !(empty login.id)}">
					<input type="hidden" value='${login.id }' id='chat_id' />
				</c:if>
				<c:if test="${(login.id eq '') or (empty login.id)}">
					<input type="hidden" value='비회원' id='chat_id' />
				</c:if>
				<!--     채팅창 -->
				<div id="_chatbox" style="display: none">
					<fieldset>
						<div id="messageWindow"></div>
						<br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
						<input type="submit" value="send" onclick="send()" />
					</fieldset>
				</div>
				<img class="chat" src="<%=request.getContextPath()%>/company/images/chat.png" />
			</div>
	</section> --%>
	
	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>
	<!-- CHATTING -->
	<%@include file="/company/include/Chatting.jsp"%>

</body>


</html>