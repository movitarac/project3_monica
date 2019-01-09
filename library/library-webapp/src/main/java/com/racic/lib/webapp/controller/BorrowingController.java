package com.racic.lib.webapp.controller;


import com.racic.lib.client.*;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class BorrowingController {


    @RequestMapping(value = "/borrow/{worksId}", method = RequestMethod.GET)
    public ModelAndView borrowThisbook(HttpServletRequest request, @PathVariable("worksId") Integer worksId) {
        ModelAndView modelAndView = null;
        WorkWeb workWeb = new WorkWeb();
        WorkWs workWs = workWeb.getWorkWsPort();
        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        if (request != null && request.getSession().getAttribute("connected") == null) {
            modelAndView = new ModelAndView("member/login");
            System.out.println("the member connected is null");

        } else if (request != null && request.getSession().getAttribute("connected") != null) {
            //get the connected member
            com.racic.lib.client.Member loggedInMember = (com.racic.lib.client.Member) request.getSession().getAttribute("memberConnected");
            System.out.print(loggedInMember.getFirstName() + " is connected " +
                    "and the clicked works id is " + worksId);

            //get the borrowed work
            com.racic.lib.client.Work borrowedWork = workWs.findWorksById(worksId);

            //call the method to verify if there are available copies for the work
            if (borrowingWs.verifyBoksListAvailableSize(worksId) == true) {
                //call the method borrowbook from borrowing service
                borrowingWs.borrowBook(worksId, loggedInMember);
                modelAndView = new ModelAndView("borrowing/borrowsuccess");
                modelAndView.addObject("loggedInMember", loggedInMember);
                modelAndView.addObject("borrowedWork", borrowedWork);
            } else {
                modelAndView = new ModelAndView("borrowing/borrowerror");
            }

        } else {
            modelAndView = new ModelAndView("library/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/borrowinglist", method = RequestMethod.GET)
    public ModelAndView getMemberBorrowingList(HttpServletRequest request) {
        ModelAndView mv = null;

        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        if (request == null && request.getSession().getAttribute("connected") == null) {
            mv = new ModelAndView("member/login");

        } else if (request != null && request.getSession().getAttribute("connected") != null) {
            mv = new ModelAndView("borrowing/borrowinginfo");
            com.racic.lib.client.Member loggedInMember = (com.racic.lib.client.Member) request.getSession().getAttribute("memberConnected");
            List<com.racic.lib.client.Borrowing> borrowingList = borrowingWs.findByMember(loggedInMember);
            mv.addObject("borrowingList", borrowingList);

        } else {
            mv = new ModelAndView("library/error");
        }
        return mv;
    }

    @RequestMapping(value = "/borrowinglist/extend/{borrowingid}", method = RequestMethod.GET)
    public ModelAndView extendBorrow (HttpServletRequest request,@PathVariable int borrowingid) {
        ModelAndView mv = null;
        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        String message="";
        String msgError="";
        if(request!=null && request.getSession().getAttribute("connected")!=null) {
            com.racic.lib.client.Member member = (com.racic.lib.client.Member) request.getSession().getAttribute("memberConnected");
            mv = new ModelAndView("borrowing/borrowinginfo");
           boolean extendOK = borrowingWs.extendBorrowing(borrowingid, member);
            if (extendOK ==true ) {
                List<com.racic.lib.client.Borrowing> borrowingList = borrowingWs.findByMember(member);
                mv.addObject("borrowingList", borrowingList);
                message += "Your borrowing period for " + borrowingWs.findByBorrowingId(borrowingid).getBook().getWork().getTitle() + " is successfully extended";
                mv.addObject("message", message);
                mv.addObject("extendOK",extendOK);
            } else {
                List<com.racic.lib.client.Borrowing> borrowingList = borrowingWs.findByMember(member);
                mv.addObject("borrowingList", borrowingList);
                msgError += " You cannot extend twice the borrowing period or the Book is already returned!!";
                mv.addObject("extendOK",extendOK);
                mv.addObject("msgError", msgError);
            }
        } else {
            mv = new ModelAndView("member/profile");
        }
        return mv;
    }

    @RequestMapping(value = "/borrowinglist/return/{borrowingid}", method = RequestMethod.GET)
    public ModelAndView returnBorrow (HttpServletRequest request,@PathVariable int borrowingid) {
        String message="";
        String msgError="";
        BorrowingWeb borrowingWeb = new BorrowingWeb();
        BorrowingWs borrowingWs = borrowingWeb.getBorrowingWsPort();
        ModelAndView mv = null;

        if(request!=null && request.getSession().getAttribute("connected")!=null) {
            com.racic.lib.client.Member member = (Member) request.getSession().getAttribute("memberConnected");
            mv = new ModelAndView("borrowing/borrowinginfo");
            boolean returnOK = borrowingWs.returnBorrowing(borrowingid, member);
            if (returnOK ==true ) {
                List<com.racic.lib.client.Borrowing> borrowingList = borrowingWs.findByMember(member);
                message += "Your borrowing for " + borrowingWs.findByBorrowingId(borrowingid).getBook().getWork().getTitle() + " is successfully returned";
                mv.addObject("borrowingList", borrowingList);
                mv.addObject("returnOK",returnOK);
                mv.addObject("message", message);
            } else {
                List<Borrowing> borrowingList = borrowingWs.findByMember(member);
                msgError += " You have returned this book!";
                mv.addObject("msgError", msgError);
                mv.addObject("borrowingList", borrowingList);
                mv.addObject("returnOK",returnOK);
            }
        } else {
            mv = new ModelAndView("member/profile");
        }
        return mv;
    }
}