package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.User;

import java.util.List;


public interface MemberService {

    List<Member> findAll();

    Member findMemberByLastName(String lastname);

    Member findMemberById(Integer id);

    Member findMemberByFirstName(String firstname);
    
    Member findMemberByEmail(String email);

    String addUserMember (User user, Member member);
    String addUser (User user);

    String addMember(Member member);
    
    String deleteMember(Member member);
    
    String updateMember(Member member);
    
    List<Borrowing> findByIdUser(Integer iduser);
    Member findByUsername(String username);

    Member findByUsernameAndPassword(String username, String password);

    boolean isValidUser(String userName, String passWord);
}
