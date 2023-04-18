package oss.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AutoAppConfig;
import oss.core.discount.DiscountPolicy;

import java.util.List;
import java.util.Map;

public class AllBeanTest  {
    @Test
      void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountPolicy.class);

    }
    static class DiscountPolicy{
        private  final  Map<String, DiscountPolicy> policyMap;
        private  final List<DiscountPolicy>policies;
        @Autowired
        public DiscountPolicy(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            //  출력하기
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }
    }
    }
