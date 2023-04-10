package oss.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(//전체 다  컴포넌트 스캔해서  필요한 부분만 스프링부트 빈으로 자동등록하겠다.전
        //classes = Configuration.class를 빼겠다 (지정해서 뺸다)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
