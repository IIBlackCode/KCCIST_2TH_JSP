package com.company.board.DAO;

import java.util.ArrayList;

import com.company.board.DTO.Board;
import com.company.board.DTO.Criteria;
import com.company.member.DTO.Member;

public interface BoardDAO {
	//게시판 게시글 리스트 출력
	public ArrayList<Board> select_AdminBoardList();
	//게시글 쓰기
	public Boolean insert_AdminBoard(Board board);
	//게시글 읽기
	public Board select_AdminBoard(Board board);
	//게시글 수정
	public Boolean update_AdminBoard(Board board);
	//게시글 삭제
	public Boolean delete_AdminBoard(Board board);
	//게시판 게시글 리스트 출력
	public ArrayList<Board> select_UserBoardList();
	//사용자 게시글 삭제
	public Boolean update_UserBoardDelete(Board board);
	//관리자 공지사항
	public Board select_AdminNotice();
	//회원탈퇴 게시글 삭제
	public Boolean delete_AdminBoardList(Member member);
	
	public ArrayList<Board> select_ListCriteria(Criteria cri);
	
	
}
