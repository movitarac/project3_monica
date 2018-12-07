package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.consumer.repository.WorksRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WorksServiceImpl implements WorksService {

	@Autowired
	WorksRepository worksRepository;

	@Autowired
    BookService bookService;

    @Override
	public List<Works> getAll(){

        return worksRepository.findAll();
	}

    @Override
	public Works findWorksById(Integer worksid) {
        return worksRepository.findById(worksid).get();
    }

    @Override
    public List<Works> findWorksByAuthor(String author) {
        return worksRepository.findWorksByAuthor(author);
    }



    @Override
    public Works findWorksByTitle(String title) {
        return worksRepository.findByTitle(title);
    }


    @Override
    public List<Works> findWorksByAuthorIgnoreCase(String author) {
	    return worksRepository.findWorksByAuthorIgnoreCase(author);
    }


    public boolean isValidWork(String author) {
        boolean toReturn;
        List<Works> worksListFoundByAuthor = worksRepository.findWorksByAuthor(author);
        if (worksListFoundByAuthor.size()>=1){
            toReturn = true;
        } else{
            toReturn = false;
        }
        return toReturn;
    }

    @Override
    public List<Book> getOnlyAvailableBooksForWork(Integer workid) {
        List<Book> availableBooks = bookService.findAvailableBook(workid);
        System.out.println("we are in method getonlyavailablebook in workservice");
        return availableBooks;
    }
}
