package com.racic.lib.batch;


import com.racic.lib.client.BorrowingWeb;
import com.racic.lib.client.BorrowingWs;

public class Main {
    public static void main(String[] args) {



        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        boolean result = borrowingWs.launchSendEmail();
        System.out.println(result);
        System.out.println("-------executing job---------");

    }
}
