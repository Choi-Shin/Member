package mms.member.action;

import mms.member.svc.MemberModifyService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

import java.util.Scanner;

public class MemberModifyAction implements Action{
    @Override
    public void excute(Scanner sc) throws Exception {
        MemberModifyService memberModifyService = new MemberModifyService();
        Member oldMember = new Member();
        ConsoleUtil consoleUtil = new ConsoleUtil();
        String msgKind = "수정할 회원 이름을 입력하세요";
        String name = consoleUtil.getName(msgKind, sc);
        oldMember = memberModifyService.getOldMember(name);
        // 정보 수정
        Member updateMember = consoleUtil.getUpdateMember(sc, oldMember);
        boolean result = memberModifyService.modifyMember(updateMember);
        if (result) {
            consoleUtil.printModifySuccess(updateMember);
        } else {
            consoleUtil.printModifyFail(updateMember);
        }
    }
}
