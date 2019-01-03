package com.racic.lib.consumer.repository;

import com.racic.lib.model.Member;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MemberRepository extends CrudRepository <Member,Integer>{


	Member findByEmail(String email);

	List<Member> findAll();

	Member findByUsernameAndPassword(String username, String password);

}
