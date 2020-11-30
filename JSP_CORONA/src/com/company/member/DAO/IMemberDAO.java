package com.company.member.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.member.DTO.Member;

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
	}// The end of Method
	
	@Override
	public ArrayList<Member> select_MemberList() {
		System.out.println("select_MemberList()");
		String SQL = "SELECT * FROM member";
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getString(1));
				member.setMember_password(rs.getString(2));
				member.setMember_name(rs.getString(3));
				member.setMember_adress(rs.getString(4));
				member.setMember_rank(rs.getString(5));
				member.setMember_phone(rs.getString(6));
				member.setMember_result(rs.getString(7));
				member.setMember_selfresult(rs.getString(8));
				member.setMember_joindate(rs.getString(9));
				member.setDelete_yn(rs.getString(10));
				memberList.add(member);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return memberList;
	}//The end of Method

	@Override
	public Member select_Member(Member member) {
		System.out.println("select_Member()");
		String SQL = "SELECT * FROM member WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setMember_id(rs.getString(1));
				member.setMember_password(rs.getString(2));
				member.setMember_name(rs.getString(3));
				member.setMember_adress(rs.getString(4));
				member.setMember_rank(rs.getString(5));
				member.setMember_phone(rs.getString(6));
				member.setMember_result(rs.getString(7));
				member.setMember_selfresult(rs.getString(8));
				if (rs.getString(2).equals(member.getMember_password())) {
					System.out.println("Success Login");
					return member;
				}else {
					System.out.println("Fail Login");
					return null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return member;
	}// The end of Method

	@Override
	public boolean select_MemberLogin(Member member) {
		System.out.println("select_MemberLogin() : "+member.toString());
		String password = member.getMember_password();
		String SQL = "SELECT member_password FROM member WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getString(1).equals(member.getMember_password())) {
					System.out.println("Success Login"+member.toString());
					return true;
				}else {
					System.out.println("Fail Login"+member.toString());
					return false;
				}
			}//The end of if
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}// The end of Method

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
	}// The end of Method

	@Override
	public boolean update_member(Member member) {
		System.out.println("update_member() : " + member.toString());
		String SQL = " UPDATE member ";
			   SQL+= " SET Member_password = ?, Member_adress = ?, Member_phone = ? ";
			   SQL+= " WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_password());
			pstmt.setString(2, member.getMember_adress());
			pstmt.setString(3, member.getMember_phone());
			pstmt.setString(4, member.getMember_id());
//			rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			System.out.println("Success Update");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}// The end of Method
	
	@Override
	public boolean delete_member(Member member) {
		System.out.println("delete_member()");
		String SQL = "DELETE FROM member WHERE member_id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
//			rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			System.out.println("Success Delete");
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
	}// The end of Method
	
	@Override
	public boolean update_UserMemberDelete(Member member) {
		System.out.println("update_UserMemberDelete() : " + member.toString());
		String SQL = " UPDATE member ";
			   SQL+= " SET member_password ='!@#$' ,delete_yn = 'Y' ";
			   SQL+= " WHERE member_id = ? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, member.getMember_id());
			int result = pstmt.executeUpdate();
			System.out.println("Success Update MemberDelete");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}// The end of Method
}
