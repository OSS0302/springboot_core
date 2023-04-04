package oss.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AppConfig;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class); // 커맨드 +E 이전으로 돌아가기
    @Test
    @DisplayName("빈으로 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);//이름을 생략이 가능하다.
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    @Test
    @DisplayName("구체 타입으로  조회")
    void findBeanName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        //구현에 의존 했으므로 별로 좋은 코딩이 아니다 역할에만 의존하는 것이 좋다.
        assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxxxx", MemberService.class));
    }
}
