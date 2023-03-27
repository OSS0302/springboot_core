package oss.core;

import oss.core.discount.FixDiscountPolicy;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;
import oss.core.member.MemoryMemberRepository;
import oss.core.order.Order;
import oss.core.order.OrderService;
import oss.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return  new MemberServiceImpl(new MemoryMemberRepository()); // 멤버 서비스 구현체에서 만들고  appconfig에서 메모리 멤머 레포지토리를 쓸거야 의존관계 주입
    }
    public OrderService orderService(){
        return new OrderServiceImpl(
                new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
