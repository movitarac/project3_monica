package com.racic.lib.consumer.repository.contract;

import com.racic.lib.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepository {

    /**
     *
     * @param member
     * @return the member object
     */
    Member createMember (Member member);

    /**
     *
     * @param lastName
     * @return the member object
     */
    Member findMemberbyLastName(String lastName);

    Member findMemberbyFisttName(String firstName);

    Member findMemberbyMemberId(int memberId);

    Member findMemberByEmail(String emailMember);

    /**
     * @return the list of member
     */
    List<Member> findAll();

}
