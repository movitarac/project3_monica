package com.racic.lib.business.service.contract;

import com.racic.lib.model.Book;
import com.racic.lib.model.Works;

import java.util.List;

public interface WorksService {

    List<Works> getAll();
    Works findWorksById(Integer worksid);
    List<Works> findWorksByAuthor(String author);
    Works findWorksByTitle(String title);

    List<Works> findWorksByAuthorIgnoreCase(String author);

    boolean isValidWork(String author);

    List<Book> getOnlyAvailableBooksForWork(Integer workid);
}
