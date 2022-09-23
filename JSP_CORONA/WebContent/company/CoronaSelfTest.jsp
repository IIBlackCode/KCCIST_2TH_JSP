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

<meta http-equiv="Content-Type" content="text/html; utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=0" />
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
   <div id="heading">
      <h1>SelfTest<h1>
   </div>

   <!-- Main -->
   <section id="main" class="wrapper">
      <div class="inner">
         <div class="content">
            <header>
               <h2>코로나 19 자가진단 설문 (COVID-19 Self Check)</h2>
            </header>
            
            <!-- SelfTest Form -->
            <form action=SelfTest method="get">
               <tr>
            <h2>아래 6가지 질문들은 가장 범용적으로 사용되는 코로나 19 자가진단 질문들입니다. 이들 중 하나라도 '예'
               답변이 있으면 좀 더 깊이있는 진단이 필요할 수 있습니다.</h2>
         </tr>

         <table border="0">
            <div class="abroad">
               <tr>
                  <td>최근 14일 이내 해외국가를 방문한 적이 있는 가족(또는 동거인)이 있습니까?</td>
               </tr>

               <tr>
                  <td>Do you live with a family member(or a domestic partner)
                     who visited foreign countries within the 14 days?</td>
               </tr>
                  <tr>
                     <td>
                     <input type="radio" id="question1" name="question1" value="Y">
                     <label for="question1">예(YES)</label>
                     <input type="radio" id="question10" name="question1" value="N">
                     <label for="question10">아니오(NO)</label>
                     </td>
                  </tr>
            
            </div>
            <div class="touch">
               <tr>

                  <td>최근 14일 이내 확진환자와 접촉한 적이 있습니까?</td>
               </tr>
               <tr>
                  <td>Have you had contact with a confirmed COVID-19 patient
                     within the last 14 days?</td>
               </tr>
               <tr>
                     <td>
                     <input type="radio" id="question2" name="question2" value="Y">
                     <label for="question2">예(YES)</label>
                     <input type="radio" id="question20" name="question2" value="N">
                     <label for="question20">아니오(NO)</label>
                     </td>
                  </tr>
            </div>

            <div class="visit">
               <tr>
                  <td>최근 14일 이내 국내 집단 발생 지역 및 시설을 방문한 적이 있습니까?</td>
               </tr>
               <tr>
                  <td>Did you visit any regional districsts or failities within
                     Korea where mass outbreaks of the COVID-19 occurred within the
                     last 14 days?</td>
               </tr>
               <tr>
                     <td>
                     <input type="radio" id="question3" name="question3" value="Y">
                     <label for="question3">예(YES)</label>
                     <input type="radio" id="question30" name="question3" value="N">
                     <label for="question30">아니오(NO)</label>
                     </td>
                  </tr>
            </div>

            <div class="callTouch">
               <tr>

                  <td>질병관리본부로부터 귀하가 신종 코로나 바이러스 감염 확진자(또는 접촉자)와 접촉한 사실이 있다는 연락을
                     받으신 적이 있습니까?</td>
               </tr>
               <tr>
                  <td>Have you ever been contacted by the Korea Centers for
                     Disease Control and Prevention to report that you have contacted
                     a confirmed COVID-19 patient (or contact person)?</td>
               </tr>
               <tr>
                     <td>
                     <input type="radio" id="question4" name="question4" value="Y">
                     <label for="question4">예(YES)</label>
                     <input type="radio" id="question40" name="question4" value="N">
                     <label for="question40">아니오(NO)</label>
                     </td>
                  </tr>
            </div>
            <div class="symptom">
               <tr>
                  <td>현재 발열, 호흡기증상(기침, 호흡곤란, 폐렴), 인후통, 미각이나 후각 상실 등의 증상이 있습니까?</td>
               </tr>
               <tr>
                  <td>Do you currently have fever, respiratory symtom(cough,
                     breathing difficulties, pneumonia), sore throat, or loss of taste
                     or smell?</td>
               </tr>
               <tr>
                     <td>
                     <input type="radio" id="question5" name="question5" value="Y">
                     <label for="question5">예(YES)</label>
                     <input type="radio" id="question50" name="question5" value="N">
                     <label for="question50">아니오(NO)</label>
                     </td>
                  </tr>
            </div>
            <div class="tfQ">
               <tr>
                  <td>위 질문들에 거짓없이 사실대로 답변하셨습니까?</td>
               </tr>
               <tr>
                  <td>Did you answer the above questions without falsehood?</td>
               </tr>
               <tr>
                     <td>
                     <input type="radio" id="question6" name="question6" value="Y">
                     <label for="question6">예(YES)</label>
                     <input type="radio" id="question60" name="question6" value="N">
                     <label for="question60">아니오(NO)</label>
                     </td>
                  </tr>
            </div>

            <tr>
               <td colspan="2"><input type="submit" value="등록" id="Register"
                  onclick="submit()"><input type="reset" value="초기화">
               </td>
            </tr>
         </table>
         &nbsp;&nbsp;<span id="Msg"></span>
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