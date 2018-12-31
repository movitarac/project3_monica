package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.consumer.repository.MemberRepository;
import com.racic.lib.consumer.repository.UserRepository;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	UserRepository userRepository;
 

    public List<Member> findAll() {
    	return memberRepository.findAll();
    }


    public Member findMemberByEmail (String email) {
    	return memberRepository.findByEmail(email);
    }


	@Override
	public Member findByUsernameAndPassword(String username, String password){

    return memberRepository.findByUsernameAndPassword(username,password);
	}

	@Override
	public boolean isValidUser(String userName, String passWord) {

    	Member validMember = memberRepository.findByUsernameAndPassword(userName, passWord);

    	boolean toReturn;
    	if (validMember !=null) {
    		toReturn = true;
		} else{
    		toReturn = false;
		}
    	return toReturn;
	}


	/*
	@Override
	public String addUser(String username, String password) {
    	User userToBeAdded = new User();
    	userToBeAdded.setUsername(username);
    	userToBeAdded.setPassword(password);
    	userRepository.save(userToBeAdded);
		return "user with " + userToBeAdded.getUsername() + " is added!";
	}


	@Override
	public String addMember(String firstname, String lastname,
							String email, String address) {
		Member memberToBeAdded = new Member();
		memberToBeAdded.setFirstName(firstname);
		memberToBeAdded.setLastName(lastname);
		memberToBeAdded.setAddress(address);
		memberToBeAdded.setEmail(email);
    	memberRepository.save(memberToBeAdded);
		return memberToBeAdded.getFirstName() + " one of our loyal member. Welcome!";
	}
*/

}
