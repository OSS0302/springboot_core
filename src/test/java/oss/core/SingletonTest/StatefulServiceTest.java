package oss.core.SingletonTest;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //Thread:A사용자 10000원 주문
        statefulService1.order("UserA",10000);
        //Thread:B사용자 20000원 주문
        statefulService2.order("UserB",20000);

        //Thread:A사용자 에대한 주문 금액 조회()
        int price =statefulService1.getPrice();
        System.out.println("price = " + price);
        //왜냐하면 statefulService1,statefulService2 든 같은 인스턴스를 사용하기 때문에 그렇다

    
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();

        }
    }
}