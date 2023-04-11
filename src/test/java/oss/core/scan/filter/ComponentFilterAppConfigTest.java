package oss.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


import static org.assertj.core.api.Assertions.*;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac =  new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        //조회하기
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        //검증하기 beanA
        assertThat(beanA).isNotNull(); // componentScan 포함하고 있어서 notnull이어야한다.




    }
    @Configuration
    @ComponentScan(
            // 추가하는 필터
            includeFilters = @Filter(type = FilterType.ANNOTATION,classes = MyIncludeComponent.class),
            // 제외하는 필터
            excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = MyExcludeComponent.class)
    )
    static  class ComponentFilterAppConfig{

    }
}
