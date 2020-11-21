<%@page import="com.corona.board.DAO.IBoardDAO"%>
<%@page import="com.corona.board.DAO.BoardDAO"%>
<%@page import="com.corona.board.DTO.Board"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="board" class="com.corona.board.DTO.Board" scope="session" type="com.corona.board.DTO.Board"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container">
		<div class="">
			<form action="BoardWrite" method="get">
				<table class="" style="text-align:center; border:1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<%
						//Object object = request.getAttribute("board");
						//board = (Board)object;
					%> 
					<tbody>
						<tr>
							<%-- <td><%=request.getAttribute("Board_title") %></td> --%>
							<td><%=request.getAttribute("Board_title")%></td>
						</tr>
						<tr>
							<%-- <td><%=request.getAttribute("Board_content")%></td> --%>
							<td><%=request.getAttribute("Board_content")%></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="" value="글쓰기">
			</form>
		</div>
	</div>

	<!-- FOOTER -->
	<%@include file="/corona/include/footer.jsp"%>
</body>
</html>