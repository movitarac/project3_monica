package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.consumer.repository.MemberRepository;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
    
  
	//for test
    public Member getMemberById(int id)  {

        //return memberRepository.getMemberbyMemberId(id);
        Member member1= new Member(1,"George","Lukas","george.lulu@gmail.com","lulu123","51 r carnot");
       System.out.println("on est dans le service, ca marche");
    	return member1;
    	
    }

    public Member findMemberById(int id) {
    	return memberRepository.findById(id).get();
    }
    public List<Member> findAll() {
    	//System.out.println("we are in member repository");
    	return memberRepository.findAll();
    }

    public Member findMemberByLastName(String lastname) {
        return memberRepository.findByLastName(lastname);
    }


    public Member findMemberByFirstName(String firstname) {
        return memberRepository.findByFirstName(firstname);
    }
    
    public Member findMemberByEmail (String email) {
    	return memberRepository.findByEmail(email);
    }

	@Override
	public String addMember(Member member) {
		memberRepository.save(member);
		return member.getFirstName() + " one of our loyal member. Welcome!";
	}

	@Override
	public String deleteMember(Member member) {
		memberRepository.delete(member);
		return "Member with id " + member.getMemberId()  + " is deleted";
	}

	@Override
	public String updateMember(Member member) {
		memberRepository.save(member);
		return "Member with id " + member.getMemberId() + " is updated";
	}
    
    
}
