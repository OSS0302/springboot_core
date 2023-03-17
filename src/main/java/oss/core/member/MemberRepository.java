package oss.core.member;

public interface MemberRepository {

    void save(Member member);      //회원 저장 기능
    Member findById(Long memberId);//회원 조회 기능
}
