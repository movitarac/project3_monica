package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@Service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public class BookWS {

    @Autowired
    BookService bookService;

    @WebMethod(operationName = "findBookById")
    public Book findBookbyId(String bookid) {
        return bookService.findBookbyId(bookid);

    }


    @WebMethod(operationName = "updateBook")
    public String updateBook(Book book) {

        return bookService.updateBook(book);
    }

    @WebMethod(operationName = "findBookAvailability")
    public String findBookAvailability(String bookid) {


        return bookService.findBookAvailability(bookid);
    }


    @WebMethod(operationName = "findWorksByBookId")
    public Work findWorksByBookId(String bookid) {

        return bookService.findWorksByBookId(bookid);
    }

    @WebMethod(operationName = "findBorrowingByBookId")
    public Borrowing findBorrowingByBookId(String bookid) {
        return bookService.findBorrowingByBookId(bookid);
    }


    @WebMethod(operationName = "findBooksByWorksId")
    public List<Book> findBooksByWorksWorksId(Integer worksid) {

        return bookService.findBooksByWorksWorksId(worksid);
    }

    @WebMethod(operationName = "findAvailableBooksFromWork")
    public List<Book> findAvailableBooksFromWork(Integer worksid) {

        return bookService.findAvailableBooksFromWork(worksid);
    }


}
