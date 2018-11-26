package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Works;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String>{
    
	List<Book> findAll();
}
