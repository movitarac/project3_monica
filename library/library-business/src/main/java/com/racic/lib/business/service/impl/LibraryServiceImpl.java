package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.LibraryService;
import com.racic.lib.consumer.repository.contract.LibraryRepository;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryServiceImpl implements LibraryService {

   

    public List<Works> getAll() {
        return null;
    }

    public Library find(String libraryName) {
        return null;
    }

    public Library getLibraryById(int id) {
        return null;
    }

    public Library getMemberById(int id) {
        return null;
    }
}
