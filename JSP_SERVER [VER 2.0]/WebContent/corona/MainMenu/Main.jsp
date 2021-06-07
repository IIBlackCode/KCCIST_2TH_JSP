<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Main</title>
<meta name=viewport
	content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; utf-8">
<meta charset="utf-8">
<link rel="stylesheet" href="../../CSS/Main.css">
</head>
<body>

	<!-- HEADER -->
	<%@include file="../include/header.jsp"%>

	<div id="contents-area" class="section">
		<div class="feed">
			<div class="autor">
				<center>
					<div class="photo"></div>
				</center>
				<center>
					<div class="name">ID</div>
				</center>
			</div>


			<div id="real-area" class="section">
				<center>
					<p>[SYSTEM] Guest모드 사용자는 후기를 작성할 수 없습니다.</p>
				</center>
			</div>
			<div id="footer-area" class="section">
				<center>
					<p>프로젝트 제작 : 코로나는 언제 끝나조 ?</p>
				</center>
				<div class="bar"></div>
			</div>
		</div>
	</div>
</body>
</html>