package oss.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("PrototypeTest.prototypeBeanFind1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class); // prototypeBean1 조회하기
        System.out.println("PrototypeTest.prototypeBeanFind2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);//prototypeBean2 조회하기
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2); // 검증하기
        ac.close(); // destory 호출하기
    }
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }
        @PreDestroy
        public void destory() {
            System.out.println("PrototypeBean.destory");
        }
    }
}


