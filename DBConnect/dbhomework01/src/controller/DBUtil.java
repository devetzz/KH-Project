package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    // DB 연결
    public static Connection getConnection(){
        Properties properties = new Properties();
        Connection con = null;
        try {
            FileInputStream fis = new FileInputStream("dbhomework01/src/config/db.properties");
            properties.load(fis);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String pwd = properties.getProperty("pwd");

            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB 연결 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("["+ e.toString() +"]");
        } catch (SQLException e) {
            System.out.println("["+ e.toString() +"]");
        } catch (IOException e) {
            System.out.println("["+ e.toString() +"]");
        }

        return con;
    }

    // DB 연결 해제
    public static void dbClose(Connection con, PreparedStatement pstmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // DB 연결 해제(오버로딩 매개변수 2개)
    public static void dbClose(Connection con, PreparedStatement pstmt){
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
