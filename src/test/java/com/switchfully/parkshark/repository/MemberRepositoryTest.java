package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeAll
    void setUp() {
        memberRepository.save(new Member());

    }


    @Test
    public void findAll() {
        var toCheck = memberRepository.findAll().size();
        Assertions.assertEquals(1, toCheck);


    }

    @Test
    public void findById() {
        var toCheck = memberRepository.findMemberByMemberId(1);
        Assertions.assertNotNull(toCheck);

    }

    @Test
    public void save() {
        memberRepository.save(new Member());
        var toCheck = memberRepository.findAll().size();
        Assertions.assertEquals(2, toCheck);

    }


}