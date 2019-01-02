package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class BookController {

   @Autowired
    BookService bookService;



    @RequestMapping(value="/book/{id}",method= RequestMethod.GET)
    public @ResponseBody
    Book sayHello(@PathVariable String id){

        System.out.println("book found");
        return this.bookService.findBookbyId(id);
    }

/*
    @RequestMapping(value="/example",method= RequestMethod.GET)
    public Book example(@PathVariable String id) throws MalformedURLException {
    URL url = new URL("http://localhost:8080/library-webapp/ws/bookWs?wsdl");
        BookWs_Service bookWsService = new BookWs_Service(url);
        BookWs bookwsProxy = bookWsService.getBookWsPort();
        List<Book> books = bookwsProxy.findBookbyId(id)
    }
*/
}
