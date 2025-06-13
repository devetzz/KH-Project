package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ReservationVO;

public class ReservationDAO {
    // 디생
    // 멤버변수
    private String selectSQL = "SELECT * FROM RESERVATION";
    private String insertSQL = "INSERT INTO RESERVATION VALUES (?,?,?,?)";
    private String updateSQL = "UPDATE RESERVATION SET PHONENUM = ?, USERNAME=?, MOVIENAME = ?, SEATNUM = ? WHERE PHONENUM = ?";
    private String deleteSQL = "DELETE FROM RESERVATION WHERE PHONENUM = ?";

    // 예약 목록 (select *)
    public ArrayList<ReservationVO> selectAll(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ReservationVO> rsvList = new ArrayList<ReservationVO>();
        
        try {
            con = DBUtil.getConnection();
            if(con == null){
                System.out.println("DB 연결이 실패했습니다.");
                return null;
            }
            pstmt = con.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String phoneNum = rs.getString("PHONENUM");
                String userName = rs.getString("USERNAME");
                String movieName = rs.getString("MOVIENAME");
                int seatNum = rs.getInt("SEATNUM");
                ReservationVO reservationVO = new ReservationVO(phoneNum, userName, movieName, seatNum);
                rsvList.add(reservationVO);
            }

        } catch (SQLException e) {
            System.out.println("createStatement 오류 발생");
        } finally {
            DBUtil.dbClose(con, pstmt, rs);
        }
        return rsvList;
    }

    // 예약 등록
    public int insert(ReservationVO reservationVO) {
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
			pstmt.setString(1,reservationVO.getPhoneNum());
			pstmt.setString(2,reservationVO.getUserName());
			pstmt.setString(3,reservationVO.getMovieName());
			pstmt.setInt(4,reservationVO.getSeatNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
    // 예약 수정
    public int update(ReservationVO reservationVO, String findNum) {
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
			pstmt.setString(1, reservationVO.getPhoneNum());
			pstmt.setString(2, reservationVO.getUserName());
			pstmt.setString(3, reservationVO.getMovieName());
			pstmt.setInt(4, reservationVO.getSeatNum());
			pstmt.setString(5, findNum);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
    // 예약 삭제
    public int deleteByPhoneNum(ReservationVO reservationVO) {
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
			pstmt.setString(1, reservationVO.getPhoneNum());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createStatement 오류발생");
		} finally {
			DBUtil.dbClose(con, pstmt);
		}
		return count;
	}
}
