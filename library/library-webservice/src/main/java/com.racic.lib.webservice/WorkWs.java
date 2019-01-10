package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "workWeb",name = "workWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
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

    @WebMethod
    public List<Work> getAll() {

        return  workService.getAll();
    }

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
