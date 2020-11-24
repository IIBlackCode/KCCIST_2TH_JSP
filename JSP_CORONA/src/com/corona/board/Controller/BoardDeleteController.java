package com.corona.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.corona.board.DAO.IBoardDAO;
import com.corona.board.DTO.Board;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet(urlPatterns= {"/corona/MainMenu/BoardDelete","/corona/MainMenu/Board/BoardDelete"})
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("[BoardDeleteController] doGet");
		Board board = new Board();
		
		//BoardUpdate로부터 Board_id를 받아온다
		String board_id = request.getParameter("Board_id");
		System.out.println("board_id : "+board_id+":"+Integer.parseInt(board_id));
		
		//Board_id를 DTO에 저장
		board.setBoard_id(Integer.parseInt(board_id));
		
		//삭제 쿼리 실행
		IBoardDAO dao = new IBoardDAO();
		PrintWriter script = response.getWriter();
		
		HttpSession session = request.getSession();
		
		
		if (session.getAttribute("member_rank").equals("일반회원")) {
			dao.update_UserBoardDelete(board);
			script.println("<script>");
			script.println("alert('게시글 삭제[일반유저] 성공')");
			script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
			script.println("</script>");
		}else {
			dao.delete_AdminBoard(board);
			script.println("<script>");
			script.println("alert('게시글 삭제[관리자] 실패')");
			script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
			script.println("</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("[BoardDeleteController] doPost");
	}
}
