package com.company.board.Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class BoardWriteController
 */
@WebServlet(urlPatterns= {"/company/BoardWrite","/company/Board/BoardWrite","/corona/MainMenu/Board/BoardWrite"})
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
//		response.sendRedirect(request.getContextPath()+"/corona/MainMenu/Board/BoardWrite.jsp");
		response.sendRedirect(request.getContextPath()+"/company/Board/BoardWrite.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//Session에 저장된 사용자 ID를 가져오기 
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
//		String member_id = (String) session.getAttribute("member_id");
		//BoardWrite.jsp에 입력된 값 가져오기
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		//DTO에 데이터 저장
		Board board = new Board();
		
		if (member == null) {
			//비회원이 글을 작성 할 경우
			board.setMember_id("비회원");
		}else {
			//회원정보로 글을 작성 할 경우
			board.setMember_id(member.getMember_id());
		}
		board.setBoard_title(board_title);
		board.setBoard_content(board_content);
		
		//DAO호출 및 script 알람 
		IBoardDAO dao = new IBoardDAO();
		PrintWriter script = response.getWriter();
		
		if(dao.insert_AdminBoard(board)) {
			script.println("<script>");
			script.println("alert('게시글 작성 성공')");
			
			if (member == null) {
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListUser'");
			}else {
				if (member.getMember_rank().equals("일반회원")) {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
					script.println("location.href ='"+request.getContextPath()+"/company/BoardListUser'");
				}else {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
					script.println("location.href ='"+request.getContextPath()+"/company/BoardListAdmin'");
				}
			}
			
			script.println("</script>");
		}else {
			script.println("<script>");
			script.println("alert('게시글 작성 실패')");
			if (member.getMember_rank().equals("일반회원")) {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/UserBoardList'");
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListUser'");
			}else {
//				script.println("location.href ='"+request.getContextPath()+"/corona/MainMenu/AdminBoardList'");
				script.println("location.href ='"+request.getContextPath()+"/company/BoardListAdmin'");
			}
			script.println("</script>");
		}//The end of if
		
	}//The end of Method [POST]

}
