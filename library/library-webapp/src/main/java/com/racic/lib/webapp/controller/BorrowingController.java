package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;
    
    @RequestMapping(value="/borrowing/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Borrowing sayHello(@PathVariable int id){

        System.out.println("borrowing found");
        return this.borrowingService.findByBorrowingId(id);
    }
}
