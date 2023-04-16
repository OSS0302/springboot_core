package oss.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import oss.core.discount.DiscountPolicy;

import oss.core.member.Member;
import oss.core.member.MemberRepository;
import oss.core.member.MemoryMemberRepository;
@Component

public class OrderServiceImpl implements  OrderService {
    //추상에만 의존해야하는데 구현에도 의존하니까 DIP위반이다.//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//회원 고정할인 객체생성
     private final MemberRepository memberRepository; // NullPointExceptions // 회원 레포지토리 생성 // Field injection is not recommended
     private final DiscountPolicy discountPolicy;// 회원 할인 객체 변경하기 //
    // final키워드생성자 주입을 사용하면 필드에final키워드를 사용할 수 있다.
    // 그래서 생성자에서 혹시라도 값이 설정되지 않는 오류를 컴파일 시점에 막아준다


   // 생성자 가 한개 인경우에만 @Autowired 생략이 가능하다. 일반적으로 문서에 null 있어도됩니다. 하지 않은 경우를 제외 하고 생성자 값이 있어야한다.
    // 수정자 주입 다른 개발자 필요하면 수정해서 쓸수있는 있으니 생성자 주입을 사용하자 // 테스트 누락을 위해서 수정자 주입을 쓴다.

    // 생성자 한개인 경우에는 @AutoWried를 생략이 가능하다
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
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
