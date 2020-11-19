<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="jquery-3.5.1.js"></script>

</head>
<body>
	<form action="Join" method="post">
	<H1>회원가입</h1>
	<table style="border:1px; border-style:solid; border-color:black" >
		<tr>
			<td>이름(필수)</td><td><input type="text"  id="member_name" name="member_name"  placeholder="이름 입력" autofocus size="10"></td>
		</tr>
		<tr>
			<td>아이디(필수)</td><td><input type="text"  id="member_id" name="member_id" placeholder="아이디 입력"  size="10"></td>
		</tr>
		<tr>
			<td>비밀번호(필수)</td><td><input type="text"  id="member_password" name="member_password" placeholder="비밀번호 입력" size="10"></td>
		</tr>
		<tr>
			<td>비밀번호 확인(필수)</td><td><input type="text"  id="member_passwordCheck" name="member_passwordCheck" placeholder="비밀번호 재입력" size="10"></td>
		</tr>
		<tr>
			<td>주소(필수)</td><td><input type="text"  id="memberAdress" name="member_Adress"></td>
		</tr>
		<tr>
			<td>전화번호(필수)</td><td><input type="text"  id="memberPhone" name="member_Phone"></td>
		</tr>
		<tr>
			<td>코로나에 걸린 적이 있습니까?(선택)</td>
			<td>
			<input type="radio"  name="member_result" value="1">예
			<input type="radio"  name="member_result" value="2">아니오
			</td>
		</tr>
		<tr>
		<td><input type="submit" value="회원가입" id="Regist"> <input type="reset" value="초기화"></td>
		</tr>
		
	</table>
	&nbsp;<span id="Msg"></span>
	</form>
</body>
</html>