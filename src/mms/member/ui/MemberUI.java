package mms.member.ui;

import mms.member.action.MemberAddAction;
import mms.member.action.MemberListAction;
import mms.member.action.MemberModifyAction;
import mms.member.action.MemberRemoveAction;
import mms.member.controller.MemberController;

import java.util.Scanner;

public class MemberUI {
    public static void main(String[] args) {
        boolean isStop = false;
        MemberController memberController = new MemberController();
        Scanner sc = new Scanner(System.in);
        do {
            int select = memberController.printMenu();
            switch (select) {
                case 1:
                    memberController.processRequest(new MemberAddAction(), sc);
                    break;
                case 2:
                    memberController.processRequest(new MemberListAction(), sc);
                    break;
                case 3:
                    memberController.processRequest(new MemberModifyAction(), sc);
                    break;
                case 4:
                    memberController.processRequest(new MemberRemoveAction(), sc);
                    break;
                case 5:
                    isStop = true;
                    break;
                default:
                    throw new IllegalStateException("잘못된 입력값: " + select);
            }
        } while (!isStop);
    }
}
