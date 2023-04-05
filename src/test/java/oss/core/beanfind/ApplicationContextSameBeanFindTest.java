package oss.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import oss.core.AppConfig;
import oss.core.discount.DiscountPolicy;
import oss.core.member.MemberRepository;
import oss.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SameBeanConfig.class  ); // 커맨드 +E 이전으로 돌아가기
    // AppConfig을 손을 떼야하므로 위에 AppConfig.class을 삭제한다.
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으므로 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        ac.getBean(MemberRepository.class);
    }
    // config 새로 만든다.
    @Configuration
    static class SameBeanConfig{
        // 두개가 빈으로 등록이 되서 스프링부트입장에서는 무엇을 선택을 해야할 지모른다.
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
