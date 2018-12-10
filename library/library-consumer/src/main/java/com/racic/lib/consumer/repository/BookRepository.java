package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Works;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String>{

	List<Book> findAll();
	List<Book> findBooksByWorks(Works works);
	List<Book> findBooksByWorksWorksId(Integer worksid);
	//List<Book> findBooksByWorksWorksIdAndAndAvailableIsTrue(Integer worksid);

}
