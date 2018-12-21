package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.business.service.impl.WorkServiceImpl;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import java.util.List;

@WebService
@Component
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public class WorkWS {

   @Autowired
    WorkService workService;
	
	@WebMethod(operationName="searchById")
	 public Work workSearchById(Integer id) {
		return workService.findWorksById(id);
	 }

	public WorkWS() {
	}
}
