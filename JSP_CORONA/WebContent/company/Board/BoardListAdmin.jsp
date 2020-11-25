<%@ page import="com.corona.board.DTO.Board"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% ArrayList<Board> boardList = (ArrayList)request.getAttribute("boardList"); %>
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

	<!-- Heading -->
	<div id="heading">
		<h1>CORONA COMUNITY</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="content">
				<header>
					<h2>관리자 전용 게시판</h2>
				</header>

				<!-- CONTENT -->
				<div class="">
					<table class="" style="text-align: center">
						<thead>
							<tr>
								<th style="background-color: #eeeeee; text-align: center;">번호</th>
								<th style="background-color: #eeeeee; text-align: center;">제목</th>
								<th style="background-color: #eeeeee; text-align: center;">작성자</th>
								<th style="background-color: #eeeeee; text-align: center;">작성일</th>
							</tr>
						</thead>
						<%
							for (int i = 0; i < boardList.size(); i++) {
						%>
						<tbody>
							<tr>
								<td><%=boardList.get(i).getNum()%></td>
								<td><a
									href="BoardRead?Board_id=<%=boardList.get(i).getBoard_id()%>"><%=boardList.get(i).getBoard_title()%></a></td>
								<td><%=boardList.get(i).getMember_id()%></td>
								<td><%=boardList.get(i).getBoard_date()%></td>
							</tr>
						</tbody>
						<%
							}
						%>
					</table>
					<a href="BoardWrite" class="button">글쓰기</a>
				</div>

			</div>
		</div>
	</section>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>



</body>
</html>