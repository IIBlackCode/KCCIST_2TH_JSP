<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name=viewport
	content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; utf-8">
<meta charset="utf-8">
<script src="login.js" type="text/javascript"></script>
<link rel="stylesheet" href="../CSS/Login.css">

</head>
<body>
	<div id="header-area" class="section">
		<div class="logo">
			<center>
				<div class="photo"></div>
			</center>
		</div>
	</div>

	<div id="contents-area" class="section">
		<div class="login">
			<div class="form_container">
				<!-- <form name="login_form" action="/corona/Login" method="post"> -->
				<form name="login_form" action="Login" method="post">
					<div class="form_title_div">
						<p class="form_title_p">로그인</p>
					</div>
					<div>
						<div> 
							<a class="form_item_name">ID</a>
						</div>
						<div>
							<input type="text" name="username" placeholder="사용자 ID" class="form_input" />
						</div>
						<div class="form_text_alert_padding">
							<div id="alert_username" class="form_text_alert"></div>
						</div>
					</div>

					<div>
						<div>
							<a class="form_item_name">Password</a>
						</div>
						<div>
							<input type="password" name="password" placeholder="사용자 비밀번호"
								class="form_input" />
						</div>
						<div class="form_text_alert_padding">
							<div id="alert_password" class="form_text_alert"></div>
						</div>
					</div>
					<div style="height: 10px;"></div>
					<div>
						<!-- <button type="submit" class="form_submit_button" onclick="login()">로그인</button> -->
						<button type="submit" class="form_submit_button" onclick="login()">로그인</button>
					</div>
					<div id="footer-area" class="section">
						<a href="Join.jsp">
							<div style="height: 10px;"></div>
							<button type="button" class="form_submit_button"
								id="Join">회원가입</button>

						</a>
						<div style="height: 10px;"></div>
						<button type="button" class="form_submit_button" id="cancleBtn">취소</button>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>