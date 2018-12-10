package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.consumer.repository.WorkRepository;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<Work> getAll() {

        return workRepository.findAll();
    }

    @Override
    public Work findWorksById(Integer worksid) {
        return workRepository.findById(worksid).get();
    }


    @Override
    public List<Work> findWorksByAuthorContain(String author) {
        return workRepository.findWorksByAuthorIsContainingIgnoreCase(author);
    }


    public boolean isValidWorkByAuthor(String author) {
        boolean toReturn;
        List<Work> worksListFoundByAuthor = workRepository.findWorksByAuthorIsContainingIgnoreCase(author);

        if (worksListFoundByAuthor.size() >= 1) {
            toReturn = true;
        } else {
            toReturn = false;
        }
        return toReturn;
    }

    @Override
    public List<Work> findWorksByPublicationYear(int year) {
        return workRepository.findWorksByPublicationYear(year);
    }

    @Override
    public boolean isValidWorkByYear(int year) {
        boolean toReturn;
        List<Work> worksListFoundByYear = workRepository.findWorksByPublicationYear(year);

        if (worksListFoundByYear.size() >= 1) {
            toReturn = true;
        } else {
            toReturn = false;
        }
        return toReturn;
    }

}