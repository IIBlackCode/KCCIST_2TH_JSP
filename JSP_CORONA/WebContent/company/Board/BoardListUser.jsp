<%@page import="com.corona.board.DTO.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% ArrayList<Board> boardList = (ArrayList)request.getAttribute("boardList"); %>
<% Board adminNotice = (Board)request.getAttribute("adminNotice"); %>
<!DOCTYPE HTML>
<html>
<head>
<title>Generic Page - Industrious by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="is-preload">

	<!-- HEADER -->
	<%@include file="/company/include/header.jsp"%>

	<!-- Nav -->
	<%@include file="/company/include/nav.jsp"%>
	
	<!-- Banner -->
	<section id="banner">
		<div class="inner">
			<h1>CORONA COMUNITY</h1>
			<p>코로나 대책을 위한 회원간의 소통공간입니다.</p>
		</div>
		<video autoplay loop muted playsinline src="images/banner.mp4"></video>
	</section>
	
	<!-- Heading -->
	<!-- <div id="heading">
		<h1>CORONA COMUNITY</h1>
	</div> -->

	<!-- CONTENT -->
	<div class="">	
		<table class="" style="text-align:center">
			<thead>
				<tr>
					<th style="background-color: #eeeeee; text-align: center;">번호</th>
					<th style="background-color: #eeeeee; text-align: center;">제목</th>
					<th style="background-color: #eeeeee; text-align: center;">작성자</th>
					<th style="background-color: #eeeeee; text-align: center;">작성일</th>
				</tr>
			</thead>
			<tbody>
				<!-- 관리자 공지사항 -->
				<%-- <tr>
					<td><B>공지사항</B></td>
					<td><a href="BoardRead?Board_id=<%=adminNotice.getBoard_id()%>"><b><%= adminNotice.getBoard_title() %></b></a></td>
					<td><%= adminNotice.getMember_id() %></td>
					<td><%= adminNotice.getBoard_date() %></td>
				</tr> --%>
				<tr>
					<td><B>공지사항</B></td>
					<td><b><a href="BoardRead?Board_id=<%=adminNotice.getBoard_id()%>"><%= adminNotice.getBoard_title() %></a></b></td>
					<td><B>관리자</B></td>
					<td><B><%=adminNotice.getBoard_date() %></B></td>
				</tr>
			<!-- 게시글 -->
			<%
				for(int i = 0; i<boardList.size(); i++){
			%>
				<tr>
					<td><%= boardList.get(i).getNum()	%></td>
					<td><a href="BoardRead?Board_id=<%=boardList.get(i).getBoard_id()%>"><b><%= boardList.get(i).getBoard_title() %></b></a></td>
					<td><%= boardList.get(i).getMember_id() %></td>
					<td><%= boardList.get(i).getBoard_date() %></td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<a href="BoardWrite" class="button primary" style="position: right">글쓰기</a>
	</div>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>



</body>
</html>