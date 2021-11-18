package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findMemberByMemberId(int id);

    List<Member> findAll();

}
