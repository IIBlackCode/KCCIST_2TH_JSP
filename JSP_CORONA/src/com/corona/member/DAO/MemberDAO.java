package com.corona.member.DAO;

import com.corona.member.DTO.Member;

public interface MemberDAO {
	public boolean select_MemberLogin(String userID, String userPassword);
	public boolean insert_member(Member member);
	public void delete_member(Member member);
	public void update_member(Member member);
	public void select_member(Member member);
}
