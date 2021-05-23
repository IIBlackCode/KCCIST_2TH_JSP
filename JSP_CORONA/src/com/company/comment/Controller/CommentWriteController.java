package com.company.comment.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.board.DTO.Board;
import com.company.comment.DAO.CommentDAO;
import com.company.comment.DAO.ICommentDAO;
import com.company.comment.DTO.Comment;
import com.company.member.DTO.Member;

/**
 * Servlet implementation class CommentWriteController
 */
@WebServlet("/company/CommentWrite")
public class CommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentWriteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		// BoardRead.jsp에 입력된 값 가져오기
		// #1. member Session에 저장된 사용자 ID를 가져오기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		// #2. board_id
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		// #3. comment_content
		String comment_content = request.getParameter("comment_content");

		// DTO에 데이터 저장
		Comment comment = new Comment();

		// #1. member
		/* session이 null일 경우 아이디를 "비회원"으로 지정 */
		if (member == null) {
			// 비회원이 글을 작성 할 경우
			comment.setMember_id("비회원");
		} else {
			// 회원정보로 글을 작성 할 경우
			comment.setMember_id(member.getMember_id());
		}

		// #2. board_id
		comment.setBoard_id(board_id);
		// #3. comment_content
		comment.setComment(comment_content);

		System.out.println("member : " + comment.getMember_id());
		System.out.println("board_id : " + comment.getBoard_id());
		System.out.println("comment_content : " + comment.getComment());

		ICommentDAO dao = new ICommentDAO();
		PrintWriter script = response.getWriter();

		// DAO호출 및 script 알람
		if (dao.insert_Comment(comment)) {
			/*
			script.println("<script>");
			script.println("alert('댓글 입력 성공')");
			script.println("location.href ='"+request.getContextPath()+"/company/BoardRead?Board_id='"+request.getParameter("board_id"));
			script.println("lhistory.back()");
			script.println("</script>");
			*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/company/BoardRead?Board_id="+board_id);
			dispatcher.forward(request, response);
			
		}else {
			script.println("<script>");
			script.println("alert('댓글 입력 실패')");
//			script.println("location.href ='"+request.getContextPath()+"/company/BoardRead?Board_id='"+board_id);
			script.println("</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		doGet(request, response);

	}

}
