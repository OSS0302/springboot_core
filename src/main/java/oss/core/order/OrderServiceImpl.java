package oss.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import oss.core.discount.DiscountPolicy;

import oss.core.member.Member;
import oss.core.member.MemberRepository;
import oss.core.member.MemoryMemberRepository;
@Component
public class OrderServiceImpl implements  OrderService {
    //추상에만 의존해야하는데 구현에도 의존하니까 DIP위반이다.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//회원 고정할인 객체생성
    private final MemberRepository memberRepository; // 회원 레포지토리 생성 final 사용하면 외부에서 null로 들어갈 수 있지만 값이  있어야한다.
    private final DiscountPolicy discountPolicy;// 회원 할인 객체 변경하기
    // final 사용하면 외부에서 null로 들어갈 수 있지만 값이  있어야한다.  없으면 오류 난다.

     // 생성자 가 한개 인경우에만 @Autowired 생략이 가능하다. 일반적으로 문서에 null 있어도됩니다. 하지 않은 경우를 제외 하고 생성자 값이 있어야한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrince = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrince);
    }
    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
