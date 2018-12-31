package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.User;

import java.util.List;


public interface MemberService {

    List<Member> findAll();

    Member findMemberByEmail(String email);


   // String addUser(String username, String password);


   // String addMember(String firstname, String lastname,String email, String address);

    Member findByUsernameAndPassword(String username, String password);

    boolean isValidUser(String userName, String passWord);
}
