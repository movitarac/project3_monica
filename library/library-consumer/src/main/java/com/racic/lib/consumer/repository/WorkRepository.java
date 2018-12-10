package com.racic.lib.consumer.repository;

import com.racic.lib.model.Work;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkRepository extends CrudRepository <Work, Integer>{


	Work findByTitle(String title);
	List<Work> findWorksByAuthor(String author);

	List<Work> findAll();

	List<Work> findWorksByAuthorIsContainingIgnoreCase(String author);

	List<Work> findWorksByAuthorIgnoreCase(String author);

	List<Work> findWorksByPublicationYear(int year);

	Work save(Work work);


}