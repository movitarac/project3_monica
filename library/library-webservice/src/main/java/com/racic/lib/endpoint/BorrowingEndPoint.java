package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.BorrowingService;

import com.racic.lib.gs_ws.ReturnBorrowingRequest;
import com.racic.lib.gs_ws.ReturnBorrowingResponse;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.Date;
import java.util.List;

//@EndPoint
public class BorrowingEndPoint {

    private static final String NAMESPACE_URL = "borrowing.client.lib.racic.com";

    @Autowired
    BorrowingService borrowingService;
/*
    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "returnBorrowingRequest")
    //@RequestPayload
    public ReturnBorrowingResponse returnBorrowing(@RequestPayload ReturnBorrowingRequest request){
        ReturnBorrowingResponse response = new ReturnBorrowingResponse();
        BorrowingServiceStatus borrowingServiceStatus = new BorrowingServiceStatus();
       // boolean flag = borrowingService.returnBorrowing(request.getIdborrow(),request.getMember());



        return response;
    }



    public List<Borrowing> getNotReturnedBorrowing(Date today){
        return borrowingService.getNotReturnedBorrowing(today);
    }



    public boolean extendBorrowing(Integer borrowingId, Member member) {
        return borrowingService.extendBorrowing(borrowingId,member);
    }


    public boolean verifyBoksListAvailableSize(Integer worksid){
        return borrowingService.verifyBoksListAvailableSize(worksid);
    }


    public boolean borrowBook(Integer worksId, Member member){
        return borrowingService.borrowBook(worksId,member);
    }


    public List<Borrowing> findByMember(Member member) {
        return borrowingService.findByMember(member);
    }



    public Borrowing findByBorrowingId(Integer borrowingid) {

        return borrowingService.findByBorrowingId(borrowingid);
    }
*/
}
