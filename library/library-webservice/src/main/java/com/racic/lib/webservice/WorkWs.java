package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService
public class WorkWs {

    @Autowired
    WorkService workService;

    @WebMethod
    public Work findWorksById(Integer worksid) {
        return  workService.findWorksById(worksid);
    }

    @WebMethod
    public List<Work> findWorksByAuthorContain(String author) {
        return workService.findWorksByAuthorContain(author);
    }

    @WebMethod
    public boolean isValidWorkByAuthor(String author) {
        return workService.isValidWorkByAuthor(author);
    }


}
