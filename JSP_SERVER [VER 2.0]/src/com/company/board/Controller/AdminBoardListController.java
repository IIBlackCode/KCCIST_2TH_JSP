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

import com.company.board.DAO.IBoardDAO;
import com.company.board.DTO.Board;

/**
 * Servlet implementation class BoardController
 */
@WebServlet(urlPatterns= {"/company/BoardListAdmin","/corona/MainMenu/AdminBoardList"})
public class AdminBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminBoardListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		IBoardDAO dao = new IBoardDAO();
		
		//일반 게시글
		ArrayList<Board> boardList = dao.select_AdminBoardList();
		request.setAttribute("boardList", boardList);
		
		//관리자 공지사항
		Board adminNotice = dao.select_AdminNotice();
		request.setAttribute("adminNotice", adminNotice);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Board/BoardListAdmin.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
