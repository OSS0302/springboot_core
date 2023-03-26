package oss.core.member;

public class MemberServiceImpl implements MemberService {

    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
// join에서 save를 호출하면 다형성에 의해서 MemorymemberRepository를 호출하면 MemorymemberRepository 안에 save 가 호출된다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
