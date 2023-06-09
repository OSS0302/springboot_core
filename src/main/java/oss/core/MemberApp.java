package oss.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {//psvm+엔터
//        AppConfig appConfig =new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //memberService에서 인터페이스 주고 memberServiceImpl 을 주고 메모리 멤버 레포지토리를 준다.

        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig 안에 빈 객체 직접 관리해준다.
        MemberService memberService =applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember =memberService.findMember(1L);
        System.out.println("newMember = " + member.getName()); //sotuv+엔터
        System.out.println("findMember = " + findMember.getName()); //sotuv+엔터
    }
}
