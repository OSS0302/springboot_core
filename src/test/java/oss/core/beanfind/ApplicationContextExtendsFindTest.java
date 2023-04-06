package oss.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oss.core.AppConfig;
import oss.core.discount.DiscountPolicy;
import oss.core.discount.FixDiscountPolicy;
import oss.core.discount.RateDiscountPolicy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate(){
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상있으면 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }


    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){ // 비율 할인 정책
            return new RateDiscountPolicy();
        }

        @Bean

        public DiscountPolicy fixDiscountPolicy(){ // 고정 할인 정책
            return new FixDiscountPolicy();
        }
    }
}
