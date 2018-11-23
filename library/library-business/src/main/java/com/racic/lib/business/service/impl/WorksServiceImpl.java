package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.consumer.repository.WorksRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorksServiceImpl implements WorksService {

  

    public List<Works> getAll() {
        return null;
    }

    public Works findWorksById(String worksid) {
        return null;
    }

    public Works findWorksByAuthor(String author) {
        return null;
    }

    public Works findWorksByTitle(String title) {
        return null;
    }

    public String addWorks(Works works) {
        return null;
    }

    public String deleteWorks(Works works) {
        return null;
    }

    public String updateWorks(Works works) {
        return null;
    }
}
