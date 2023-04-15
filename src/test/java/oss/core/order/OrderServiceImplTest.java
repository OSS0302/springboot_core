package oss.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import oss.core.discount.FixDiscountPolicy;
import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    // 생성자 주입 선택하기 누락과 불변

    @Test
    void createOrder(){
        // 자바 스프링 을 이용하지 않고 이건 순수한 자바이용해서 테스트한것이다..
        MemoryMemberRepository MemberRepository = new MemoryMemberRepository();
        MemberRepository.save(new Member(1L,"name", Grade.VIP)); //테스트를 위한 임의의 회원 정보 생성
        OrderServiceImpl orderService =new OrderServiceImpl(MemberRepository,new FixDiscountPolicy());
        // 조회하기
        Order order = orderService.createOrder(1L, "itemA", 10000);
        //검증하기
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}