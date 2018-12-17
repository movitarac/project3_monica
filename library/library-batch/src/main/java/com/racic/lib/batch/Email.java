package com.racic.lib.batch;


import com.racic.lib.business.service.Util.Utils;
import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Email {


    //Logger
    //private static final Logger logger = LogManager.getLogger(Email.class);

    @Autowired
    BorrowingService borrowingService;


    public void get() {

        // Get all the borrowing with Ongoing and Extended status
       List<Borrowing> borrowingListNotReturned = new ArrayList<>();

       List<Borrowing> borrowingListOngoing = borrowingService.getNotReturnedBorrowing(Utils.BorrowStatusEnum.ONGOING.getValue());
       // System.out.println(borrowingService.findByBorrowingId(7).getStatus());
        List<Borrowing> borrowingListExtended=borrowingService.getNotReturnedBorrowing(Utils.BorrowStatusEnum.EXTENDED.getValue());

        borrowingListNotReturned.addAll(borrowingListOngoing);
        borrowingListNotReturned.addAll(borrowingListExtended);


        //create list of member
        List<Member> members = new ArrayList<>();
        //create list of email
        List<String> emailList = new ArrayList<>();
        //check if all books in this list are not available

        for (Borrowing borrow : borrowingListNotReturned) {
            if( borrow.getBook().isAvailable() == false ) {
                System.out.println("books are checked..they are not available");
                members.add(borrow.getMember());
            } else {
                System.out.println("PROBLEM!!!!");
            }
        }

        for ( Member m:members ) {
            System.out.println(m.getFirstName() + " and email " + m.getEmail());
            emailList.add(m.getEmail());
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


    }

    public void sendEmail() {

        final String username = "stherblain.library@gmail.com";
        final String password = "12345BATCHSt.Her";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        List<String> emailAddressList = new ArrayList<>();
        emailAddressList.add("azura_mamoto@yahoo.co.id");
        emailAddressList.add("georgelulu.georgelulu@gmail.com");
        emailAddressList.add("charlottecamcam@gmail.com");
        emailAddressList.add("charleswaleswales@gmail.com");
        emailAddressList.add("louiscam.louiscam@yahoo.com");
        emailAddressList.add("willcam.willcam@yahoo.com");
        emailAddressList.add("cathcam.cathcam@yahoo.com");
        emailAddressList.add("marvin.racic@yahoo.fr");

        if (emailAddressList.size() > 0) {
            for (String emailaddress : emailAddressList) {

                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });

                try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("stherblain.library@gmail.com"));


                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(emailaddress));

                    message.setSubject("--Returning Book--");
                    message.setText("Dear Members ,"
                            + "\n\n you haven't returned your loan for several books." +
                            "Please return it as soon as possible ");

                    Transport.send(message);

                    System.out.println("Sent!");

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

            }


        }

    }
}
