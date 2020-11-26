package com.company.member.DAO;

import java.util.ArrayList;

import com.company.member.DTO.Member;

public interface MemberDAO {
	public ArrayList<Member> select_MemberList();
	public Member select_Member(Member member);
	public boolean select_MemberLogin(Member member);
	public boolean insert_member(Member member);
	public boolean update_member(Member member);
	public boolean delete_member(Member member);
	public Member select_MemberRank(Member member);
}
