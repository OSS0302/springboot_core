package oss.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class SingletonWithPrototypeTest1 {
    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
    }
    @Scope("singleton")
    //@RequiredArgsConstructor 이용해도 된다.
    static class ClientBean{
        private final PrototypeBean prototypeBean;
        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }
        public int logic(){
            prototypeBean.addCount();
            int count = prototypeBean.getCount(); //코드를 합칠수있다. command+ option +N
            return  count;
            //return prototypeBean.getCount();이렇게 나온다.
        }

    }
    @Scope("prototype")
        static class PrototypeBean{
            private  int count =0; // 0으로 초기화

            public void addCount(){
                count++;
            }
            public int getCount(){
                return count;
        }
        @PostConstruct
        public void  init(){
            System.out.println("PrototypeBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
