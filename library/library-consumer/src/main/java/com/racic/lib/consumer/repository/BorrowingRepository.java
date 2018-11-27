package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface BorrowingRepository extends CrudRepository<Borrowing, Integer>{
    
	List<Borrowing> findAll();
	Borrowing findByMember(Member member);
	Borrowing findByBook(Book book);
	List<Borrowing> findByReturnDate(Date returnDate);
	List<Borrowing> findByStatus(String status);
	
}
