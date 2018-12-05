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

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	UserRepository userRepository;
 
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

	@Override
	public Member findMemberById(Integer id) {
		return memberRepository.findByIduser(id);
	}


	public Member findMemberByFirstName(String firstname) {
        return memberRepository.findByFirstName(firstname);
    }
    
    public Member findMemberByEmail (String email) {
    	return memberRepository.findByEmail(email);
    }

    @Override
	public String addUserMember(User user, Member member) {
    userRepository.save(user);
    memberRepository.save(member);
    	return "Member " + member.getFirstName() + " with username " + member.getUsername() + " is added!";

	}

	@Override
	public String addUser(User user) {
    	userRepository.save(user);
		return "user with " + user.getUsername() + " is added!";
	}

	@Override
	public String addMember(Member member) {
		memberRepository.save(member);
		return member.getFirstName() + " one of our loyal member. Welcome!";
	}

	@Override
	public String deleteMember(Member member) {
		memberRepository.delete(member);
		return "Member with id " + member.getIduser()  + " is deleted";
	}

	@Override
	public String updateMember(Member member) {
		memberRepository.save(member);
		return "Member with id " + member.getIduser() + " is updated";
	}
	
	public List<Borrowing> findByIdUser(Integer iduser){
		List<Borrowing> borrowlist = memberRepository.findById(iduser).get().getBorrowing();
		return borrowlist;
	}
	
	@Override
	public Member findByUsername(String username) {
		
		return memberRepository.findByUsername(username);
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

    
}
