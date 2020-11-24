package com.corona.member.DAO;

import com.corona.member.DTO.Member;

public interface MemberDAO {
	public Member select_Member(Member member);
	public boolean select_MemberLogin(Member member);
	public boolean insert_member(Member member);
	public Member select_MemberRank(Member member);
}
