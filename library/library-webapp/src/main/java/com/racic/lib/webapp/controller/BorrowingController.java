package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;
    
    @RequestMapping(value="/borrowings/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Borrowing sayHello(@PathVariable int id){

        System.out.println("borrowing found");
        return this.borrowingService.findByBorrowingId(id);
    }

    /*
    @RequestMapping(value = "/borrowing/{id}", method = RequestMethod.GET)

    public String getBorrowing(@PathVariable int id, Model model) {

        System.out.println("works found");
        String status = borrowingService.findByBorrowingId(id).getStatus();
        Date issueDate = borrowingService.findByBorrowingId(id).getIssueDate();
        Date returnDate = borrowingService.findByBorrowingId(id).getReturnDate();
        String workstitle = borrowingService.findByBorrowingId(id).getBook().getWorks().getTitle();
        boolean isextend = borrowingService.findByBorrowingId(id).isExtended();
        model.addAttribute("status",status);
        model.addAttribute("issueDate",issueDate);
        model.addAttribute("returnDate",returnDate);
        model.addAttribute("workstitle",workstitle);
        model.addAttribute("isextend",isextend);
        return "works/works-detail";
    }
     */

    @RequestMapping(value = "/borrowing/{id}", method = RequestMethod.GET)
    public String getBorrowingByMember(@PathVariable int id, Model model) {

        System.out.println("works found");
        String status = borrowingService.findByBorrowingId(id).getStatus();
        Date issueDate = borrowingService.findByBorrowingId(id).getIssueDate();
        Date returnDate = borrowingService.findByBorrowingId(id).getReturnDate();
        String workstitle = borrowingService.findByBorrowingId(id).getBook().getWorks().getTitle();
        boolean isextend = borrowingService.findByBorrowingId(id).isExtended();
        model.addAttribute("status",status);
        model.addAttribute("issueDate",issueDate);
        model.addAttribute("returnDate",returnDate);
        model.addAttribute("workstitle",workstitle);
        model.addAttribute("isextend",isextend);
        return "works/works-detail";
    }
}
