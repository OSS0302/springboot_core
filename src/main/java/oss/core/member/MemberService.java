package oss.core.member;

public interface MemberService {
    void join(Member member);  // 회원가입 기능
    Member findMember(Long memberId);//회원아이디를 통해서  조회하겠다.

}
