package oss.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AutoAppConfig;
import oss.core.member.MemberRepository;
import oss.core.member.MemberService;
import oss.core.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class AutoAppconfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        // 조회하기
        MemberService memberService = ac.getBean(MemberService.class);
        // 검증하기
        assertThat(memberService).isInstanceOf(MemberService.class);
        // getMemberRepository()에값이 있는지 확인 
        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
