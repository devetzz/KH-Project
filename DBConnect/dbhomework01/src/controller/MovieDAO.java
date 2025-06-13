package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MovieVO;

public class MovieDAO {
    // 디생
    // 멤버변수
    private String selectSQL = "SELECT MOVIENUM, MOVIENAME, TO_CHAR(RELEASEDATE, 'YYYY-MM-DD') RELEASEDATE, RESERVATIONCOUNT FROM MOVIE";
    private String insertSQL = "INSERT INTO MOVIE VALUES (MOVIE_SEQ.NEXTVAL, ?, ?, 0)";
    private String updateSQL = "UPDATE MOVIE SET MOVIENAME = ?, RELEASEDATE = ? WHERE MOVIENUM = ?";
    private String deleteSQL = "DELETE FROM MOVIE WHERE MOVIENUM = ?";
	private String updateRsvCountSQL = "UPDATE MOVIE SET RESERVATIONCOUNT = ? WHERE MOVIENUM = ?";



    // 영화 목록 (select *)
    public ArrayList<MovieVO> selectAll(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<MovieVO> mvList = new ArrayList<MovieVO>();
        
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결이 실패했습니다.");
                return null;
            }
            pstmt = con.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int movieNum = rs.getInt("MOVIENUM");
                String movieName = rs.getString("MOVIENAME");
                String releaseDate = rs.getString("RELEASEDATE");
                int reservationCount = rs.getInt("RESERVATIONCOUNT");
                MovieVO movieVO = new MovieVO(movieNum, movieName, releaseDate, reservationCount);
                mvList.add(movieVO);
            }

        } catch (SQLException e) {
            System.out.println("createStatement 오류 발생");
        } finally {
            DBUtil.dbClose(con, pstmt, rs);
        }
        return mvList;
    }

    // 영화 등록
    public int insert(MovieVO movieVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			if (con == null) {
				System.out.println("DB 연결이 실패했습니다.");
				return -1;
			}
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1,movieVO.getMovieName());
			pstmt.setString(2,movieVO.getReleaseDate());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
    // 영화 수정
    public int update(MovieVO movieVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			if (con == null) {
				System.out.println("DB 연결이 실패했습니다.");
				return -1;
			}
			pstmt = con.prepareStatement(updateSQL);
			pstmt.setString(1, movieVO.getMovieName());
			pstmt.setString(2, movieVO.getReleaseDate());
			pstmt.setInt(3, movieVO.getMovieNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
    // 영화 삭제
    public int deleteByMovieNum(MovieVO movieVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			if (con == null) {
				System.out.println("DB 연결이 실패했습니다.");
				return -1;
			}
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setInt(1, movieVO.getMovieNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}

	// 영화 예약 카운트 수정
    public int updateReservationCount(MovieVO movieVO, int rsvCount) {
		// private String updateRsvCountSQL = "UPDATE MOVIE SET RESERVATIONCOUNT = ? WHERE MOVIENUM = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			if (con == null) {
				System.out.println("DB 연결이 실패했습니다.");
				return -1;
			}
			pstmt = con.prepareStatement(updateRsvCountSQL);
			pstmt.setInt(1, rsvCount);
			pstmt.setInt(2, movieVO.getMovieNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}

}
