package com.racic.lib.batch;


import com.racic.lib.client.BorrowingWeb;
import com.racic.lib.client.BorrowingWs;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) {

        JobDetail sendjob = JobBuilder.newJob(LaunchEmailJob.class)
                .withIdentity("sendjob", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("triggersendjob", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

// schedule it

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
