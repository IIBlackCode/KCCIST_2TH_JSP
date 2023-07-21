package com.company.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.member.DAO.IMemberDAO;
import com.company.member.DTO.Member;
import com.mysql.cj.Session;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns= {"/company/Login","/corona/Login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        System.out.println("[LoginController] /Login");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String ipAddress=request.getRemoteAddr();
		System.out.println("클라이언트 IP 주소: "+ipAddress);

		String member_id = request.getParameter("username");
		String member_password = request.getParameter("password");
		System.out.println("member_id : "+member_id);
		System.out.println("member_password : "+member_password);
		
		Member member = new Member();
		member.setMember_id(member_id);
		member.setMember_password(member_password);
		
		/*Dao, Session, PrintWriter Instance 생성*/
		IMemberDAO dao = new IMemberDAO();
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		/*script를 사용하기 위한 PrintWriter 선언*/
		if (dao.select_MemberLogin(member)) {
			
			/*DAO 호출 > select Querry 실행*/
			member = dao.select_Member(member);
			
			/*SESSION에 로그인 정보 추가*/
			session.setAttribute("member", member);
			
			script.println("<script>");
			script.println("alert('로그인 성공')");
			script.println("location.href ='"+request.getContextPath()+"/company/index2.jsp'");
//			script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/Main.jsp'");
			script.println("</script>");
		}else {
			script.println("<script>");
			script.println("alert('로그인 실패')");
			script.println("history.back()");
			script.println("</script>");
		}
	}// The end of Method

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}// The end of Method

}
