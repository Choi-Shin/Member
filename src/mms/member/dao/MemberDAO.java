package mms.member.dao;

import mms.member.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public MemberDAO(Connection con) {
        this.con = con;
    }

    public int insertNewMember(Member newMember) {
        int result = 0;
        String query = "INSERT INTO MEMBER VALUES (member_id_seq.nextval, ?, ?, ?, ?, ?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newMember.getName());
            pstmt.setString(2, newMember.getAddr());
            pstmt.setString(3, newMember.getNation());
            pstmt.setString(4, newMember.getEmail());
            pstmt.setInt(5, newMember.getAge());
            result = pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Member> selectMemberList() {
        ArrayList<Member> members = new ArrayList<>();
        String query = "SELECT * FROM MEMBER";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt(1));
                member.setName(rs.getString(2));
                member.setAddr(rs.getString(3));
                member.setNation(rs.getString(4));
                member.setEmail(rs.getString(5));
                member.setAge(rs.getInt(6));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public Member selectOldMember(String name) {
        String query = "SELECT * FROM MEMBER WHERE NAME = ?";
        Member member = new Member();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                member.setId(rs.getInt(1));
                member.setName(rs.getString(2));
                member.setAddr(rs.getString(3));
                member.setNation(rs.getString(4));
                member.setEmail(rs.getString(5));
                member.setAge(rs.getInt(6));
                return member;
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    public int updateMember(Member updateMember) {
        String query = "UPDATE MEMBER SET NATION = ?, ADDR = ?, EMAIL = ?, AGE = ? WHERE NAME = ?";
        int result = 0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, updateMember.getNation());
            pstmt.setString(2, updateMember.getAddr());
            pstmt.setString(3, updateMember.getEmail());
            pstmt.setInt(4,updateMember.getAge());
            pstmt.setString(5, updateMember.getName());
            result = pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteMember(String name) {
        String query = "DELETE FROM MEMBER WHERE NAME = ?";
        int result = 0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            result =  pstmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
