package com.racic.lib.batch;

import com.racic.lib.client.BorrowingWeb;
import com.racic.lib.client.BorrowingWs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LaunchEmailJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        //calling client from webservice
        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        //calling method from webservice
        boolean result = borrowingWs.launchSendEmail();

        System.out.println(result);


        System.out.println("-------executing job---------");

    }
}
