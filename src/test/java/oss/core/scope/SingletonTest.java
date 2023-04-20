package oss.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
@Scope("singleton")//컴포넌트 스캔 자동 등록
public class SingletonTest {
    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        // 조회하기
        SingletonBean singlentonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singlentonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singlentonBean1 = " + singlentonBean1);
        System.out.println("singlentonBean2 = " + singlentonBean2);
        // 검증 하기
        Assertions.assertThat(singlentonBean1).isSameAs(singlentonBean2); // 같은지 비교 하는
        ac.close();
    }
    @Scope("singleton") // 수동등록
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }
    }
}
