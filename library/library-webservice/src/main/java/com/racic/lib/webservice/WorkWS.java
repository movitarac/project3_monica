package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.business.service.impl.WorkServiceImpl;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import java.util.List;

@WebService(serviceName = "WorkService")
@Service("workServiceEndpoint")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public class WorkWS {

    WorkServiceImpl workService;

	public WorkWS() {
	}

    public WorkServiceImpl getWorkService() {
        return workService;
    }

    @WebMethod(exclude = true)
    public void setWorkService(WorkServiceImpl workService) {
        this.workService = workService;
    }

    @WebMethod(operationName="workSearchById")
	 public Work workSearchById(Integer id) {
		return workService.findWorksById(id);
	 }

	 @WebMethod(operationName="worksearchByAuthor")
	 public List<Work> findWorksByAuthorContain(String author) {
		 return workService.findWorksByAuthorContain(author);
	 }

	 @WebMethod(operationName = "getAllWorks")
	public List<Work> getAll() {

		return workService.getAll();
	}

	@WebMethod(operationName = "isValidWork")
	public boolean isValidWorkByAuthor(String author) {
		return  workService.isValidWorkByAuthor(author);
	}

}
