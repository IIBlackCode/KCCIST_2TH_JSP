package com.corona.board.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.corona.DataBaseConnection;
import com.corona.board.DTO.Board;

public class IBoardDAO extends DataBaseConnection implements BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// DataBase 연결
	public IBoardDAO() {
		try {

			String mariaDB = "org.mariadb.jdbc.Driver";
//			String mysql = "com.mysql.jdbc.Driver";
			String mysql = "com.mysql.cj.jdbc.Driver";

			String dataBaseUrl = "jdbc:mysql://localhost:3306/corona?serverTimezone=UTC";
			String dataBaseId = "root";
			String dataBasePw = "1234";

			Class.forName(mysql);
			conn = DriverManager.getConnection(dataBaseUrl, dataBaseId, dataBasePw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// 게시판
	public ArrayList<Board> select_BoardList() {
		// 1. SQL 작성
		String SQL = "SELECT * FROM board";
		// 2. 데이터를 받을 타입인지 구분
		ArrayList<Board> boardList = new ArrayList<Board>();

		try {
			// 3. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			// 4. DataRow를 DTO에 저장
			while (rs.next()) {
				Board board = new Board();
				board.setBoard_id(rs.getInt(1));
				board.setMember_id(rs.getString(2));
				board.setBoard_title(rs.getString(3));
				board.setBoard_content(rs.getString(4));
				board.setBoard_date(rs.getString(5));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5. DTO리턴
		return boardList;
	}// The end of Method

	@Override
	// 게시글 삽입
	public Boolean insert_BoardWrite(Board board) {
		// 1. SQL 작성
		String SQL = "INSERT INTO board(member_id, board_title, board_content)VALUES(?,?,?)";

		try {
			// 2. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, board.getMember_id());
			pstmt.setString(2, board.getBoard_title());
			pstmt.setString(3, board.getBoard_content());
			rs = pstmt.executeQuery();
			// 3. 결과 리턴
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. 결과 리턴
		return false;
	}// The end of Method

	@Override
	// 게시글 읽기
	public Board select_BoardRead(Board board) {
		// 1. SQL 작성
		String SQL = "SELECT * FROM board WHERE board_id = ?";

		try {
			// 3. SQL 실행 준비
			pstmt = conn.prepareStatement(SQL);
			// 4. ?에 들어갈 데이터 지정
			pstmt.setInt(1, board.getBoard_id());
			// 5. SQL 실행
			rs = pstmt.executeQuery();
			// 5. dto로 반환할 데이터 저장
			board.setBoard_id(rs.getInt(1));
			board.setMember_id(rs.getString(2));
			board.setBoard_title(rs.getString(3));
			board.setBoard_content(rs.getString(4));
			board.setBoard_date(rs.getString(5));
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5. DTO리턴
		return board;
	}

}
