package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.consumer.repository.MemberRepository;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Autowired
	MemberRepository memberRepository;
    
 
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
	
	public List<Borrowing> findByMemberId(int memberid){
		List<Borrowing> borrowlist = memberRepository.findById(memberid).get().getBorrowing();
		return borrowlist;
	}
	
	@Override
	public Member findByUsername(String username) {
		
		return memberRepository.findByUsername(username);
	}
	@Override
	@Transactional 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username);
		return null;
	}

    
}
