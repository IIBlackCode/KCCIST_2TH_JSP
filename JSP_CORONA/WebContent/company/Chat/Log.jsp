<%@page import="com.company.chat.DTO.Chat"%>
<%@ page import="com.company.member.DTO.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>Chatting Log</h1>
	</div>

	<!-- CONTENT -->
	<div class="">
		<table class="" style="text-align: center">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">아이디</th>
					<th style="background-color: #eeeeee; text-align: center;">내용</th>
					<th style="background-color: #eeeeee; text-align: center;">날짜</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<Chat> chatList = (ArrayList)request.getAttribute("chatList");
					for (int i = 0; i < chatList.size(); i++) {
				%>
				<tr>
					<td><%=chatList.get(i).getId() %></td>
					<td><%=chatList.get(i).getMessage() %></td>
					<td><%=chatList.get(i).getDate() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>

</body>
</html>