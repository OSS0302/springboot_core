package oss.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import oss.core.AppConfig;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든빈 출력하기")
    void findBean () {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter누르면 for 문 이 자동으로 생성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // 타입을 모르겠떄문에 object으로 만들어진다.
            System.out.println("name = " + beanDefinitionName + "object = " + bean); // key value


        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기 ")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition =ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈

            if(beanDefinition.getRole() ==BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName); // 타입을 모르겠떄문에 object으로 만들어진다.
                System.out.println("name = " + beanDefinitionName + "object = " + bean); // key value
            }
        }
    }
}
