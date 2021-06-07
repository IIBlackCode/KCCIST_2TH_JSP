package com.company.chat.DAO;

import java.util.ArrayList;

import com.company.chat.DTO.Chat;

public interface ChatDAO {
	//로그기록 삽입
	public Boolean insert_ChatLog(String id, String message);
	public ArrayList<Chat> select_ChatLog();
}
