package oss.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import oss.core.member.Grade;
import oss.core.member.Member;

@Component
@Qualifier("fixdiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount =1000; // vip만 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //enum type 는 == 대입연산자 써야한다.
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
