<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Main</title>
<meta name=viewport content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; utf-8">
   	<meta charset="utf-8">
	<link rel="stylesheet" href="../../CSS/MyPages.css">
<script> function fn_spread(id){ 
   var getID = document.getElementById(id); 
   getID.style.display=(getID.style.display=='block') ? 'none' : 'block'; 
} 
</script>


</head>
<body>
	<!-- HEADER -->
	<%@include file="../include/header.jsp"%>
	
<div id="contents-area" class="section">
   <div class="feed">
   <div class= "autor">
      <center><div class = "photo"></div></center>
      <center><div class="name">ID</div></center>
   

   </div>
         

<div id="real-area" class="section">
   <button class="form_jindan_button" onclick="fn_spread('jindanResult');">진단결과</button> 
   <div id="jindanResult" class="jindan" style="display: none;">
      <h1>진단결과
      </h1>
      <p>회원님은 양성입니다.</p>
   </div>
</div>

<div id="footer-area" class="section">

<div class="bar"></div>	
</div>
</body>
</html>