package com.company.comment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.board.DTO.Board;
import com.company.comment.DTO.Comment;

import DataBaseConnection.DTO.DataBaseConnection;

public class ICommentDAO implements CommentDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	public ICommentDAO() {
		super();
		DataBaseConnection dbConnection = new DataBaseConnection();
		this.conn = dbConnection.dataBaseConnection();
	}
	
	//댓글 리스트 불러오기
	@Override
	public ArrayList<Comment> select_CommentList(int board_id) {
		// 1. SQL
		//SELECT board_id, member_id, comment, comment_date FROM comment WHERE board_id = 10;
		String SQL = " SELECT board_id, member_id, comment, comment_date FROM comment WHERE board_id = ? ";
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		try {
			// 2. SQL Querry 실행
			pstmt = conn.prepareStatement(SQL);
			// 3. ?에 들어갈 데이터 지정
			pstmt.setInt(1, board_id);
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			// 5. SQL에서 뽑은 데이터 ArrayList에 저장
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setBoard_id(rs.getInt(1));
				comment.setMember_id(rs.getString(2));
				comment.setComment(rs.getString(3));
				comment.setComment_date(rs.getString(4));
				commentList.add(comment);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return commentList;
	}
	
	//댓글 입력
	@Override
	public Boolean insert_Comment(Comment comment) {
		// 1. SQL 작성
		//INSERT INTO comment(board_id,member_id,`comment`)VALUES(1,'test','test comment');
		String SQL = " INSERT INTO comment(board_id, member_id, comment)VALUES(?,?,?) ";
		Boolean result = false;
		try {
			// 2. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, comment.getBoard_id());
			pstmt.setString(2, comment.getMember_id());
			pstmt.setString(3, comment.getComment());
			if (pstmt.executeUpdate() == 0) {
				result =  false;
			} else {
				result =  true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. 결과 리턴
		return result;
	}// The end of Method

}// The end of Class
