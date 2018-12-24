package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BorrowingRepository extends CrudRepository<Borrowing, Integer>{
    
	List<Borrowing> findAll();
	List<Borrowing> findByMember(Member member);
	List<Borrowing> findAllByReturnDateBefore(Date today);

	
}
