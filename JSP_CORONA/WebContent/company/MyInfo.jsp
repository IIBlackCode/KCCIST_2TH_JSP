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
					<h2>SubTitle</h2>
				</header>
				
				<!-- Login Form -->
				<form action="Login" method="post">
					<div>
						<div>
							<label>아이디</label><input type="text" name="username" placeholder="사용자 ID"/>
							<p>Text Contents</p>
						</div>
					</div>

					<div>
						<div>
							<label>비밀번호</label><input type="password" name="password" placeholder="사용자 비밀번호"/>
							<p>Text Contents</p>
						</div>
					</div>
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