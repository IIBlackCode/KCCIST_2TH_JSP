package com.company.comment.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.comment.DAO.ICommentDAO;

/**
 * Servlet implementation class CommentListReadController
 */
@WebServlet(urlPatterns= {"/company/CommentListReadController","/corona/MainMenu/CommentListReadController"})
public class CommentListReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentListReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		ICommentDAO dao = new ICommentDAO();

		//댓글 리스트
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
