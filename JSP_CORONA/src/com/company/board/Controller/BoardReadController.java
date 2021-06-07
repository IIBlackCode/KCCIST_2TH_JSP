package com.company.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.board.DAO.IBoardDAO;
import com.company.board.DTO.Board;
import com.company.comment.DAO.ICommentDAO;
import com.company.comment.DTO.Comment;
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
		
		Board board = new Board();
		String board_id = request.getParameter("Board_id");
		
		if (board_id.substring(0,1).equals("v")) {
			System.out.println("Ver 1.0");
			//게시판 페이지로부터 게시글 아이디를 가져온다. String > int 전환
			board.setBoard_id(Integer.parseInt(board_id.substring(5)));
			System.out.println(board.toString());
			
			//Select Board 쿼리
			IBoardDAO boardDao = new IBoardDAO();
			board = boardDao.select_AdminBoard(board);
			System.out.println(board.toString());
			
			//Select Comment 쿼리
			ICommentDAO commentDao = new ICommentDAO();
			ArrayList<Comment> commentList = new ArrayList<Comment>();
			commentList = commentDao.select_CommentList(Integer.parseInt(board_id.substring(5)));
			
			request.setAttribute("board", board);
			request.setAttribute("commentList", commentList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board/BoardRead.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("Ver 2.0");
			//게시판 페이지로부터 게시글 아이디를 가져온다. String > int 전환
			board.setBoard_id(Integer.parseInt(board_id));
			System.out.println(board.toString());
			
			//Select Board 쿼리
			IBoardDAO boardDao = new IBoardDAO();
			board = boardDao.select_AdminBoard(board);
			System.out.println(board.toString());
			
			//Select Comment 쿼리
			ICommentDAO commentDao = new ICommentDAO();
			ArrayList<Comment> commentList = new ArrayList<Comment>();
			commentList = commentDao.select_CommentList(Integer.parseInt(board_id));
			
			request.setAttribute("board", board);
			request.setAttribute("commentList", commentList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Board/BoardRead.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
