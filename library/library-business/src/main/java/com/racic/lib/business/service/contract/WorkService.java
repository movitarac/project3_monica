package com.racic.lib.business.service.contract;

import com.racic.lib.model.Work;

import java.util.List;

public interface WorkService {

    List<Work> getAll();
    Work findWorksById(Integer worksid);

    List<Work> findWorksByAuthorContain(String author);

    boolean isValidWorkByAuthor(String author);


}
