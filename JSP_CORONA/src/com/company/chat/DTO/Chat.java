package com.company.chat.DTO;

public class Chat {
	private String date;
	private String id;
	private String message;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Chat [date=" + date + ", id=" + id + ", message=" + message + "]";
	}
	
}
