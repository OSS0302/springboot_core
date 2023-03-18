package oss.core.order;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void  createOrder(){
        Long memberId =1L;
        Member member =new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itmeA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
