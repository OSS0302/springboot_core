package oss.core.discount;

import oss.core.member.Grade;
import oss.core.member.Member;

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
