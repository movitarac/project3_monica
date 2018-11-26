package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.LibraryService;
import com.racic.lib.consumer.repository.LibraryRepository;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryServiceImpl implements LibraryService {

   @Autowired
   LibraryRepository libraryRepository;

    public Library getByWorkList(Works works) {
    	return libraryRepository.findByWorks(works);
    }

    public Library getLibraryByName(String libraryName) {
        return libraryRepository.findByLibraryName(libraryName);
    }

    public Library getLibraryById(int id) {
        return libraryRepository.findById(id).get();
    }

    public Library getLibraryByCity(String city) {
    	return libraryRepository.findByCity(city);
    }
    public List<Works> findByLibraryId(int libraryid) {
    	List<Works> workslist = libraryRepository.findById(libraryid).get().getWorks();
    	return workslist;
    }
}
