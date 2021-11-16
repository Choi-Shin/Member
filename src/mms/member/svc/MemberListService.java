package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;
import java.util.ArrayList;
import static mms.member.db.JdbcUtil.getConnection;

public class MemberListService {
    public ArrayList<Member> getMemberList() {
        ArrayList<Member> members = new ArrayList<>();
        MemberDAO memberDAO = new MemberDAO(getConnection());
        members = memberDAO.selectMemberList();
        return members;
    }
}
