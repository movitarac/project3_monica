package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.consumer.repository.BookRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	public Book findBookbyId(String bookid) {
		return bookRepository.findById(bookid).get();
	}



	@Override
	public String updateBook(Book book) {
		bookRepository.save(book);
		return book.getBookId() + " is updated";
	}

	@Override
	public String findBookAvailability(String bookid) {


		boolean availability = bookRepository.findById(bookid).get().isAvailable();

		return "Book " + bookid + " is " + availability;
	}


	@Override
	public Work findWorksByBookId(String bookid) {
		return bookRepository.findById(bookid).get().getWork();
	}

	public Borrowing findBorrowingByBookId(String bookid) {
		return bookRepository.findById(bookid).get().getBorrowing();
	}


	@Override
	public List<Book> findBooksByWorksWorksId(Integer worksid) {

		return bookRepository.findBooksByWorkWorksId(worksid);
	}

	@Override
	public List<Book> findAvailableBooksFromWork(Integer worksid) {

	    boolean available=true;
		List<Book> availableBooks = bookRepository.findBooksByIsAvailableAndWorkWorksId(available,worksid);

		System.out.println(availableBooks.size());
		return availableBooks;
	}




}