package oss.core.autowired;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AutoAppConfig;
import oss.core.discount.DiscountPolicy;
import oss.core.member.Grade;
import oss.core.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
       ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        // 멤버 생성하기
        Member member = new Member(1L, "UserA", Grade.VIP);
       discountService.discount(member, 10000, "fixDiscountPolicy");


    }

    static class DiscountService{
        private  final Map<String , DiscountPolicy> policyMap;
        private  final List<DiscountPolicy>policies;
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            // 출력하기
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public void discount(Member member, int i, String fixDiscountPolicy) {
        }
    }

}
