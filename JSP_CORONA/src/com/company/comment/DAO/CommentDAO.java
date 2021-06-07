package com.company.comment.DAO;

import java.util.ArrayList;

import com.company.board.DTO.Board;
import com.company.comment.DTO.Comment;

public interface CommentDAO {
	
	public ArrayList<Comment> select_CommentList(int board_id);
	public Boolean insert_Comment(Comment comment);
	

}
