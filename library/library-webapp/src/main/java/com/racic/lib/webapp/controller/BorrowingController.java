package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.business.service.contract.MemberService;

import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;

    @Autowired
    MemberService memberService;

    @Autowired
    WorkService workService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/library/borrow/{worksId}", method = RequestMethod.GET)
    public ModelAndView borrowThisbook(HttpServletRequest request, @PathVariable("worksId") Integer worksId) {
        ModelAndView modelAndView = null;

        if (request != null && request.getSession().getAttribute("connected") == null) {
            modelAndView = new ModelAndView("member/login");
            System.out.println("the member connected is null");

        } else if (request != null && request.getSession().getAttribute("connected") != null) {
            //get the connected member
            Member loggedInMember = (Member) request.getSession().getAttribute("memberConnected");
            System.out.print(loggedInMember.getFirstName() + " is connected " +
                    "and the clicked works id is " + worksId);

            //get the borrowed work
            Work borrowedWork = workService.findWorksById(worksId);

            //call the method to verify if there are available copies for the work
            if (borrowingService.verifyBoksListAvailableSize(worksId) == true) {
                //call the method borrowbook from borrowing service
                borrowingService.borrowBook(worksId, loggedInMember);
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

    @RequestMapping(value = "/library/borrowinglist", method = RequestMethod.GET)
    public ModelAndView getMemberBorrowingList(HttpServletRequest request) {
        ModelAndView mv = null;

        if (request == null && request.getSession().getAttribute("connected") == null) {
            mv = new ModelAndView("member/login");

        } else if (request != null && request.getSession().getAttribute("connected") != null) {
            mv = new ModelAndView("borrowing/borrowinginfo");
            Member loggedInMember = (Member)request.getSession().getAttribute("memberConnected");
            List<Borrowing> borrowingList = borrowingService.findByMember(loggedInMember);
            mv.addObject("borrowingList", borrowingList);

        } else {
            mv = new ModelAndView("library/error");
        }
        return mv;
    }

    @RequestMapping(value = "/library/borrowinglist/extend/{borrowingid}", method = RequestMethod.GET)
    public ModelAndView extendBorrow (HttpServletRequest request,@PathVariable int borrowingid) {
        ModelAndView mv = null;

        String message="";
        String msgError="";
        if(request!=null && request.getSession().getAttribute("connected")!=null) {
            Member member = (Member) request.getSession().getAttribute("memberConnected");
            mv = new ModelAndView("borrowing/borrowinginfo");
           boolean extendOK = borrowingService.extendBorrowing(borrowingid, member);
            if (extendOK ==true ) {
                List<Borrowing> borrowingList = borrowingService.findByMember(member);
                message += "Your borrowing period for " + borrowingService.findByBorrowingId(borrowingid).getBook().getWork().getTitle() + " is successfully extended";
                mv.addObject("borrowingList", borrowingList);
                mv.addObject("message", message);
                mv.addObject("extendOK",extendOK);
            } else {
                List<Borrowing> borrowingList = borrowingService.findByMember(member);
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

    @RequestMapping(value = "/library/borrowinglist/return/{borrowingid}", method = RequestMethod.GET)
    public ModelAndView returnBorrow (HttpServletRequest request,@PathVariable int borrowingid) {
        String message="";
        String msgError="";
        ModelAndView mv = null;

        if(request!=null && request.getSession().getAttribute("connected")!=null) {
            Member member = (Member) request.getSession().getAttribute("memberConnected");
            mv = new ModelAndView("borrowing/borrowinginfo");
            boolean returnOK = borrowingService.returnBorrowing(borrowingid, member);
            if (returnOK ==true ) {
                List<Borrowing> borrowingList = borrowingService.findByMember(member);
                message += "Your borrowing for " + borrowingService.findByBorrowingId(borrowingid).getBook().getWork().getTitle() + " is successfully returned";
                mv.addObject("borrowingList", borrowingList);
                mv.addObject("returnOK",returnOK);
                mv.addObject("message", message);
            } else {
                List<Borrowing> borrowingList = borrowingService.findByMember(member);
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