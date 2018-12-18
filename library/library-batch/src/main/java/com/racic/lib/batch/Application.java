package com.racic.lib.batch;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;



public class Application {




    public static void main(String[] args) {

        SendEmailJob job = new SendEmailJob();
        job.execute();

        /*
        try {

            //create instance of factory and get scheduler
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();

            //a job has a jobdetail -> to create the job instance
            //job builder instantiates the job, withidentity is the jobkey to identify the jobdetail
            //build -> build the job

            //create jobdeatil object specifying which job we want to execute
            JobDetail job1 = JobBuilder.newJob(SendEmailJob.class).withIdentity("sendingjob1",
                    "group1").build();

            //Triggerbuilder create the instance of trigger
            //crontrigger
            // test for each 5 seconds
            //associate trigger to the job
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

            //pass jobdetail and triger to scheduler
            scheduler.scheduleJob(job1, trigger);

            scheduler.start();

            //scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();

        }

*/

    }


}

