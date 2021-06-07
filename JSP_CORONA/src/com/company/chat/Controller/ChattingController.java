package com.company.chat.Controller;

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

/**
 * Servlet implementation class ChattingController
 */
@WebServlet("/company/Chatting")
public class ChattingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChattingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Session에 저장된 사용자 ID를 가져오기 
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		System.out.println("SESSION : "+member);
		/*script를 사용하기 위한 PrintWriter 선언*/
		PrintWriter script = response.getWriter();
		if (member == null) {
			/*
			 * forward시 기존 url정보가 유지되면서 에러발생
			 */
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Login.jsp");
//			dispatcher.forward(request, response);
			/* 기존 url을 남기지 않아야할 때 redirect 이용 */
			response.sendRedirect(request.getContextPath()+"/company/Login.jsp");
		}else {
			script.println("<script>");
			script.println("alert('session is checked.')");
			script.println("location.href = '"+request.getContextPath()+"/company/Chat/Chatting.jsp'");
			script.println("</script>");
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Chat/chatting.jsp");
			dispatcher.forward(request, response);
			*/
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
