<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Generic Page - Industrious by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/company/assets/css/main.css" />
	</head>
	<body class="is-preload">

	<!-- HEADER -->
	<%@include file="/company/include/header.jsp"%>

	<!-- Nav -->
	<%@include file="/company/include/nav.jsp"%>

	<!-- Heading -->
	<div id="heading" >
		<h1>RELEASE NOTE</h1>
	</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<header>
							<h2>RELEASE NOTE</h2>
						</header>
						<p>JSP PROJECT START</p>
						<hr />
						<p>
							2021-05-23 <br>
							1. 댓글기능 구현 완료<br> 
							2. 비밀채팅기능 구현 및 비회원이 채팅 url 접근제한<br> 
							3. 버전관리 추가<br> 
							<br> 
							2021-06-06 <br>
							* 회원 수정시 페이지 내에서 변경안되는 현상 수정<br> 
								- 세션값을 불러오는 방식 > DB에서 select 하는 방식으로 변경<br> 
							<br> 
							2022-09-24 <br>
							1. URL 하드코딩 수정 및 정리<br> 
								- navbar<br> 
								- old ver, header<br>
							2. Azure PaaS DB (Public)연동<br>
							3. Chat 관련 javascript 기능 하나로 통합<br>
						</p>
						<hr />
						<h3>Magna odio tempus commodo</h3>
						<p>Felis sagittis eget tempus primis in faucibus vestibulum. Blandit adipiscing eu felis iaculis volutpat ac adipiscing accumsan eu faucibus. Integer ac pellentesque praesent tincidunt felis sagittis eget. tempus euismod. Magna sed etiam ante ipsum primis in faucibus vestibulum. Blandit adipiscing eu ipsum primis in faucibus vestibulum. Blandit adipiscing eu felis iaculis volutpat ac adipiscing accumsan eu faucibus lorem ipsum dolor sit amet nullam.</p>
					</div>
				</div>
			</section>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>

	</body>
</html>