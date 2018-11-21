package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.consumer.repository.contract.BookRepository;
import com.racic.lib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public Book findBookbyId(String bookid) {
        System.out.println("tout est ok dans le service book ");
        //return null;
        return bookRepository.findBookById(bookid);
    }

    public String findBookAvailability(Book book,String bookid) {

        boolean availability = book.isAvailable();

        return "Book " + bookid + " is " + availability;
    }




}
