<%@page import="com.corona.board.DTO.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% ArrayList<Board> boardList = (ArrayList)request.getAttribute("boardList"); %>
<%-- <jsp:useBean id="boardList" class=java.util.ArrayList scope="request"></jsp:useBean> --%>
<!DOCTYPE html>
<html>
<head>
<title>Main</title>
<meta name=viewport
	content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; utf-8">
<meta charset="utf-8">
<link rel="stylesheet" href="/CSS/Board.css">
</head>
<body>
	<!-- HEADER -->
	<%@include file="/corona/include/header.jsp"%>
	
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
			<%
				//ArrayList<Board> boardList = dao.select_BoardList();
				//ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
				for(int i = 0; i<boardList.size(); i++){
			%>
			<tbody>
				<tr>
					<td><%= boardList.get(i).getBoard_id() 	%></td>
					<td><a href="Board/BoardRead?Board_id=<%=boardList.get(i).getBoard_id()%>"><%= boardList.get(i).getBoard_title() %></a></td>
					<td><%= boardList.get(i).getMember_id() %></td>
					<td><%= boardList.get(i).getBoard_date() %></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
		<a href="BoardWrite">글쓰기</a>
	</div>	

	<!-- FOOTER -->
	<%@include file="/corona/include/footer.jsp"%>
</body>
</html>