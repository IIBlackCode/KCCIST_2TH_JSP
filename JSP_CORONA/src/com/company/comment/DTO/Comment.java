package com.company.comment.DTO;

public class Comment {
	
	private int comment_id;
	private int board_id;
	private String member_id;
	private String comment;
	private String comment_date;
	
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	@Override
	public String toString() {
		return "Comment [board_id=" + board_id + ", member_id=" + member_id + ", comment=" + comment + ", comment_date="
				+ comment_date + "]";
	}
}
