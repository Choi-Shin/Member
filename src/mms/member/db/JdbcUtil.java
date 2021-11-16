package mms.member.db;

import java.sql.*;

public class JdbcUtil {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "member", "member");
            con.setAutoCommit(false);
            System.out.println("접속 성공");
            return con;
        } catch (SQLException e) {
            System.out.println("접속 실패");
            e.printStackTrace();
        }
        return null;
    }

    public void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(Connection con) {
        try {
            con.commit();
            System.out.println("커밋 완료");
        } catch (SQLException e) {
            System.out.println("커밋 실패");
            e.printStackTrace();
        }
    }

    public void rollback(Connection con) {
        try {
            con.rollback();
            System.out.println("롤백 완료");
        } catch (SQLException e) {
            System.out.println("롤백 실패");
            e.printStackTrace();
        }
    }

}
