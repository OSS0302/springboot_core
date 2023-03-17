package oss.core;

import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {//psvm+엔터
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember =memberService.findMember(1L);
        System.out.println("newMember = " + member.getName()); //sotuv+엔터
        System.out.println("findMember = " + findMember.getName()); //sotuv+엔터



    }
}
