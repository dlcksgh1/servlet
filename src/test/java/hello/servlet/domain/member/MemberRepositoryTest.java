package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void AfterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {

        //given
        Member member1 = new Member("kim", 20);

        //when
        memberRepository.save(member1);

        //then
        Member findMember = memberRepository.findById(member1.getId());
        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("kim", 20);
        Member member2 = new Member("lee", 25);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

}