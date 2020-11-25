<%@page import="com.company.board.DAO.IBoardDAO"%>
<%@page import="com.company.board.DAO.BoardDAO"%>
<%@page import="com.company.board.DTO.Board"%>
<%@page import="java.util.ArrayList"%>
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
			<form action="BoardWrite" method="post">
				<table class="" style="text-align:center; border:1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" placeholder="글 제목" name="board_title" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea placeholder="글 내용" name="board_content" maxlength="2048" style="height: 350px;"></textarea></td>
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