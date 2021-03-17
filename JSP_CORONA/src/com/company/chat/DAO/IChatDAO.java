package com.company.chat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.chat.DTO.Chat;

import DataBaseConnection.DTO.DataBaseConnection;

public class IChatDAO implements ChatDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public IChatDAO() {
		super();
		DataBaseConnection dbConnection = new DataBaseConnection();
		this.conn = dbConnection.dataBaseConnection();
		
	}
	
	// 채팅 로그기록 삽입
	@Override
	public Boolean insert_ChatLog(String id, String message) {
		String SQL= "INSERT INTO Chat_log(id,message) VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, message);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Chat> select_ChatLog() {
		String SQL = " SELECT * FROM Chat_log ";
		SQL += " ORDER BY DATE asc ";
		
		ArrayList<Chat> chatLogList = new ArrayList<Chat>();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Chat chat = new Chat();
				chat.setDate(rs.getString(1));
				chat.setId(rs.getString(2));
				chat.setMessage(rs.getString(3));
				System.out.println(chat.toString());
				chatLogList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return chatLogList;
	}
	
	

}
