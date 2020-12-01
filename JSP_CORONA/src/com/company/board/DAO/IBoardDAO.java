package com.company.board.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.DataBaseConnection;
import com.company.board.DTO.Board;
import com.company.board.DTO.Criteria;
import com.company.member.DTO.Member;

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

	// 관리자 전용 게시판
	@Override
	public ArrayList<Board> select_AdminBoardList() {
		// 1. SQL 작성
//		String SQL = "SELECT * FROM board ORDER BY board_id DESC";
		String SQL = " SELECT @ROWNUM := @ROWNUM + 1 AS num, T.* ";
		SQL += " FROM board T, (SELECT @ROWNUM:=0)TT ";
//		       SQL+= " WHERE delete_yn = 'N' ";
		SQL += " ORDER BY num DESC; ";
		// 2. 데이터를 받을 타입인지 구분
		ArrayList<Board> boardList = new ArrayList<Board>();

		try {
			// 3. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			// 4. DataRow를 DTO에 저장
			while (rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt(1));
				board.setBoard_id(rs.getInt(2));
				board.setMember_id(rs.getString(3));
				board.setBoard_title(rs.getString(4));
				board.setBoard_content(rs.getString(5));
				board.setBoard_date(rs.getString(6));
				board.setDelete_yn(rs.getString(7));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5. DTO리턴
		return boardList;
	}// The end of Method

	// 게시글 삽입
	@Override
	public Boolean insert_AdminBoard(Board board) {
		// 1. SQL 작성
		String SQL = "INSERT INTO board(member_id, board_title, board_content)VALUES(?,?,?)";
		int result = 0;
		try {
			// 2. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, board.getMember_id());
			pstmt.setString(2, board.getBoard_title());
			pstmt.setString(3, board.getBoard_content());
			result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. 결과 리턴
		return false;
	}// The end of Method

	// 게시글 읽기
	@Override
	public Board select_AdminBoard(Board board) {
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
			if (rs.next()) {
				board.setBoard_id(rs.getInt(1));
				board.setMember_id(rs.getString(2));
				board.setBoard_title(rs.getString(3));
				board.setBoard_content(rs.getString(4));
				board.setBoard_date(rs.getString(5));
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5. DTO리턴
		return board;
	}

	// 게시글 수정
	@Override
	public Boolean update_AdminBoard(Board board) {
		String SQL = "UPDATE board SET board_title = ?, board_content=? WHERE board_id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, board.getBoard_title());
			pstmt.setString(2, board.getBoard_content());
			pstmt.setInt(3, board.getBoard_id());
			// rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			System.out.println("Success Update Board");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 게시글 삭제
	@Override
	public Boolean delete_AdminBoard(Board board) {
		String SQL = "DELETE FROM board WHERE board_id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, board.getBoard_id());
			// rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			System.out.println("Success DELETE Board");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// The end of Method

	// 사용자 게시판
	@Override
	public ArrayList<Board> select_UserBoardList() {
		// 1. SQL 작성
		// String SQL = "SELECT * FROM board WHERE delete_yn = 'N' ORDER BY board_id
		// DESC";
		String SQL = " SELECT @ROWNUM := @ROWNUM + 1 AS num, T.* ";
		SQL += " FROM board T, (SELECT @ROWNUM:=0)TT ";
		SQL += " WHERE delete_yn = 'N' ";
		SQL += " ORDER BY num DESC; ";
		// 2. 데이터를 받을 타입인지 구분
		ArrayList<Board> boardList = new ArrayList<Board>();

		try {
			// 3. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			// 4. DataRow를 DTO에 저장
			while (rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt(1));
				board.setBoard_id(rs.getInt(2));
				board.setMember_id(rs.getString(3));
				board.setBoard_title(rs.getString(4));
				board.setBoard_content(rs.getString(5));
				board.setBoard_date(rs.getString(6));
				System.out.println(board.toString());
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		// 5. DTO리턴
		return boardList;
	}// The end of Method

	// 사용자 게시글 삭제
	@Override
	public Boolean update_UserBoardDelete(Board board) {
		String SQL = "UPDATE board SET delete_yn = 'Y' WHERE board_id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, board.getBoard_id());
			pstmt.executeUpdate();
			System.out.println("Success Update Board");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// The end of Method

	@Override
	public Board select_AdminNotice() {
		// 1. SQL 작성
		String SQL = " SELECT t1.board_id, t1.member_id, t1.board_title, t1.board_content, t1.board_date, t2.member_rank ";
		SQL += " FROM board t1, member t2 ";
		SQL += " WHERE t1.member_id = t2.member_id AND t2.member_rank = \'관리자\' ";
		SQL += " ORDER BY board_id DESC ";
		SQL += " LIMIT 1 ";

		Board board = new Board();
		try {
			// 3. SQL 실행 준비
			pstmt = conn.prepareStatement(SQL);
			// 4. ?에 들어갈 데이터 지정
//			pstmt.setInt(1, board.getBoard_id());
			// 5. SQL 실행
			rs = pstmt.executeQuery();
			// 5. dto로 반환할 데이터 저장
			if (rs.next()) {
				board.setBoard_id(rs.getInt(1));
				board.setMember_id(rs.getString(2));
				board.setBoard_title(rs.getString(3));
				board.setBoard_content(rs.getString(4));
				board.setBoard_date(rs.getString(5));
				System.out.println(board.toString());
				return board;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 5. DTO리턴
		return board;
	}

	// 관리자 전용 게시판
	@Override
	public ArrayList<Board> select_ListCriteria(Criteria cri) {
		// 1. SQL 작성
//			String SQL = "SELECT * FROM board ORDER BY board_id DESC";
		String SQL = " SELECT board_id, member_id, board_title, board_content, board_date ";
		SQL += " FROM board ";
		SQL += " WHERE board_id > 0 ";
		SQL += " ORDER BY board_id DESC, board_date DESC ";
		SQL += " LIMIT " + cri.getPageStart() + "," + cri.getPerPageNum();
		// 2. 데이터를 받을 타입인지 구분
		ArrayList<Board> boardList = new ArrayList<Board>();

		try {
			// 3. SQL 실행
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			// 4. DataRow를 DTO에 저장
			while (rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt(1));
				board.setBoard_id(rs.getInt(2));
				board.setMember_id(rs.getString(3));
				board.setBoard_title(rs.getString(4));
				board.setBoard_content(rs.getString(5));
				board.setBoard_date(rs.getString(6));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5. DTO리턴
		return boardList;
	}// The end of Method

	// 회원탈퇴 게시글 삭제
	@Override
	public Boolean delete_AdminBoardList(Member member) {
		String SQL = "DELETE FROM board WHERE member_id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, member.getMember_id());
			// rs = pstmt.executeQuery();
			pstmt.executeUpdate();
			System.out.println("Success DELETE Board");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// The end of Method
}
