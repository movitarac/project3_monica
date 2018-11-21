package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.consumer.repository.contract.MemberRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
    
    public MemberServiceImpl() {
    }

    public Member getMemberById(int id)  {

        //return memberRepository.getMemberbyMemberId(id);
        Member member1= new Member(1,"George","Lukas","george.lulu@gmail.com","lulu123","51 r carnot");
       System.out.println("on est dans le service, ca marche");
        return member1;
    }

    public List<Member> findAll() {
    	System.out.println("we are in member repository");
    	return this.memberRepository.findAll();
    }

    public Member findMemberByLastName(String lastname) {
        return null;
    }

    public Member findMemberById(int id) {
        return null;
    }

    public Member findMemberByFirstName(String firstname) {
        return null;
    }
}
