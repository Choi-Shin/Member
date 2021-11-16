package mms.member.action;

import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberListAction implements Action{
    @Override
    public void excute(Scanner sc) throws Exception {
        ConsoleUtil consoleUtil = new ConsoleUtil();
        MemberListService memberListService = new MemberListService();
        ArrayList<Member> members = memberListService.getMemberList();
        consoleUtil.printMemberList(members);
    }
}
