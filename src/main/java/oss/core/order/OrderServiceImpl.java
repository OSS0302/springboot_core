package oss.core.order;

import oss.core.discount.DiscountPolicy;
import oss.core.discount.FixDiscountPolicy;
import oss.core.discount.RateDiscountPolicy;
import oss.core.member.Member;
import oss.core.member.MemberRepository;
import oss.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{

    private  final MemberRepository memberRepository = new MemoryMemberRepository(); // 회원 레포지토리 생성
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//회원 고정할인 객체생성
  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();// 회원 할인 객체 변경하기
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrince = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrince);
    }
}
