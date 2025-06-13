package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ReviewVO;

public class ReviewDAO {
    // 디생
    // 멤버변수
    private String selectSQL = "SELECT * FROM REVIEW";
    private String insertSQL = "INSERT INTO REVIEW VALUES (REVIEW_SEQ.NEXTVAL, ?, ?, ?)";
    private String updateSQL = "UPDATE REVIEW SET MOVIENAME = ?, REVIEWRATE = ?, REVIEW_CONTENT = ? WHERE REVIEWNUM = ?";
    private String deleteSQL = "DELETE FROM REVIEW WHERE REVIEWNUM = ?";

    // 리뷰 목록 (select *)
    public ArrayList<ReviewVO> selectAll(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ReviewVO> rvList = new ArrayList<ReviewVO>();
        
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결이 실패했습니다.");
                return null;
            }
            pstmt = con.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();

            while(rs.next()){
				int reviewNum = rs.getInt("REVIEWNUM");
                String movieName = rs.getString("MOVIENAME");
                double reviewRate = rs.getDouble("REVIEWRATE");
                String reviewContent = rs.getString("REVIEW_CONTENT");
                ReviewVO reviewVO = new ReviewVO(reviewNum, movieName, reviewRate, reviewContent);
                rvList.add(reviewVO);
            }

        } catch (SQLException e) {
            System.out.println("createStatement 오류 발생");
        } finally {
            DBUtil.dbClose(con, pstmt, rs);
        }
        return rvList;
    }

    // 리뷰 등록
    public int insert(ReviewVO reviewVO) {
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
			pstmt.setString(1,reviewVO.getMovieName());
			pstmt.setDouble(2,reviewVO.getReviewRate());
			pstmt.setString(3,reviewVO.getComment());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
    // 리뷰 수정
    public int update(ReviewVO reviewVO) {
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
			pstmt.setString(1, reviewVO.getMovieName());
			pstmt.setDouble(2, reviewVO.getReviewRate());
			pstmt.setString(3, reviewVO.getComment());
			pstmt.setInt(4, reviewVO.getReviewNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
    // 리뷰 삭제
    public int deleteByReviewNum(ReviewVO reviewVO) {
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
			pstmt.setInt(1, reviewVO.getReviewNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
}
