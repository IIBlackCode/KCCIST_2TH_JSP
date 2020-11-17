package com.corona.member.DAO;

public interface MemberDAO {
	public boolean select_MemberLogin(String userID, String userPassword);
	public boolean insert_member();
	public void delete_member();
	public void update_member();
	public void select_member();
}
