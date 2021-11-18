package com.switchfully.parkshark.repository;

import com.switchfully.parkshark.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Integer> {

    Member findMemberByMemberId(int id);

    List<Member> findAll();

}
