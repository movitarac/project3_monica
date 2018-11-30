package com.racic.lib.consumer.repository;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MemberRepository extends CrudRepository <Member,Integer>{

	Member findByLastName(String lastname);
	Member findByFirstName(String firstname);
	Member findByUsername(String username);
	Member findByEmail(String email);

	Member findByIduser(Integer iduser);
	List<Member> findAll();

	Member findByUsernameAndPassword(String username, String password);

}
