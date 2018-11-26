package com.racic.lib.business.service.contract;

import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<Member> findAll();

    Member findMemberByLastName(String lastname);

    Member findMemberById(int id);

    Member findMemberByFirstName(String firstname);
    
    Member findMemberByEmail(String email);
    
    String addMember(Member member);
    
    String deleteMember(Member member);
    
    String updateMember(Member member);
    
    List<Borrowing> findByMemberId(int memberid);
    Member findByUsername(String username);

}
