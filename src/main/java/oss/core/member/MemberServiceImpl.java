package oss.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    private  final MemberRepository memberRepository;// 추상화애만 의존한다.

    @Autowired //자동 의존관계주입 생성자에 @Autowired를 붙여주면 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
// join에서 save를 호출하면 다형성에 의해서 MemorymemberRepository를 호출하면 MemorymemberRepository 안에 save 가 호출된다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
