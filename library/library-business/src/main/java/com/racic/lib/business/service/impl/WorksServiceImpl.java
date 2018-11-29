package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.consumer.repository.WorksRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Library;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Works findWorksById(String worksid) {
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
    @Override
    public List<Book> findByWorksId(String worksid){
    	return worksRepository.findById(worksid).get().getBooks();
    }

    @Override
    public String findLibraryNameByWorksId(String worksid) {
    	return worksRepository.findById(worksid).get().getLibrary().getLibraryName();
    }

    @Override
    public Works findWorksByAuthorIgnoreCase(String author) {
	    return worksRepository.findWorksByAuthorIgnoreCase(author);
    }

    @Override
    public Works findWorksByTitleIgnoreCase(String title) {
	    return worksRepository.findWorksByTitleIgnoreCase(title);
    }
}
