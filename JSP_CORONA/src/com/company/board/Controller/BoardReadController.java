package com.company.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.board.DAO.IBoardDAO;
import com.company.board.DTO.Board;
import com.company.member.DTO.Member;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet(urlPatterns= {"/company/BoardRead","/corona/MainMenu/Board/BoardRead"})
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
		System.out.println("[BoardReadController] doGet");
		
		//게시판 페이지로부터 게시글 아이디를 가져온다. String > int 전환
		Board board = new Board();
		String board_id = request.getParameter("Board_id");
		board.setBoard_id(Integer.parseInt(board_id));
		System.out.println(board.toString());
		
		//Select 쿼리
		IBoardDAO dao = new IBoardDAO();
		board = dao.select_AdminBoard(board);
		System.out.println(board.toString());
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Board/BoardRead.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
