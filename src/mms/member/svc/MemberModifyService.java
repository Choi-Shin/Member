package mms.member.svc;

import mms.member.dao.MemberDAO;
import static mms.member.db.JdbcUtil.getConnection;
import mms.member.vo.Member;

public class MemberModifyService {
    MemberDAO memberDAO = new MemberDAO(getConnection());
    public Member getOldMember (String name) {
        Member oldMember = memberDAO.selectOldMember(name);
        return oldMember;
    }
    public boolean modifyMember(Member updateMember) {
        int result = memberDAO.updateMember(updateMember);
        return result > 0;
    }
}
