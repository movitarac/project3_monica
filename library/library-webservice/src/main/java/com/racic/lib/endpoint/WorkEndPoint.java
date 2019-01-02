package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.gs_ws.*;
import com.racic.lib.model.Work;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.*;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.ArrayList;
import java.util.List;


//@EndPoint
public class WorkEndPoint {

	private static final String NAMESPACE_URL = "work.client.lib.racic.com";

	@Autowired
	private WorkService workService;


 @PayloadRoot(namespace= NAMESPACE_URL, localPart = "workSearchByIdRequest")
	//@RequestPayload
	 public WorkSearchByIdResponse workSearchById (@RequestPayload WorkSearchByIdRequest request) {
	WorkSearchByIdResponse response = new WorkSearchByIdResponse();
	 WorkInfo workInfo = new WorkInfo();
	 BeanUtils.copyProperties(workService.findWorksById(request.getWorksId()),workInfo);
	 response.setWork(workInfo);
 	return response;
	 }


	@PayloadRoot(namespace= NAMESPACE_URL, localPart = "workSearchByAuthorRequest")
	//@RequestPayload
	 public WorkSearchByAuthorResponse findWorksByAuthorContain(@RequestPayload WorkSearchByAuthorRequest request) {
		 WorkSearchByAuthorResponse response = new WorkSearchByAuthorResponse();
		 List<WorkInfo> workInfos = new ArrayList<>();
		 List<Work> workListByAuthor = workService.findWorksByAuthorContain(request.getAuthor());
		for (int i = 0; i < workListByAuthor.size(); i++) {
			WorkInfo wi = new WorkInfo();
			BeanUtils.copyProperties(workService.findWorksByAuthorContain(request.getAuthor()),wi);
			workInfos.add(wi);
		}
		response.getWork().addAll(workInfos);
 	return response;
	 }


	@PayloadRoot(namespace= NAMESPACE_URL, localPart = "getAllWorksRequest")
	//@RequestPayload
	public GetAllWorksResponse getAll(@RequestPayload GetAllWorksRequest request) {
	GetAllWorksResponse response = new GetAllWorksResponse();
	List<WorkInfo> workInfoList = new ArrayList<>();
	List<Work> workList = workService.getAll();
		for (int i = 0; i <workList.size() ; i++) {
			WorkInfo wi = new WorkInfo();
			BeanUtils.copyProperties(workList.get(i),wi);
			workInfoList.add(wi);
		}
	response.getWork().addAll(workInfoList);

		return response;
	}

	@PayloadRoot(namespace= NAMESPACE_URL, localPart = "isValidWorkByAuthorRequest")
	//@RequestPayload
	public IsValidWorkByAuthorResponse isValidWorkByAuthor(@RequestPayload IsValidWorkByAuthorRequest request) {
	IsValidWorkByAuthorResponse response = new IsValidWorkByAuthorResponse();
	ServiceStatus workServiceStatus = new ServiceStatus();
	boolean flag = workService.isValidWorkByAuthor(request.getAuthor());
	if (flag == false) {
		workServiceStatus.setStatusCode("Conflict");
		workServiceStatus.setMessage("cannot find any work that is related to the author");
		response.setServiceStatus(workServiceStatus);
		response.setStatus(false);
	} else {
		workServiceStatus.setStatusCode("SUCCESS");
		workServiceStatus.setMessage("Find a or some work(s) that is related to the author");
		response.setStatus(true);
	}

 	return  response;
	}

}
