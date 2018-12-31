package com.racic.lib.webservice.endpoint;


import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Component
@WebService(serviceName = "bookWs",name = "bookWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class BookWs {

    @Autowired
    BookService bookService;

    @WebMethod
    public void updateBook(Book book) {
        bookService.updateBook(book);
    }

    @WebMethod
    public List<Book> findAvailableBooksFromWork(Integer worksid) {
        return bookService.findAvailableBooksFromWork(worksid);
    }

    @WebMethod
    public Book findBookbyId(String bookid){
        return bookService.findBookbyId(bookid);
    }
}
