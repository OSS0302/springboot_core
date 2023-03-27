package oss.core.Member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import oss.core.AppConfig;
import oss.core.member.Grade;
import oss.core.member.Member;
import oss.core.member.MemberService;
import oss.core.member.MemberServiceImpl;

public class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl(); // 필드변수에 Service 구현체를 만들어야한다.
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig =new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
        Member member =new Member(1L,"memberA", Grade.VIP);// 1번 이름 : memberA Grade등급:vip

        //when
        memberService.join(member);// 회원가입을 했을때
        Member findMember = memberService.findMember(1L);
        //than
        Assertions.assertThat(member).isEqualTo(findMember);   //인텔리제이에서 사용하는 member 와 findMember가 같은지 확인하는 API
    }
}
