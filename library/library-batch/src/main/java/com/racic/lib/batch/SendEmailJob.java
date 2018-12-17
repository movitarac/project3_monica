package com.racic.lib.batch;

import com.racic.lib.business.service.contract.BorrowingService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


public class SendEmailJob implements Job {

    //@Autowired
    //Email email;


    //Create the job
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        //the job is to send email
      Email email = new Email();
      email.sendEmail();
       System.out.println("JOB SENDING EMAIL: " + new Date() );
        System.out.println("getting borrowing service");
    }


}
