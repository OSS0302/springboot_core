package oss.core;

import oss.core.discount.DiscountPolicy;
import oss.core.discount.FixDiscountPolicy;
import oss.core.discount.RateDiscountPolicy;
import oss.core.member.MemberRepository;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;
import oss.core.member.MemoryMemberRepository;
import oss.core.order.Order;
import oss.core.order.OrderService;
import oss.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return  new MemberServiceImpl(memberRepository()); // 멤버 서비스 구현체에서 만들고   appconfig에서 메모리 멤머 레포지토리를 쓸거야 의존관계 주입
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),discountPolicy());
    }
    public DiscountPolicy discountPolicy (){
        //return new FixDiscountPolicy(); 고정 할인 정책
        return new RateDiscountPolicy(); // 할인율 정책
    }
}
