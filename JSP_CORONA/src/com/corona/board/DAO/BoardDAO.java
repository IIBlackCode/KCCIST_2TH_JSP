package com.corona.board.DAO;

import java.util.ArrayList;

import com.corona.board.DTO.Board;

public interface BoardDAO {
	//게시판 게시글 리스트 출력
	public ArrayList<Board> select_BoardList();
	//게시글 쓰기
	public Boolean insert_BoardWrite(Board board);
	//게시글 읽기
	public Board select_BoardRead(Board board);
}
