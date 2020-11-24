package com.corona.member.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.corona.member.DTO.Member;

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
	public boolean select_MemberLogin(Member member) {
		System.out.println("select_MemberLogin()");
		String SQL = "SELECT member_password FROM member WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getString(1).equals(member.getMember_password())) {
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
	public boolean insert_member(Member member) {
		System.out.println("insert_member()");
		String SQL = "INSERT INTO member(member_id, Member_password, Member_name, Member_adress, Member_phone, Member_result, Member_selfresult)";
				SQL+= "VALUES(?, ?, ?, ?, ?, ?, ?)";
		//INSERT INTO member values('test','test','test','test','test','test','test','test');
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_password());
			pstmt.setString(3, member.getMember_name());
			pstmt.setString(4, member.getMember_adress());
//			pstmt.setString(5, member.getMember_rank());
			pstmt.setString(5, member.getMember_phone());
			pstmt.setString(6, member.getMember_result());
			pstmt.setString(7, member.getMember_selfresult());
//			rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			System.out.println("Success Join");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	@Override
	public Member select_MemberRank(Member member) {
		String SQL = "SELECT member_rank FROM member WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member.setMember_rank(rs.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}
