package com.company.chat.DAO;

public interface ChatDAO {
	//체팅 로그기록 입력
	public Boolean insert_ChatLog(String id, String message);
}
