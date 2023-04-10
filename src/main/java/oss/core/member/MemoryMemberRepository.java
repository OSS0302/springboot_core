package oss.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long ,Member> store = new HashMap<>(); // 동시성 이슈 가있을 수있어서
    // 컨커러데시브 map 사용하지만 여기서는 간단한 map 사용 
    @Override
    public void save(Member member) {
    store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
