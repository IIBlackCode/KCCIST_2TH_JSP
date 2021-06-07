<%@page import="DataBaseConnection.DTO.DataBaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>DataBase Connection Info</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
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
	<div id="heading" >
		<h1>DataBase Connection Info</h1>
	</div>
		<%
			DataBaseConnection conn = new DataBaseConnection();
			String os = System.getProperty("os.name").toLowerCase();

		%>
		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<header>
							<h2>DataBase Connection Info</h2>
						</header>
						
						<p>SERVER OS : <%=os %></p>
						<hr />
						<p>DB IP : <%=conn.getIp() %></p>
						<p>DB PORT : <%=conn.getPort() %></p>
						<p>DB DRIVER : <%=conn.getDriver() %></p>
						<hr />
						<h5>DB 계정 정보</h5>
						<p><%=conn.getDataBaseUrl() %></p>
						<p><%=conn.getDataBaseId() %></p>
						<p><%=conn.getDataBasePw() %></p>
					</div>
				</div>
			</section>

	<!-- FOOTER -->
	<%@include file="/company/include/footer.jsp"%>
	<!-- SCRIPT -->
	<%@include file="/company/include/script.jsp"%>

	</body>
</html>