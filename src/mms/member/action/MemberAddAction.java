package mms.member.action;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

import java.util.Scanner;

public class MemberAddAction implements Action{

    @Override
    public void excute(Scanner sc) throws Exception {
        MemberAddService memberAddService = new MemberAddService();
        ConsoleUtil consoleUtil = new ConsoleUtil();
        Member newMember = consoleUtil.getNewMember();
        boolean result = memberAddService.addMember(newMember);
        if (result) {
            consoleUtil.printAddSuccess(newMember);
        } else {
            consoleUtil.printAddFail(newMember);
        }
    }
}
