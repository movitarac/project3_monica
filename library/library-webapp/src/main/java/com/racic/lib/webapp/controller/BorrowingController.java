package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;

import com.racic.lib.model.Member;
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
    
    @RequestMapping(value="/library/borrowings/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Borrowing sayHello(@PathVariable Integer id){

        System.out.println("borrowing found");
        return this.borrowingService.findByBorrowingId(id);
    }

    @RequestMapping(value = "/library/borrowing/{id}", method = RequestMethod.GET)
    public String getBorrowingByMember(@PathVariable Integer id, Model model) {

        System.out.println("works found");
        String status = borrowingService.findByBorrowingId(id).getStatus();
        //Date issueDate = borrowingService.findByBorrowingId(id).getIssueDate();
        //Date returnDate = borrowingService.findByBorrowingId(id).getReturnDate();
        String workstitle = borrowingService.findByBorrowingId(id).getBook().getWorks().getTitle();
        boolean isextend = borrowingService.findByBorrowingId(id).isExtended();
        model.addAttribute("status",status);
       // model.addAttribute("issueDate",issueDate);
        //model.addAttribute("returnDate",returnDate);
        model.addAttribute("workstitle",workstitle);
        model.addAttribute("isextend",isextend);
        return "works/works-detail";
    }

    @RequestMapping(value="/library/borrowingbymember/{booksIds}",method = RequestMethod.GET)
    public @ResponseBody String getBorrowingsByMember(@PathVariable String booksIds) {
        String[] arraybookid = booksIds.split("-");
        List<String> listbooktoborrow = new ArrayList<>();
        Collections.addAll(listbooktoborrow,arraybookid);

        borrowingService.addBorrowing(listbooktoborrow);

        return "add borrowing list";
    }


}
