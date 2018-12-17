package com.racic.lib.batch;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {



    public static void main(String[] args) {

        //ApplicationContext context= new ClassPathXmlApplicationContext("/library-webapp/webapp/WEB-INF/library-servlet.xml");

        try {
            //a job has a jobdetail -> to create the job instance
            //job builder instantiates the job, withidentity is the jobkey to identify the jobdetail
            //build -> build the job
            JobDetail job1 = JobBuilder.newJob(SendEmailJob.class).withIdentity("sendingjob1",
                    "group1").build();

            //Triggerbuilder create the instance of trigger
            //crontrigger
            // test for each 5 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();


            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job1, trigger);

            Thread.sleep(100000);
            scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();

        }




    }
}

