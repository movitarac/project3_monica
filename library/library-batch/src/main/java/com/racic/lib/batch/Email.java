package com.racic.lib.batch;


import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;
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
        //check les livres qui sont indisponible dans cette liste
        //pour chaque borrowing, recuperer member
        //recuperer email

        //construire le message (simuler ici..on met en string) (TO DO next message sur une table email
        //evoyer email au destinateur (installer serveur smtp/ ou utiliser serveur smtp en ligne)


//lancer a la main un jar...
        //
        //
        //
        // cron - pour programmer relancement regulierement

        System.out.println("the end of the class email");
        return borrowingListNotReturned;

    }

}

