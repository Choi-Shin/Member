package mms.member.svc;

import mms.member.dao.MemberDAO;

import static mms.member.db.JdbcUtil.getConnection;

import mms.member.vo.Member;

public class MemberRemoveService {


    public boolean removeMember(String name) {
        MemberDAO memberDAO = new MemberDAO(getConnection());
        int result = memberDAO.deleteMember(name);
        return result > 0;
    }
}
