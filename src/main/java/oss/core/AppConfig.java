package oss.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oss.core.discount.DiscountPolicy;

import oss.core.discount.RateDiscountPolicy;
import oss.core.member.MemberRepository;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;
import oss.core.member.MemoryMemberRepository;
import oss.core.order.Order;
import oss.core.order.OrderService;
import oss.core.order.OrderServiceImpl;
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository()); // 멤버 서비스 구현체에서 만들고   appconfig에서 메모리 멤머 레포지토리를 쓸거야 의존관계 주입
    }
    @Bean
    public  MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy (){
        //return new FixDiscountPolicy(); 고정 할인 정책
        return new RateDiscountPolicy(); // 할인율 정책
    }
}
