package com.racic.lib.consumer.repository;

import com.racic.lib.model.Library;
import com.racic.lib.model.Work;

import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Integer> {

	//Library findByWorks(Work work);

	Library findByLibraryName(String libraryname);

	Library findByCity(String city);

}

