package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.consumer.repository.BookRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Works;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

    public Book findBookbyId(String bookid) {
        System.out.println("tout est ok dans le service book ");
        return bookRepository.findById(bookid).get();
    }


	@Override
	public String findBookAvailability(String bookid) {
		
		
		boolean availability = bookRepository.findById(bookid).get().isAvailable();

        return "Book " + bookid + " is " + availability;
	}


	@Override
	public Works findWorksByBookId(String bookid) {
		return bookRepository.findById(bookid).get().getWorks();
	}

	public Borrowing findBorrowingByBookId(String bookid) {
		return bookRepository.findById(bookid).get().getBorrowing();
	}


	@Override
	public List<Book> findBooksByWorksWorksId(Integer worksid) {
		return bookRepository.findBooksByWorksWorksId(worksid);
	}


}