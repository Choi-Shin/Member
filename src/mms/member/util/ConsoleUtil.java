package mms.member.util;

import mms.member.vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUtil {
    Scanner sc = new Scanner(System.in);

    public void printMenu() {
        System.out.println("=====회원 관리 프로그램=====");
        System.out.println("1.회원 등록");
        System.out.println("2.회원 목록 보기");
        System.out.println("3.회원 정보 수정");
        System.out.println("4.회원 정보 삭제");
        System.out.println("5.프로그램 종료");
        System.out.print("메뉴 번호 : ");
    }

    public Member getNewMember() {
        Member newMember = new Member();
        System.out.println("등록할 회원 정보를 입력하세요");
        System.out.print("이름: ");
        newMember.setName(sc.next());
        System.out.print("주소: ");
        newMember.setAddr(sc.next());
        System.out.print("국가: ");
        newMember.setNation(sc.next());
        System.out.print("이메일: ");
        newMember.setEmail(sc.next());
        System.out.print("나이: ");
        newMember.setAge(sc.nextInt());
        return newMember;
    }

    public void printMemberList(ArrayList<Member> members) {
        if (members.size() > 0) {
            for (Member m : members) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("등록된 회원이 존재하지 않습니다.");
        }
    }

    public String getName(String msgKind, Scanner sc) {
        System.out.println(msgKind);
        System.out.print("회원 이름 : ");
        return sc.next();
    }

    public Member getUpdateMember(Scanner sc, Member updateMember) {
        System.out.println("수정할 회원 정보를 입력하세요");
        System.out.print("이전 국가 : " + updateMember.getNation() + " 수정할 국가 : ");
        updateMember.setNation(sc.next());
        System.out.print("이전 주소 : " + updateMember.getAddr() + " 수정할 주소 : ");
        updateMember.setAddr(sc.next());
        System.out.print("이전 이메일 : " + updateMember.getEmail() + " 수정할 이메일 : ");
        updateMember.setEmail(sc.next());
        System.out.print("이전 나이 : " + updateMember.getAge() + " 수정할 나이 : ");
        updateMember.setAge(sc.nextInt());
        return updateMember;
    }


    public void printAddSuccess(Member newMember) {
        System.out.println(newMember.getName() + " 회원 정보 추가 성공");
    }

    public void printAddFail(Member newMember) {
        System.out.println(newMember.getName() + " 회원 정보 추가 실패");
    }

    public void printModifySuccess(Member updateMember) {
        System.out.println(updateMember.getName() + " 회원 정보 수정 성공");
    }

    public void printModifyFail(Member updateMember) {
        System.out.println(updateMember.getName() + " 회원 정보 수정 실패");
    }

    public void printRemoveSuccess(String name) {
        System.out.println(name + " 회원 정보 삭제 성공");
    }

    public void printRemoveFail(String name) {
        System.out.println(name + " 회원 정보 삭제 실패");
    }
}
