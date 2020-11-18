package com.corona.board.DAO;

import java.util.ArrayList;

import com.corona.board.DTO.Board;

public interface BoardDAO {
	public ArrayList<Board> select_BoardList();
}
