package oss.core.SingletonTest;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import oss.core.AppConfig;
import oss.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;

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
        // 참조값이 다른 것을 확인 한다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService3 = " + memberService3);

        //테스트 자동화를 하기위해서
        // memberService1!=  memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

        // memberService2!=  memberService3
        assertThat(memberService2).isNotSameAs(memberService3);


    }
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용")
    void singletonServiceTest(){
        //private으로 생성자를 막아두었다. 컴파일 오류가 발생한다.
         new SingletonService();


    }
}

