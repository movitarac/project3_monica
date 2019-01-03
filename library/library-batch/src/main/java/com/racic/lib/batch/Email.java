package com.racic.lib.batch;


import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.client.Borrowing;
import com.racic.lib.client.BorrowingWeb;
import com.racic.lib.client.BorrowingWs;

import org.springframework.beans.factory.annotation.Autowired;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;



public class Email {


    public List<Borrowing> getBorrowingListNotReturned() {
         Date today = new Date();
        XMLGregorianCalendar xmlDate = null;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(today);

        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();

        List<com.racic.lib.client.Borrowing> borrowingListNotReturned = borrowingWs.getNotReturnedBorrowing(xmlDate);



        System.out.println("the start of the class email");

        //recheck if the return date is greater/ after today
        for (com.racic.lib.client.Borrowing borrow : borrowingListNotReturned ) {
            if( xmlDate.compare(borrow.getReturnDate()) == DatatypeConstants.GREATER){
                System.out.println(borrow.getMember().getFirstName() + " " +borrow.getBook().getWork().getTitle());

            } else {
                System.out.println("PROBLEM!!!!");
            }

        }

        System.out.println("the end of the class email");
        return borrowingListNotReturned;

    }

}

