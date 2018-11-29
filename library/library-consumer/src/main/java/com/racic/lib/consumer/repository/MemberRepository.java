package com.racic.lib.consumer.repository;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MemberRepository extends CrudRepository <Member,Integer>{

	Member findByLastName(String lastname);
	Member findByFirstName(String firstname);
	Member findByUsername(String username);
	Member findByEmail(String email);
	List<Borrowing> findByBorrowing(Borrowing borrowing);
	//List<Borrowing> findById(int memberid);
	List<Member> findAll();

	/*
	@Modifying
	@Query("select * from member where username=? and password=?")
	*/
	Member findByUsernameAndPassword(String username, String password);

}
