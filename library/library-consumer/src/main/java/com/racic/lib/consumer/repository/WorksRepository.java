package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WorksRepository extends CrudRepository <Works, String>{
	Library findByLibrary(Library library);
   
	Works findByTitle(String title);
	Works findByAuthor(String author);
	Works findByCopies(int copies);
	Works findByPublicationYear (int pubyear);
	
}
