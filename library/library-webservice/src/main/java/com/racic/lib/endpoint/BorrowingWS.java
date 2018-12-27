package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@WebService
@Service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public class BorrowingWS {

    @Autowired
    BorrowingService borrowingService;

    @WebMethod(operationName = "returnBorrowing")
    public boolean returnBorrowing(Integer borrowingid, Member member){
        return borrowingService.returnBorrowing(borrowingid,member);
    }


    @WebMethod(operationName = "getNotReturnedBorrowing")
    public List<Borrowing> getNotReturnedBorrowing(Date today){
        return borrowingService.getNotReturnedBorrowing(today);
    }


    @WebMethod(operationName = "extendBorrowing")
    public boolean extendBorrowing(Integer borrowingId, Member member) {
        return borrowingService.extendBorrowing(borrowingId,member);
    }

    @WebMethod(operationName = "verifyBoksListAvailableSize")
    public boolean verifyBoksListAvailableSize(Integer worksid){
        return borrowingService.verifyBoksListAvailableSize(worksid);
    }

    @WebMethod(operationName = "borrowBook")
    public boolean borrowBook(Integer worksId, Member member){
        return borrowingService.borrowBook(worksId,member);
    }

    @WebMethod(operationName = "findBorrowingByMember")
    public List<Borrowing> findByMember(Member member) {
        return borrowingService.findByMember(member);
    }


    @WebMethod(operationName = "findByBorrowingId")
    public Borrowing findByBorrowingId(Integer borrowingid) {

        return borrowingService.findByBorrowingId(borrowingid);
    }

}
