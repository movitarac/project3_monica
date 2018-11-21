package com.racic.lib.consumer.repository.impl;


import com.racic.lib.consumer.repository.contract.MemberRepository;
import com.racic.lib.model.Member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    public Member createMember(Member member) {
        return null;
    }

    public Member findMemberbyLastName(String lastName) {
        return null;
    }

    public Member findMemberbyFisttName(String firstName) {
        return null;
    }

    public Member findMemberbyMemberId(int memberId) {
        return null;
    }

    public Member getMemberbyMemberId(int memberId) {

        Member member1= new Member(1,"George","Lukas","george.lulu@gmail.com","lulu123","51 r carnot");
        return member1;
    }

    public Member findMemberByEmail(String emailMember) {
        return null;
    }

    public List<Member> findAll() {
    	Member member1= new Member(1,"George","Lukas","george.lulu@gmail.com","lulu123","51 r carnot");
    	Member member2= new Member(1,"Alpha","Edison","Edison.alpha@gmail.com","abcd","53 r carnot");
        List<Member> listmember = new ArrayList<Member>();
        listmember.add(member2);
        listmember.add(member1);
    	return listmember;
    }
}
