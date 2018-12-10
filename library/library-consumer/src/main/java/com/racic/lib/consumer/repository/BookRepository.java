package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Work;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String>{

	List<Book> findAll();
	List<Book> findBooksByWork(Work work);
	List<Book> findBooksByWorkWorksId(Integer worksid);
	List<Book> findBooksByIsAvailableAndWorkWorksId(boolean available, Integer worksid);



}