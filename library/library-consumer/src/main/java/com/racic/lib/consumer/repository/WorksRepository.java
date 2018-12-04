package com.racic.lib.consumer.repository;

import com.racic.lib.model.Works;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorksRepository extends CrudRepository <Works, Integer>{

   
	Works findByTitle(String title);
	List<Works> findWorksByAuthor(String author);

	List<Works> findAll();

	Works findWorksByTitleIgnoreCase(String title);

	List<Works> findWorksByAuthorIgnoreCase(String author);

	
}
