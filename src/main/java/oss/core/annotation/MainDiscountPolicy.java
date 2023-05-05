package oss.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy") //@Qualifier("mainDiscountPolicy") 처럼, 문자를 직접 적어주는 방식은 컴파일 시점에 체크가 되지 않습니다.
public @interface MainDiscountPolicy {
}
