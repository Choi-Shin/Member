package mms.member.controller;

import mms.member.action.Action;
import mms.member.util.ConsoleUtil;

import java.util.Scanner;

public class MemberController {
    ConsoleUtil consoleUtil = new ConsoleUtil();
    Scanner sc = new Scanner(System.in);
    public int printMenu () {
        consoleUtil.printMenu();
        return sc.nextInt();
    }
    public void processRequest(Action action, Scanner sc) {
        try {
            action.excute(sc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
