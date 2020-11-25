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
@WebServlet(urlPatterns= {"/company/BoardListUser","/corona/MainMenu/UserBoardList"})
public class UserBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserBoardListController() {
        super();
        System.out.println("[BoardListController] /BoardList");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		IBoardDAO dao = new IBoardDAO();
		
		//일반 게시글
		ArrayList<Board> boardList = dao.select_UserBoardList();
		request.setAttribute("boardList", boardList);
		
		//관리자 공지사항
		Board adminNotice = dao.select_AdminNotice();
		System.out.println("adminNotice : "+adminNotice.getBoard_id());
		System.out.println("adminNotice : "+adminNotice.getBoard_title());
		System.out.println("adminNotice : "+adminNotice.getBoard_date());
		request.setAttribute("adminNotice", adminNotice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Board/BoardListUser.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
