package com.company.member.DTO;

public class Member {
	private String member_id;	
	private String member_password;
	private String member_name;
	private String member_adress;
	private String member_rank;
	private String member_phone;
	private String member_result;
	private String member_selfresult;
	private String member_joindate;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_adress() {
		return member_adress;
	}
	public void setMember_adress(String member_adress) {
		this.member_adress = member_adress;
	}
	public String getMember_rank() {
		return member_rank;
	}
	public void setMember_rank(String member_rank) {
		this.member_rank = member_rank;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_result() {
		return member_result;
	}
	public void setMember_result(String member_result) {
		this.member_result = member_result;
	}
	public String getMember_selfresult() {
		return member_selfresult;
	}
	public void setMember_selfresult(String member_selfresult) {
		this.member_selfresult = member_selfresult;
	}
	public String getMember_joindate() {
		return member_joindate;
	}
	public void setMember_joindate(String member_joindate) {
		this.member_joindate = member_joindate;
	}
	
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_password=" + member_password + ", member_name="
				+ member_name + ", member_adress=" + member_adress + ", member_rank=" + member_rank + ", member_phone="
				+ member_phone + ", member_result=" + member_result + ", member_selfresult=" + member_selfresult
				+ ", member_joindate=" + member_joindate + "]";
	}
	
}
