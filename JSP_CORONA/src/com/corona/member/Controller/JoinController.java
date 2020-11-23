package com.corona.member.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corona.member.DAO.IMemberDAO;
import com.corona.member.DTO.Member;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(urlPatterns={"/Join","/corona/Join"})
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
    	System.out.println("[JoinController]");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		member.setMember_id(member_id);
		member.setMember_password(member_password);
		member.setMember_name(member_name);
		member.setMember_adress(member_adress);
		member.setMember_phone(member_phone);
		member.setMember_result(member_result);
		member.setMember_selfresult(member_selfresult);
		
		/*DAO 호출 > select Querry 실행*/
		IMemberDAO dao = new IMemberDAO();
		boolean result = dao.insert_member(member);
		
		/*script를 사용하기 위한 PrintWriter 선언*/
		PrintWriter script = response.getWriter();
		if (result) {
			script.println("<script>");
			script.println("alert('회원가입 성공')");
			script.println("location.href ='"+request.getContextPath()+"/corona/Login.jsp'");
			script.println("</script>");
		} else {
			script.println("<script>");
			script.println("alert('회원가입 실패')");
			script.println("history.back()");
			script.println("</script>");
		}
		
	}// The end of Method

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
