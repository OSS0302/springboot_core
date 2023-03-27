package oss.core;

import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {//psvm+엔터
        AppConfig appConfig =new AppConfig();
        MemberService memberService = appConfig.memberService();
        //memberService에서 인터페이스 주고 memberServiceImpl 을 주고 메모리 멤버 레포지토리를 준다.
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember =memberService.findMember(1L);
        System.out.println("newMember = " + member.getName()); //sotuv+엔터
        System.out.println("findMember = " + findMember.getName()); //sotuv+엔터



    }
}
