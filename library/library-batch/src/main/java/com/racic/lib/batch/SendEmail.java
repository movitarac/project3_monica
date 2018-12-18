package com.racic.lib.batch;

import com.racic.lib.model.Borrowing;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class SendEmail {


    public void sendEmail(List<Borrowing> borrowList) {
        final String username = "stherblain.library@gmail.com";
        final String password = "12345BATCHSt.Her";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        if (borrowList.size() > 0) {
            for (Borrowing borrow : borrowList) {

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
                            InternetAddress.parse(borrow.getMember().getEmail()));

                    message.setSubject("--Returning Book--City Library--");
                    message.setText("Dear " + borrow.getMember().getFirstName() + " ,"
                            + "\n\n you haven't returned your loan for " +
                            borrow.getBook().getWork().getTitle() +
                            " . Please return it as soon as possible or before "
                            + borrow.getReturnDate());

                    Transport.send(message);

                    System.out.println("Sent to" + borrow.getMember().getEmail() +
                            " related to their loan " + borrow.getBook().getWork().getTitle());

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public SendEmail() {
    }
}
