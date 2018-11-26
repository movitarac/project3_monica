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

	public List<Works> getAll(){
		return worksRepository.findAll();
	}
    public Works findWorksById(String worksid) {
        return worksRepository.findById(worksid).get();
    }

    public Works findWorksByAuthor(String author) {
        return worksRepository.findByAuthor(author);
    }

    public Works findWorksByTitle(String title) {
        return worksRepository.findByAuthor(title);
    }

    public String addWorks(Works works) {
        worksRepository.save(works);
        return "save works";
    }

    public String deleteWorks(Works works) {
    	worksRepository.delete(works);
        return works.getTitle() + " is deleted.";
    }

    public String updateWorks(Works works) {
    	worksRepository.save(works);
        return "work is updated!";
    }
    public List<Book> findByWorksId(String worksid){
    	return worksRepository.findById(worksid).get().getBooks();
    }
    
    public String findLibraryNameByWorksId(String worksid) {
    	return worksRepository.findById(worksid).get().getLibrary().getLibraryName();
    }
}
