package oss.core.xml;




import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import oss.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {
    public class XmlAppContext{
        @Test
        void xmlAppContext(){
            ApplicationContext ac = new GenericApplicationContext("appConfig.xml");
            MemberService memberService =ac.getBean("memberService",MemberService.class);
            assertThat(memberService).isInstanceOf(MemberService.class);

        }
    }
}
