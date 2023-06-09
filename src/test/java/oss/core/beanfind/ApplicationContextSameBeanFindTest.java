package oss.core.beanfind;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oss.core.member.MemberRepository;
import oss.core.member.MemoryMemberRepository;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class); // 커맨드 +E 이전으로 돌아가기

    // AppConfig을 손을 떼야하므로 위에 AppConfig.class을 삭제한다.
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으므로 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        //MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 빈 이름을 지정하면 된다.")
    void findBeanByName(){
        MemberRepository memberRepository  = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기") // command +shift+enter
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key+"value= "+beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }



    // config 새로 만든다.
    @Configuration
    static class SameBeanConfig {
        // 두개가 빈으로 등록이 되서 스프링부트입장에서는 무엇을 선택을 해야할 지모른다.
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
