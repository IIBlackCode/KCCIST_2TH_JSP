package com.corona.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corona.board.DAO.IBoardDAO;
import com.corona.board.DTO.Board;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet(urlPatterns= {"/corona/MainMenu/BoardRead","/corona/MainMenu/Board/BoardRead"})
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		Board board = new Board();
		String board_id = request.getParameter("Board_id");
		System.out.println("board_id : "+board_id+":"+Integer.parseInt(board_id));
		board.setBoard_id(Integer.parseInt(board_id));
		
		IBoardDAO dao = new IBoardDAO();
		board = dao.select_BoardRead(board);
		System.out.println("Board_title:"+board.getBoard_title());
		
		
		request.setAttribute("board", board);
		request.setAttribute("Board_title", board.getBoard_title());
		request.setAttribute("Board_content", board.getBoard_content());
		
		/*script를 사용하기 위한 PrintWriter 선언*/
//		PrintWriter script = response.getWriter();
//		script.println("<script>");
//		script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/Board/BoardRead.jsp");
//		script.println("</script>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board/BoardRead.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect(request.getContextPath()+"/corona/MainMenu/Board/BoardRead.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
