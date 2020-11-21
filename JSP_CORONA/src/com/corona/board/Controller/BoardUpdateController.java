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
@WebServlet(urlPatterns= {"/corona/MainMenu/BoardUpdate","/corona/MainMenu/Board/BoardUpdate"})
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("[BoardUpdateController]");
		Board board = new Board();
		
		//BoardUpdate로부터 Board_id를 받아온다
		String board_id = request.getParameter("Board_id");
		System.out.println("board_id : "+board_id+":"+Integer.parseInt(board_id));
		
		//Board_id를 DTO에 저장
		board.setBoard_id(Integer.parseInt(board_id));
		
		//조회 쿼리 실행
		IBoardDAO dao = new IBoardDAO();
		board = dao.select_BoardRead(board);
		System.out.println("Board_title:"+board.getBoard_title());
		
		request.setAttribute("board", board);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board/BoardUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
