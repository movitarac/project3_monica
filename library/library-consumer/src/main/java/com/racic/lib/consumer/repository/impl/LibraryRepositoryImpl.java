package com.racic.lib.consumer.repository.impl;


import com.racic.lib.consumer.repository.contract.LibraryRepository;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class LibraryRepositoryImpl {
    
	public Library findLibraryByName(String libraryName) {
        return null;
    }

    public Library findLibraryById(int libraryid) {
    	return null;
    }
    public List<Works> getworksList() {
        return null;
    }

	public List<Library> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
