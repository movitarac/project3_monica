package com.racic.lib.batch;


import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;

import java.util.Date;
import java.util.List;



public class Email {


    //Logger
    //private static final Logger logger = LogManager.getLogger(Email.class);

    @Autowired
    BorrowingService borrowingService;


    public List<Borrowing> getBorrowingListNotReturned() {
        Date today = new Date();
        List<Borrowing> borrowingListNotReturned = borrowingService.getNotReturnedBorrowing(today);



        System.out.println("the start of the class email");


        for (Borrowing borrow : borrowingListNotReturned ) {
            if( today.after(borrow.getReturnDate())) {
                System.out.println(borrow.getMember().getFirstName() + " " +borrow.getBook().getWork().getTitle());

            } else {
                System.out.println("PROBLEM!!!!");
            }

        }

        System.out.println("the end of the class email");
        return borrowingListNotReturned;

    }

}

