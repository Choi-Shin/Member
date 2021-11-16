package mms.member.action;

import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtil;

import java.util.Scanner;

public class MemberRemoveAction implements Action {
    @Override
    public void excute(Scanner sc) throws Exception {
        ConsoleUtil consoleUtil = new ConsoleUtil();
        String msgKind = "삭제할 회원 이름을 입력하세요";
        String name = consoleUtil.getName(msgKind, sc);
        MemberRemoveService memberRemoveService = new MemberRemoveService();
        boolean result = memberRemoveService.removeMember(name);
        if (result) {
            consoleUtil.printRemoveSuccess(name);
        } else {
            consoleUtil.printRemoveFail(name);
        }
    }
}
