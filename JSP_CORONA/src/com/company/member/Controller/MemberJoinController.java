package com.company.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.member.DAO.IMemberDAO;
import com.company.member.DTO.Member;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(urlPatterns={"/company/Member/Join","/corona/Join"})
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinController() {
    	System.out.println("[MemberJoinController]");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("[MemberJoinController]");
	}// The end of Method

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Member member = new Member();
		
		String member_id = request.getParameter("member_id");
		String member_password = request.getParameter("member_password");
		String member_passwordCheck = request.getParameter("member_passwordCheck");
		String member_name = request.getParameter("member_name");
		String member_adress = request.getParameter("member_Adress");
		String member_rank = request.getParameter("member_rank");
		String member_phone = request.getParameter("member_Phone");
		String member_result = request.getParameter("member_result");
		String member_selfresult = request.getParameter("member_selfresult");
		
		System.out.println("member_id :" +member_id);
		System.out.println("member_password :" +member_password);
		System.out.println("member_passwordCheck :" +member_passwordCheck);
		System.out.println("member_name :" +member_name);
		System.out.println("member_adress :" +member_adress);
		System.out.println("member_rank :" +member_rank);
		System.out.println("member_phone :" +member_phone);
		System.out.println("member_result :" +member_result);
		System.out.println("member_selfresult :" +member_selfresult);
		
		String ipAddress=request.getRemoteAddr();
		System.out.println("클라이언트 IP 주소: "+ipAddress);
		
		member.setMember_id(member_id);
		member.setMember_password(member_password);
		member.setMember_name(member_name);
		member.setMember_adress(member_adress);
		member.setMember_rank("일반회원");
		member.setMember_phone(member_phone);
		member.setMember_result("미진단");
		member.setMember_selfresult("미진단");
		member.setIp(ipAddress);
		
		/*SESSION에 로그인 정보 추가*/
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
		/*DAO 호출 > select Querry 실행*/
		IMemberDAO dao = new IMemberDAO();
		
		PrintWriter script = response.getWriter();
		if (dao.insert_member(member)) {
			script.println("<script>");
			script.println("alert('회원가입 성공')");
			script.println("</script>");
			response.sendRedirect(request.getContextPath()+"/company/index.jsp");
		} else {
			script.println("<script>");
			script.println("alert('회원가입 실패')");
			script.println("history.back()");
			script.println("</script>");
		}
	}

}
