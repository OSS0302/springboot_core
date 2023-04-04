package oss.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AppConfig;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class); // 커맨드 +E 이전으로 돌아가기
    @Test
    @DisplayName("빈으로 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }


}
