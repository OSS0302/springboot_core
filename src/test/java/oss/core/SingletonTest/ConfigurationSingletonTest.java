package oss.core.SingletonTest;

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

        // 두개 오더 서비스 와 멤버서비스의  인스턴스 가 같는지 비교하기
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // 출력하기
        System.out.println("memberService-> memberRepository = " + memberRepository1);
        System.out.println("orderService ->memberRepository2 = " + memberRepository2);

    }@Test
        void configurationTest1() {
            ApplicationContext ac = new
                    AnnotationConfigApplicationContext(AppConfig.class);
            MemberServiceImpl memberService = ac.getBean("memberService",
                    MemberServiceImpl.class);
            OrderServiceImpl orderService = ac.getBean("orderService",
                    OrderServiceImpl.class);
            MemberRepository memberRepository = ac.getBean("memberRepository",
                    MemberRepository.class);
//모두 같은 인스턴스를 참고하고 있다.
            System.out.println("memberService -> memberRepository = " +
                    memberService.getMemberRepository());
            System.out.println("orderService -> memberRepository  = " +
                    orderService.getMemberRepository());
            System.out.println("memberRepository = " + memberRepository);
    }

}
