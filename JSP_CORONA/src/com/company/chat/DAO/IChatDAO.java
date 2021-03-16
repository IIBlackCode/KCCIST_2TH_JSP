package com.company.chat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	// 체팅 로그기록 삽입
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

}
