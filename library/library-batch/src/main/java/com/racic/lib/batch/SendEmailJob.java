package com.racic.lib.batch;

import com.racic.lib.batch.Conf.MyConfiguration;

import com.racic.lib.model.Borrowing;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import java.util.List;


public class SendEmailJob {


    //Create the job

    //public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        public void execute(){
          //  ApplicationContext context= new AnnotationConfigApplicationContext(MyConfiguration.class);
/*
        Email email = context.getBean(Email.class);
        SendEmail send = context.getBean(SendEmail.class);

        //the job is to send email
    List<Borrowing> borrowings = email.getBorrowingListNotReturned();

        send.sendEmail(borrowings);
       System.out.println("-------executing job---------");
       */
    }


}
