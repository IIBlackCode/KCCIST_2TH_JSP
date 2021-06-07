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
		<h1>Login Page</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="content">
				<header>
					<h2>사용자 로그인</h2>
				</header>
				
				<!-- Login Form -->
				<form action="Login" method="post">
					<table class="" style="text-align: center">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="username" placeholder="사용자 ID"/></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password" placeholder="사용자 비밀번호"/></td>
						</tr>
					</table>
					<button type="submit" class="form_submit_button" onclick="login()">로그인</button>
				</form>
				<!-- The end of LoginForm -->
				
			</div>
		</div>
	</section>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>



</body>
</html>