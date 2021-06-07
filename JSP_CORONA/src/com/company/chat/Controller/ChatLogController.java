package com.company.chat.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.chat.DAO.IChatDAO;
import com.company.chat.DTO.Chat;

/**
 * Servlet implementation class ChatLogController
 */
@WebServlet("/company/ChatLog")
public class ChatLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatLogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		IChatDAO dao = new IChatDAO();
		
		//Chatting List
		ArrayList<Chat> chatList = dao.select_ChatLog();
		
		request.setAttribute("chatList", chatList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/company/Chat/Log.jsp");
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
