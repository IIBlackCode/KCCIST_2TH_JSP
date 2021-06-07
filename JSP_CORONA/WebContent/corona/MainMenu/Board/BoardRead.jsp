<%@page import="com.company.board.DTO.Board"%>
<%@ page import="com.company.member.DTO.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Board board = (Board)request.getAttribute("board"); %>
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
			<table class="" style="text-align:center; border:1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시글 양식</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=board.getBoard_id()%></td>
					</tr>
					<tr>
						<td><%=board.getBoard_title()%></td>
					</tr>
					<tr>
						<td><%=board.getBoard_content()%></td>
					</tr>
				</tbody>
			</table>
			<%Member member = (Member)session.getAttribute("member");%>
			<%if(member != null){ %>
			<%if(member.getMember_id().equals(board.getMember_id())){%>
			<%-- <%if(request.getAttribute("member_id").equals(board.getMember_id())){%> --%>
				<a href="BoardUpdate?Board_id=<%=board.getBoard_id()%>">수정</a>
				<a href="BoardDelete?Board_id=<%=board.getBoard_id()%>">삭제</a>
			<%}else if(session.getAttribute("member_rank").equals("관리자")){ %>
				<a href="BoardUpdate?Board_id=<%=board.getBoard_id()%>">관리자 권한 수정</a>
				<a href="BoardDelete?Board_id=<%=board.getBoard_id()%>">관리자 권한 삭제</a>
			<%} }%>
		</div>
	</div>

	<!-- FOOTER -->
	<%@include file="/corona/include/footer.jsp"%>
</body>
</html>