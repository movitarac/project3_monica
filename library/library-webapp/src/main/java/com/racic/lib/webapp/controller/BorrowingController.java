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

import java.util.ArrayList;
import java.util.Collections;
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

    @RequestMapping(value = "/library/borrow", method = RequestMethod.POST)
    public ModelAndView borrowbook(HttpServletRequest request, @RequestParam("worksId") Integer worksId) {
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


    @RequestMapping(value = "/library/borrowinglist", method = RequestMethod.POST)
    public ModelAndView getMemberBorrowingList(HttpServletRequest request) {
        ModelAndView mv = null;

        if (request == null && request.getSession().getAttribute("connected") == null) {
            mv = new ModelAndView("member/login");

        } else if (request != null && request.getSession().getAttribute("connected") != null) {
            mv = new ModelAndView("borrowing/borrowinginfo");
            Member loggedInMember = (Member)request.getSession().getAttribute("memberConnected");
            List<Borrowing> borrowingList = borrowingService.findByMember(loggedInMember);

            mv.addObject("borrowingList", borrowingList);
            // mv.addObject("worksBorrowed", worksBorrowed);
        } else {
            mv = new ModelAndView("library/error");
        }
        return mv;
    }


    ////////////////////////TEST/////////////////////////////

    @RequestMapping(value = "/library/borrowingbymember/{booksIds}", method = RequestMethod.GET)
    public @ResponseBody
    String getBorrowingsByMember(@PathVariable String booksIds) {
        String[] arraybookid = booksIds.split("-");
        List<String> listbooktoborrow = new ArrayList<>();
        Collections.addAll(listbooktoborrow, arraybookid);

        borrowingService.addBorrowing(listbooktoborrow);

        return "add borrowing list";
    }
}