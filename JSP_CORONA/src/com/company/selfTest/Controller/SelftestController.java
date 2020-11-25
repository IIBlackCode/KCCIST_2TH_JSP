package com.company.selfTest.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.member.DTO.Member;
import com.company.selfTest.DAO.ISelfTestDAO;
import com.company.예시.DAO.ITestDAO;

//MainManu/SelfTest
@WebServlet(urlPatterns={"/company/SelfTest","/corona/MainMenu/SelfTest"})
public class SelftestController extends HttpServlet {
   

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      response.setContentType("text/html;charset=utf-8");
      PrintWriter pw = response.getWriter();
//      session.setAttribute("member_id", member_id);
      HttpSession session = request.getSession();
      String member_id = (String) session.getAttribute("member_id");
      
      String question1 = request.getParameter("question1");
      String question2 = request.getParameter("question2");
      String question3 = request.getParameter("question3");
      String question4 = request.getParameter("question4");
      String question5 = request.getParameter("question5");
      String question6 = request.getParameter("question6");
      int count=0;
      String [] check = {question1,question2,question3,question4,question5,question6};
      
      for (int i = 0; i < check.length; i++) {
         if (check[i].equals("Y")) {
            count++;
         }
      }
      ISelfTestDAO dao = new ISelfTestDAO();
      Member member = new Member();
      PrintWriter script = response.getWriter();
      if (count>3) {
         System.out.println("당신은 확진자");
         member.setMember_selfresult("양성");
         member.setMember_id(member_id);
         dao.update_memberSelfTastResult(member);
         
         script.println("<script>");
         script.println("alert('당신은 확진자!!병원을 예약하세요')");
         script.println("location.href ='"+request.getContextPath()+"/company/index.jsp'");
         script.println("</script>");
      }else {
         System.out.println("당신은 정상인");
         member.setMember_selfresult("음성");
         member.setMember_id(member_id);
         dao.update_memberSelfTastResult(member);
         
         script.println("<script>");
         script.println("alert('음성이네요. 안심하세요')");
         script.println("location.href ='"+request.getContextPath()+"/company/index.jsp'");
         script.println("</script>");
      }

      
////      forward : url주소 변경 X
//      RequestDispatcher dispatcher = request.getRequestDispatcher("corona/Main.jsp");
//      dispatcher.forward(request, response);
////      redirect : url주소 변경 o
//      response.sendRedirect("/corona/Main.html");
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
