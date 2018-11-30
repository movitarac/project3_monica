package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WorksRepository extends CrudRepository <Works, Integer>{

   
	Works findByTitle(String title);
	Works findByAuthor(String author);
	Works findByPublicationYear (int pubyear);
	List<Works> findAll();

	Works findWorksByTitleIgnoreCase(String title);
	Works findWorksByAuthorIgnoreCase(String author);
	
}
