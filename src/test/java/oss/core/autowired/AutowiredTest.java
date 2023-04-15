package oss.core.autowired;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import oss.core.member.Member;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
   static class TestBean{
        @Autowired(required = true)
       public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
       public void setNoBean2(@Nullable Member noBean2){ // @Nullable 하고 스프링빈이 없다면  null 값으로 들어온다.
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired
        public void setNoBean3(Optional<Member>noBean3){ //자바 8에서 쓸 수있는Optional 스프링 빈 없으면 Optional.empty
            System.out.println("noBean3 = " + noBean3);
        }
    }
}