package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.BorrowingService;

import com.racic.lib.gs_ws.*;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@EndPoint
public class BorrowingEndPoint {

    private static final String NAMESPACE_URL = "borrowing.client.lib.racic.com";

    @Autowired
    BorrowingService borrowingService;

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "returnBorrowingRequest")
    //@RequestPayload
    public ReturnBorrowingResponse returnBorrowing(@RequestPayload ReturnBorrowingRequest request){
        ReturnBorrowingResponse response = new ReturnBorrowingResponse();
        ServiceStatus borrowingServiceStatus = new ServiceStatus();
        Member member = new Member();
        BeanUtils.copyProperties(request.getMember(),member);
      boolean flag = borrowingService.returnBorrowing(request.getIdborrow(),member);

      if (flag == false) {
            borrowingServiceStatus.setStatusCode("Conflict");
            borrowingServiceStatus.setMessage("cannot return the borrowing");
            response.setStatus(false);
            response.setServiceStatus(borrowingServiceStatus);

        } else {
            borrowingServiceStatus.setStatusCode("SUCCESS");
            borrowingServiceStatus.setMessage("Borrowing is returned");
            response.setStatus(true);
        }

        return response;
    }


    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "getNotReturnedBorrowingRequest")
    //@RequestPayload
    public GetNotReturnedBorrowingResponse getNotReturnedBorrowing(@RequestPayload GetNotReturnedBorrowingRequest request){
        GetNotReturnedBorrowingResponse response = new GetNotReturnedBorrowingResponse();
        Date date = request.getDate().toGregorianCalendar().getTime();
        List <Borrowing> borrowingList = borrowingService.getNotReturnedBorrowing(date);
        List <BorrowingInfo> borrowingInfoList = new ArrayList<>();
        for (int i = 0; i < borrowingList.size() ; i++) {
            BorrowingInfo borrowingInfo = new BorrowingInfo();
            BeanUtils.copyProperties(borrowingList.get(i),borrowingInfo);
            borrowingInfoList.add(borrowingInfo);
        }
        response.getBorrowing().addAll(borrowingInfoList);
        return response;
    }


    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "extendBorrowingRequest")
    //@RequestPayload
    public ExtendBorrowingResponse extendBorrowing(@RequestPayload ExtendBorrowingRequest request) {
        ExtendBorrowingResponse response = new ExtendBorrowingResponse();
        Member member = new Member();
        BeanUtils.copyProperties(request.getMember(),member);
        boolean flag = borrowingService.extendBorrowing(request.getIdborrow(),member);
        ServiceStatus serviceStatus = new ServiceStatus();
        if (flag == false) {
            serviceStatus.setStatusCode("Conflict");
            serviceStatus.setMessage("cannot extend the borrowing");
            response.setStatus(false);
            response.setServiceStatus(serviceStatus);

        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Borrowing is extended");
            response.setStatus(true);
        }
        return response;
    }

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "verifyBoksListAvailableSizeRequest")
    //@RequestPayload
    public VerifyBoksListAvailableSizeResponse verifyBoksListAvailableSize(@RequestPayload VerifyBoksListAvailableSizeRequest request){

        VerifyBoksListAvailableSizeResponse response = new VerifyBoksListAvailableSizeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        boolean flag = borrowingService.verifyBoksListAvailableSize(request.getWorksid());

        if (flag == false) {
            serviceStatus.setStatusCode("Conflict");
            serviceStatus.setMessage("problem with the size of the book list");
            response.setStatus(false);
            response.setServiceStatus(serviceStatus);

        } else {
            serviceStatus.setStatusCode("Ok");
            serviceStatus.setMessage("the size of the book list is ok");
            response.setStatus(true);
        }
        return response;
    }

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "borrowBookRequest")
    //@RequestPayload
    public BorrowBookResponse borrowBook(@RequestPayload BorrowBookRequest request){
      BorrowBookResponse response = new BorrowBookResponse();
      ServiceStatus serviceStatus = new ServiceStatus();
       Member member = new Member();
       MemberInfo memberInfo = request.getMember();
        BeanUtils.copyProperties(memberInfo,member);
        boolean flag = borrowingService.borrowBook(request.getWorksId(),member);
        if (flag == false) {
            serviceStatus.setStatusCode("Conflict");
            serviceStatus.setMessage("cannot borrow book");
            response.setStatus(false);
            response.setServiceStatus(serviceStatus);

        } else {
            serviceStatus.setStatusCode("Success");
            serviceStatus.setMessage("You borrowed successfully a book");
            response.setStatus(true);
        }

        return response;
    }

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findBorrowingByMemberRequest")
    //@RequestPayload
    public FindBorrowingByMemberResponse findByMember(@RequestPayload FindBorrowingByMemberRequest request) {
        FindBorrowingByMemberResponse response = new FindBorrowingByMemberResponse();
        Member member = new Member();
        List<BorrowingInfo> borrowingInfoList = new ArrayList<>();
        BeanUtils.copyProperties(request.getMember(),member);
        List<Borrowing> borrowingList = borrowingService.findByMember(member);

        for (int i = 0; i < borrowingList.size(); i++) {
            BorrowingInfo b = new BorrowingInfo();
            BeanUtils.copyProperties(borrowingList.get(i),b);
            borrowingInfoList.add(b);
        }
        response.getBorrowing().addAll(borrowingInfoList);
        return response;
    }


    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findByBorrowingIdRequest")
    //@RequestPayload
    public FindByBorrowingIdResponse findByBorrowingId(@RequestPayload FindByBorrowingIdRequest request) {
        FindByBorrowingIdResponse response = new FindByBorrowingIdResponse();
        BorrowingInfo borrowingInfo = new BorrowingInfo();
                Borrowing borrowing =borrowingService.findByBorrowingId(request.getIdborrow());
        BeanUtils.copyProperties(borrowing,borrowingInfo);
        response.getBorrowing();
        return response;
    }

}
