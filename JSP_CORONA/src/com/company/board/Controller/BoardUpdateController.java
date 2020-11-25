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
@WebServlet(urlPatterns= {"/company/BoardUpdate","/corona/MainMenu/Board/BoardUpdate"})
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("[BoardUpdateController] doGet");
		Board board = new Board();
		
		//BoardUpdate로부터 Board_id를 받아온다
		String board_id = request.getParameter("Board_id");
		System.out.println("board_id : "+board_id+":"+Integer.parseInt(board_id));
		
		//Board_id를 DTO에 저장
		board.setBoard_id(Integer.parseInt(board_id));
		
		//조회 쿼리 실행
		IBoardDAO dao = new IBoardDAO();
		board = dao.select_AdminBoard(board);
		System.out.println("Board_title:"+board.getBoard_title());
		
		request.setAttribute("board", board);
		//View에 데이터를 넘기기 위해 forward로 페이지를 전환한다.
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board/BoardUpdate.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Board/BoardUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("[BoardUpdateController] doPost");
		
		//페이지에서 입력한 데이터를 받아온다.
		String board_id = request.getParameter("Board_id");
		String board_title = request.getParameter("Board_title");
		String board_content = request.getParameter("Board_content");
		
		System.out.println("Board_id : "+board_id);
		System.out.println("Board_title : "+board_title);
		System.out.println("Board_content : "+board_content);
		
		Board board = new Board();
		board.setBoard_id(Integer.parseInt(board_id));
		board.setBoard_title(board_title);
		board.setBoard_content(board_content);
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		IBoardDAO dao = new IBoardDAO();
		if (dao.update_AdminBoard(board)) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			if (member.getMember_rank().equals("일반회원")) {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListUser'");
			}else {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListAdmin'");
			}
			script.println("</script>");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board.jsp");
//			dispatcher.forward(request, response);
			
//			response.sendRedirect(request.getContextPath()+"/corona/MainMenu/BoardList");
			
		}else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			if (session.getAttribute("member_rank").equals("일반회원")) {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListUser'");
			}else {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListAdmin'");
			}
			script.println("</script>");
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/corona/MainMenu/Board.jsp");
//			dispatcher.forward(request, response);
			
//			response.sendRedirect(request.getContextPath()+"/corona/MainMenu/BoardList");
		}
		
	}

}
