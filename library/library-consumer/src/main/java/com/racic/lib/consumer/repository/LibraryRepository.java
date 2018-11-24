package com.racic.lib.consumer.repository;

import com.racic.lib.model.Book;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LibraryRepository extends CrudRepository<Library, Integer>{

	Library findByWorks(Works works);
	Library findByLibraryName(String libraryname);
	Library findByCity(String city);  
	
	//List<Works> findByLibraryName(String libraryname);
}
