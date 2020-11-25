<%@page import="com.company.member.DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
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
		<h1>내 정보</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="content">
				<header>
				</header>
				
				<!-- MyinfoUpdate Form -->
				<form action="Delete" method="post">					
					<div>
						<div>
							<label>아이디</label>
							<p><input type="hidden" name="member_id" value="<%=member.getMember_id()%>"><%=member.getMember_id()%></p>
						</div>
					</div>
					<p>
					<div>
						<div>
							<label>비밀번호</label>
							<input type="password"  id="member_password" name="member_password" placeholder="변경할 비밀번호 입력" size="10"/>
						</div>
					</div>
					<p>
					<p>
					<button type="submit" class="form_submit_button" onclick="Delete()">회원 탈퇴</button>
				</form>
				<!-- The end of MyinfoUpdate -->
				
			</div>
		</div>
	</section>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>



</body>
</html>