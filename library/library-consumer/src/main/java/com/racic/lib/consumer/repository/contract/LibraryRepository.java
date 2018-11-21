package com.racic.lib.consumer.repository.contract;

import com.racic.lib.model.Library;
import com.racic.lib.model.Works;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{

    Library findLibraryByName (String libraryName);
    
    Library findLibraryById (int libraryid);

    List<Library> findAll();
}
