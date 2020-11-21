package com.corona.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corona.board.DAO.IBoardDAO;
import com.corona.board.DTO.Board;

/**
 * Servlet implementation class BoardController
 */
@WebServlet(urlPatterns= {"/BoardList","/corona/MainMenu/BoardList"})
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
        System.out.println("[BoardListController] /BoardList");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		IBoardDAO dao = new IBoardDAO();
		ArrayList<Board> boardList = dao.select_BoardList();
		for (int i = 0; i < dao.select_BoardList().size(); i++) {
			System.out.println("getBoard_id :"+dao.select_BoardList().get(i).getBoard_id());
			System.out.println("getBoard_title :"+dao.select_BoardList().get(i).getBoard_title());
			System.out.println("getBoard_content :"+dao.select_BoardList().get(i).getBoard_content());
			System.out.println("getMember_id :"+dao.select_BoardList().get(i).getMember_id());
		}
		
//		response.sendRedirect(request.getContextPath()+"/corona/MainMenu/Board.jsp");
		request.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board.jsp");
		dispatcher.forward(request, response);
		
		/*script를 사용하기 위한 PrintWriter 선언*/
//		PrintWriter script = response.getWriter();
//		script.println("<script>");
//		script.println("alert('로그인 성공')");
//		script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/Board.jsp'");
//		script.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
