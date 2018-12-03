package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;

import com.racic.lib.model.Member;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;
    



    @RequestMapping(value="/library/browse/borrow/",method = RequestMethod.GET)
    public String borrow(Model model) {
        model.addAttribute("message","must log in to borrow button to borrow");
        return "borrowing/browse";
    }

    @RequestMapping(value="/library/browse/borrow/",method = RequestMethod.POST)
    public ModelAndView borrowbook(HttpServletRequest request, @ModelAttribute("member")
            Member member, Integer worksid) {
        Member loggedInMember = (Member) request.getSession().getAttribute("member");
        ModelAndView modelAndView = null;

        if (loggedInMember != null) {
            borrowingService.borrowBook(worksid, loggedInMember);
            modelAndView = new ModelAndView("borrowing/browse");
            modelAndView.addObject("msg", "Book is added to your borrow list!");
        } else {
            modelAndView = new ModelAndView("member/login");
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


    @RequestMapping(value="/library/borrowings/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Borrowing sayHello(@PathVariable Integer id){

        System.out.println("borrowing found");
        return this.borrowingService.findByBorrowingId(id);
    }


}
