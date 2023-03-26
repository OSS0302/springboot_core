package oss.core.order;

import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService =new MemberServiceImpl();
        OrderService orderService =new OrderServiceImpl();

        Long memberId =1L;
        Member member =new Member(memberId, "memberA",Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",1000);

        System.out.println("order = " + order);
        //System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
