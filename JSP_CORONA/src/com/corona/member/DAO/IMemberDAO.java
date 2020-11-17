package com.corona.member.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IMemberDAO implements MemberDAO{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public IMemberDAO() {
		try {
			
			String mariaDB = "org.mariadb.jdbc.Driver";
//			String mysql = "com.mysql.jdbc.Driver";
			String mysql = "com.mysql.cj.jdbc.Driver";
			
			String dataBaseUrl = "jdbc:mysql://localhost:3306/corona?serverTimezone=UTC";
			String dataBaseId = "root";
			String dataBasePw = "1234";
			
			Class.forName(mysql);
			conn = DriverManager.getConnection(dataBaseUrl,dataBaseId,dataBasePw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean select_MemberLogin(String member_id, String member_password) {
		System.out.println("select_MemberLogin()");
		String SQL = "SELECT member_password FROM member WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getString(1).equals(member_password)) {
					System.out.println("Success Login");
					return true;
				}else {
					System.out.println("Fail Login");
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean insert_member() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete_member() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update_member() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select_member() {
		// TODO Auto-generated method stub
		
	}
	
}
