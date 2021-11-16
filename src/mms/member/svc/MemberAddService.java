package mms.member.svc;

import mms.member.dao.MemberDAO;
import static mms.member.db.JdbcUtil.*;
import mms.member.vo.Member;

public class MemberAddService {
    public boolean addMember(Member newMember) throws Exception {
        MemberDAO memberDAO = new MemberDAO(getConnection());
        int result = memberDAO.insertNewMember(newMember);
        return result > 0;
    }
}
