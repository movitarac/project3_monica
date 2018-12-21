package com.racic.lib.batch;

import com.racic.lib.batch.conf.MyConfiguration;
import com.racic.lib.model.Borrowing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(MyConfiguration.class);
        Email email = context.getBean(Email.class);
        SendEmail send = context.getBean(SendEmail.class);

        //the job is to send email
        List<Borrowing> borrowings = email.getBorrowingListNotReturned();

        send.sendEmail(borrowings);
        System.out.println("-------executing job---------");


    }
}
