package com.racic.lib.business.service.contract;

import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findMemberByLastName(String lastname);

    Member findMemberById(int id);

    Member findMemberByFirstName(String firstname);
    
    Member getMemberById(int memberid);

}
