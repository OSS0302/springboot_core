package oss.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

@Component
public class SingletonWithPrototypeTest1 {
    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
       int count1 =  clientBean1.logic();
       assertThat(count1).isEqualTo(1);
        System.out.println("count1 = " + count1);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(2);
        System.out.println("count2 = " + count2);
    }

    @Scope("singleton")
    //@RequiredArgsConstructor 이용해도 된다.
    static class ClientBean{

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Autowired
        private ObjectProvider<PrototypeBean>prototypeBeanProvider;
            public int logic(){
                PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
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
