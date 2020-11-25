package com.company.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/company/Logout","/corona/MainMenu/Board/Logout"})
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		/*script를 사용하기 위한 PrintWriter 선언*/
		PrintWriter script = response.getWriter();
		if (session.getAttribute("member_id")!= null) {
			session.invalidate(); // 모든세션정보 삭제
			script.println("<script>");
			script.println("alert('로그아웃 성공')");
//			script.println("location.href = '"+request.getContextPath()+"/corona/Login.jsp'");
			script.println("location.href = '"+request.getContextPath()+"/company/Login.jsp'");
			script.println("</script>");
		}else {
			script.println("<script>");
			script.println("alert('로그아웃 실패')");
			script.println("history.back()");
			script.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
