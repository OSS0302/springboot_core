package oss.core.member;

import java.lang.reflect.Member;

public interface MemberRepository {
    void save(Member member);// 회원을 저장하는기능
    Member findById(Long memberId);// 회원을 찾은 기능

}
