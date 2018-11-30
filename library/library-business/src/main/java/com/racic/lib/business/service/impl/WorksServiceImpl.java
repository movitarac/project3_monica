package com.racic.lib.business.service.impl;

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

    @Override
	public List<Works> getAll(){

        return worksRepository.findAll();
	}

    @Override
	public Works findWorksById(Integer worksid) {
        return worksRepository.findById(worksid).get();
    }

    @Override
    public Works findWorksByAuthor(String author) {
        return worksRepository.findByAuthor(author);
    }

    @Override
    public Works findWorksByTitle(String title) {
        return worksRepository.findByAuthor(title);
    }

    @Override
    public String addWorks(Works works) {
        worksRepository.save(works);
        return "save works";
    }

    @Override
    public String deleteWorks(Works works) {
    	worksRepository.delete(works);
        return works.getTitle() + " is deleted.";
    }

    @Override
    public String updateWorks(Works works) {
    	worksRepository.save(works);
        return "work is updated!";
    }
    public List<Book> findByWorksId(Integer worksid){
    	return worksRepository.findById(worksid).get().getBooks();
    }


    @Override
    public Works findWorksByAuthorIgnoreCase(String author) {
	    return worksRepository.findWorksByAuthorIgnoreCase(author);
    }

    @Override
    public Works findWorksByTitleIgnoreCase(String title) {
	    return worksRepository.findWorksByTitleIgnoreCase(title);
    }


    @Override
    public boolean isValidWork(String author, String title) {

        boolean toReturn;

        Works workFoundByAuthor = worksRepository.findWorksByAuthorIgnoreCase(author);
        Works workFoundByTitle = worksRepository.findWorksByTitleIgnoreCase(title);

        List<Works> worksFound = new ArrayList<>();
        worksFound.add(workFoundByAuthor);
        worksFound.add(workFoundByTitle);
        if (worksFound.size()>= 1 && workFoundByAuthor !=null && workFoundByTitle !=null) {
            toReturn = true;
        } else{
            toReturn = false;
        }

        return toReturn;
    }

}
