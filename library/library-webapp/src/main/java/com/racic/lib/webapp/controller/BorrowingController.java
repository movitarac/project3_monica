package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.business.service.contract.MemberService;

import com.racic.lib.model.Member;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;
    
    @Autowired
    MemberService memberService;


    @RequestMapping(value="/library/browse/borrow/{worksId}",method = RequestMethod.GET)
    public ModelAndView borrowbook(HttpServletRequest request,@PathVariable Integer worksId) {
        ModelAndView modelAndView = null;

        if(request != null && request.getSession().getAttribute("connected")==null) {

            modelAndView = new ModelAndView("member/login");

        } else if(request != null && request.getSession().getAttribute("memberConnected") != null) {

           // Member loggedInMember = (Member)request.getAttribute("memberConnected");
            //System.out.println(loggedInMember.getFirstName());
            System.out.print(request.getAttribute("memberConnected"));
           // borrowingService.borrowBook(worksId,loggedInMember);
            modelAndView.addObject("msg", "Book is added to your borrow list!");

        } else {
            modelAndView = new ModelAndView("library/error");
        }

        return modelAndView;
    }


////////////////////////TEST/////////////////////////////

    @RequestMapping(value="/library/borrowingbymember/{booksIds}",method = RequestMethod.GET)
    public @ResponseBody String getBorrowingsByMember(@PathVariable String booksIds) {
        String[] arraybookid = booksIds.split("-");
        List<String> listbooktoborrow = new ArrayList<>();
        Collections.addAll(listbooktoborrow,arraybookid);

        borrowingService.addBorrowing(listbooktoborrow);

        return "add borrowing list";
    }


}
