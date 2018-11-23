package com.racic.lib.consumer.repository;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepository extends CrudRepository <Member,Integer>{

	Member findByLastName(String lastname);
	Member findByFirstName(String firstname);
	Member findByEmail(String email);
	List<Borrowing> findByBorrowing(Borrowing borrowing);
	List<Member> findAll();
}
