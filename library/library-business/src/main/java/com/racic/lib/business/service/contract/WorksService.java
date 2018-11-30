package com.racic.lib.business.service.contract;

import com.racic.lib.model.Book;
import com.racic.lib.model.Works;

import java.util.List;

public interface WorksService {

    List<Works> getAll();
    Works findWorksById(Integer worksid);
    Works findWorksByAuthor(String author);
    Works findWorksByTitle(String title);
    String addWorks(Works works);
    String deleteWorks(Works works);
    String updateWorks(Works works);
    List<Book> findByWorksId(Integer worksid);

    Works findWorksByAuthorIgnoreCase(String author);

    Works findWorksByTitleIgnoreCase(String title);

    boolean isValidWork(String author, String title);
}
