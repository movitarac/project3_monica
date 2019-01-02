package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.LibraryService;
import com.racic.lib.consumer.repository.LibraryRepository;
import com.racic.lib.model.Library;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("libraryServuce")
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    /*public Library getByWorkList(Work work) {
        return libraryRepository.findByWorks(work);
    }
    */

    public Library getLibraryByName(String libraryName) {
        return libraryRepository.findByLibraryName(libraryName);
    }

    public Library getLibraryById(Integer id) {
        return libraryRepository.findById(id).get();
    }

    public Library getLibraryByCity(String city) {
        return libraryRepository.findByCity(city);
    }
    /*public List<Work> findByLibraryId(Integer libraryid) {
        List<Work> workslist = libraryRepository.findById(libraryid).get().getWorks();
        return workslist;
    }
    */
}