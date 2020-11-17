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
<link rel="stylesheet" href="../../CSS/Board.css">
</head>
<body>
	<!-- HEADER -->
	<%@include file="../include/header.jsp"%>
	
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
				<tr>
					<td>1</td>
					<td>안녕하세요.</td>
					<td>홍길동</td>
					<td>2020-11-09</td>
				</tr>
			</tbody>
		</table>
		<a href="write.jsp">글쓰기</a>
	</div>	

	<!-- FOOTER -->
	<%@include file="../include/footer.jsp"%>
</body>
</html>