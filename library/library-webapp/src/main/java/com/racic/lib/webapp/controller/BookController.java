package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

   @Autowired
    BookService bookService;


    @RequestMapping(value="/library/book/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Book sayHello(@PathVariable String id){

        System.out.println("book found");
        return this.bookService.findBookbyId(id);
    }

}
