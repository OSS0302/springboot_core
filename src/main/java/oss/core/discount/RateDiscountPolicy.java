package oss.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import oss.core.member.Grade;
import oss.core.member.Member;
@Component
@Qualifier("maindiscountPolicy")
public class RateDiscountPolicy implements  DiscountPolicy{
    private  int discountPercent =10; //구매한 금액에 10%을 할인을 하겠다.

    @Override
    public int discount(Member member, int price) {
    if( member.getGrade()== Grade.VIP){ // 등급이 vip 일때만 10% 할인이적용되고 이외등급 등급은 미적용한다.
        return price * discountPercent / 100; // 가격 * 할인율 /100 (할인율 10% 구하는 공식이다.)
        }else{
            return 0;
        }
    }
}
