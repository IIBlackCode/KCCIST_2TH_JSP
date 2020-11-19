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
	<table style="border:1px; border-style:solid; border-color:black" >
		<h1>회원가입</h1>
		<tr>
			<td>회원유형</td> 
			<td>
			<select  id="memberType" name="memberType">
			<option value="" >선택</option>
			<option value="1" >개인</option>
			<option value="2" >진료소</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text"  id="member_name" name="member_name"  placeholder="이름 입력" autofocus size="10"></td>
		</tr>
		<tr>
			<td>아이디</td><td><input type="text"  id="member_id" name="member_id" placeholder="아이디 입력"  size="10"></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="text"  id="member_password" name="member_password" placeholder="비밀번호 입력" size="10"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td><td><input type="text"  id="member_passwordCheck" name="member_passwordCheck" placeholder="비밀번호 재입력" size="10"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td>시도 <select  id="memberMainAdress" name="memberMainAdress">
			<option value="" >선택</option>
			<option value="1" >강원</option> 
			<option value="2" >경기</option>
			<option value="3" >경남</option>
			<option value="4" >경북</option>
			<option value="5" >광주</option>
			<option value="6" >대구</option>
			<option value="7" >대전</option>
			<option value="8" >부산</option>
			<option value="9" >서울</option>
			<option value="10" >세종</option>
			<option value="11" >울산</option>
			<option value="12" >인천</option>
			<option value="13" >전남</option>
			<option value="14" >전북</option>
			<option value="15" >제주</option>
			<option value="16" >충남</option>
			<option value="17" >충북</option>
			</select>
			시군구 <select  id="memberSubAdress" name="memberSubAdress">
			<option value="" >선택</option>
				<optgroup label="서울">
					<option value="강남구" >강남구</option>
					<option value="강동구" >강동구</option>
					<option value="강서구" >강서구</option>
					<option value="4" >관악구</option>
					<option value="5" >광진구</option>
					<option value="6" >구로구</option>
					<option value="7" >금천구</option>
					<option value="8" >노원구</option>
					<option value="9" >동대문구</option>
					<option value="10" >동작구</option>
					<option value="11" >서대문구</option>
					<option value="12" >송파구</option>
					<option value="13" >양천구</option>
					<option value="14" >영등포구</option>
					<option value="15" >용산구</option>
					<option value="16" >은평구</option>
					<option value="17" >종로구</option>
					<option value="18" >중구</option>
					<option value="19" >중량구</option>
				</optgroup>
			</select>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><select id="memberPhone1" name="memberPhone1">
				<option value="" >선택</option>
				<optgroup label="휴대전화">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
				</optgroup>
				<optgroup label="지역번호">
					<option value="4">공백</option>
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="7">032</option>
					<option value="8">033</option>
					<option value="9">041</option>
					<option value="10">042</option>
					<option value="11">043</option>
					<option value="12">044</option>
					<option value="13">051</option>
					<option value="14">052</option>
					<option value="15">053</option>
					<option value="16">054</option>
					<option value="17">055</option>
					<option value="18">061</option>
					<option value="19">062</option>
					<option value="20">063</option>
					<option value="21">064</option>
				</optgroup>
			</select>
			-
			<input type="text"  id="memberPhone2" name="memberPhone2" size="5">
			-
			<input type="text"  id="memberPhone3" name="memberPhone3" size="5"></td>
		</tr>
		<tr>
		<td><input type="submit" value="회원가입" id="Regist"> <input type="reset" value="초기화"></td>
		</tr>
	</table>
	&nbsp;<span id="Msg"></span>
	</form>
</body>
</html>