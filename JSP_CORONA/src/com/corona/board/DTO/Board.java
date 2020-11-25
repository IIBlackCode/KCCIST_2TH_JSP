package com.corona.board.DTO;

public class Board {

	private Integer num;
	private Integer board_id;
	private String member_id;
	private String board_title;
	private String board_content;
	private String board_date;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
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
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", board_id=" + board_id + ", member_id=" + member_id + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_date=" + board_date + "]";
	}
}
