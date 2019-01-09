package com.racic.lib.batch;


import com.racic.lib.client.BorrowingWeb;
import com.racic.lib.client.BorrowingWs;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) {

        //the definition of the job instance..by pointing to the launchemailjob class (class implementing Job)
        JobDetail sendjob = JobBuilder.newJob(LaunchEmailJob.class)
                .withIdentity("sendjob", "group1").build();


        //using cron expression to specify the times to run the job.here is every 5seconds for test
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("triggersendjob", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();

// schedule the job

        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(sendjob, trigger);
            System.out.println("send ok!");

        } catch (SchedulerException e) {
            e.printStackTrace();
        }





    }
}
