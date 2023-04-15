package oss.core.order;

import org.junit.jupiter.api.Test;
import oss.core.discount.FixDiscountPolicy;
import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    // 생성자 주입 선택하기 누락과 불변

    @Test
    void createOrder(){
        MemoryMemberRepository MemberRepository = new MemoryMemberRepository();
        MemberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService =new OrderServiceImpl(MemberRepository,new FixDiscountPolicy());
        orderService.createOrder(1L,"itemA",10000);

    }
}