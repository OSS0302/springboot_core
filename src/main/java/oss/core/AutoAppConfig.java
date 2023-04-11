package oss.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(//전체 다  컴포넌트 스캔해서  필요한 부분만 스프링부트 빈으로 자동등록하겠다.
        // 지정하지 않으면  @componentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
        basePackages = "oss.core", //탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.(라이브러리 포함)
        basePackageClasses = AutoAppConfig.class, //지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.

        //classes = Configuration.class를 빼겠다 (지정해서 뺸다) 왜냐하면 @configuration 안에 ComponentScan이 있기때문에
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
