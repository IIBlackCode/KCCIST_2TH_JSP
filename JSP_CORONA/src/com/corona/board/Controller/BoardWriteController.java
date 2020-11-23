package com.corona.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.corona.board.DAO.IBoardDAO;
import com.corona.board.DTO.Board;

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet(urlPatterns= {"/corona/MainMenu/BoardWrite","/corona/MainMenu/Board/BoardWrite"})
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect(request.getContextPath()+"/corona/MainMenu/Board/BoardWrite.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//Session에 저장된 사용자 ID를 가져오기 
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("member_id");
		//BoardWrite.jsp에 입력된 값 가져오기
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		//입력을 잘 받았는지 테스트
		System.out.println("member_id :"+member_id);
		System.out.println("board_title :"+board_title);
		System.out.println("board_content :"+board_content);
		//DTO에 데이터 저장
		Board board = new Board();
		board.setMember_id(member_id);
		board.setBoard_title(board_title);
		board.setBoard_content(board_content);
		//DAO호출 및 script 알람 
		IBoardDAO dao = new IBoardDAO();
		PrintWriter script = response.getWriter();
		
		if(dao.insert_AdminBoard(board)) {
			script.println("<script>");
			script.println("alert('게시글 작성 성공')");
			if (session.getAttribute("member_rank").equals("일반회원")) {
				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
			}else {
				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
			}
			script.println("</script>");
		}else {
			script.println("<script>");
			script.println("alert('게시글 작성 실패')");
			if (session.getAttribute("member_rank").equals("일반회원")) {
				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
			}else {
				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
			}
			script.println("</script>");
		}//The end of if
		
	}//The end of Method [POST]

}
