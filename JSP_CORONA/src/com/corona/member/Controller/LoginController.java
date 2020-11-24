package com.corona.member.Controller;

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

import com.corona.member.DAO.IMemberDAO;
import com.corona.member.DTO.Member;
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
		
		String member_id = request.getParameter("username");
		String member_password = request.getParameter("password");
		System.out.println("member_id : "+member_id);
		System.out.println("member_password : "+member_password);
		
		Member member = new Member();
		member.setMember_id(member_id);
		member.setMember_password(member_password);
		
		/*SESSION에 로그인 정보 추가*/
		HttpSession session = request.getSession();
		session.setAttribute("member_id", member_id);
		
		/*DAO 호출 > select Querry 실행*/
		IMemberDAO dao = new IMemberDAO();
		boolean result = dao.select_MemberLogin(member);
		String member_rank = dao.select_MemberRank(member).getMember_rank();
		session.setAttribute("member_rank", member_rank);
		System.out.println("member_rank : "+member_rank);
		/*script를 사용하기 위한 PrintWriter 선언*/
		PrintWriter script = response.getWriter();
		if (result) {
			script.println("<script>");
			script.println("alert('로그인 성공')");
			script.println("location.href ='"+request.getContextPath()+"/company/index.jsp'");
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
