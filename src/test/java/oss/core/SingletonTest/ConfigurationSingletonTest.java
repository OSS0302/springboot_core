package oss.core.SingletonTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AppConfig;
import oss.core.member.MemberRepository;
import oss.core.member.MemberServiceImpl;
import oss.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); // 멤버 서비스
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);// 오더 서비스
        MemberRepository memberRepository =ac.getBean("memberRepository", MemberRepository.class);
        // 두개 오더 서비스 와 멤버서비스의  인스턴스 가 같는지 비교하기
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // 출력하기
        System.out.println("memberService-> memberRepository = " + memberRepository1);
        System.out.println("orderService ->memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        //겁증하기
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository); // 멤버 서비스 와 멤버 리포지토리 가 같은지 확인
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs((memberRepository));// 오더 서비스와 멤버 리포지토리 가 같은지 확인

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //AppConfig도 스프링 빈으로 등록된다.//getBean 해서 Appconfig를 조회하겠다.
        AppConfig bean = ac.getBean(AppConfig.class);

        // 출력하기
        System.out.println("bean = " + bean.getClass()); //get bean 을 해야 클래스 타입을 알수있다.
        //bean = class oss.core.AppConfig$$EnhancerBySpringCGLIB$$de2e9d4e
    }
}
