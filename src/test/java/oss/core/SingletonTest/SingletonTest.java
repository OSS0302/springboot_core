package oss.core.SingletonTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import oss.core.AppConfig;
import oss.core.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig =new AppConfig();
        //1. 조회: 호출할때 미디 객체를 생성
       MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할때 미디 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //3. 조회: 호출할때 미디 객체를 생성
        MemberService memberService3 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService3 = " + memberService3);

    }
}

