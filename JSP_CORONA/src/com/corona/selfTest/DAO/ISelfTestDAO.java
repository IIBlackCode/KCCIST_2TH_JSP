package com.corona.selfTest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.corona.member.DTO.Member;

public class ISelfTestDAO implements SelfTestDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ISelfTestDAO() {

		try {

			String mariaDB = "org.mariadb.jdbc.Driver";
			String mysql = "com.mysql.jdbc.Driver";

			String dataBaseUrl = "jdbc:mysql://localhost:3306/corona?serverTimezone=UTC";
			String dataBaseId = "root";
			String dataBasePw = "1234";
 
			Class.forName(mysql); 
			conn = DriverManager.getConnection(dataBaseUrl, dataBaseId, dataBasePw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update_memberSelfTastResult(Member member) {
		System.out.println("update_memberSelfTastResult()");
		String SQL = "update member set member_selfresult =? where member_id = ?";
		// INSERT INTO member
		// values('test','test','test','test','test','test','test','test');
		try {
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, member.getMember_selfresult());
			pstmt.setString(2, member.getMember_id());
			// rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			System.out.println("Success Join");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

		// TODO Auto-generated method stub

	}

}
