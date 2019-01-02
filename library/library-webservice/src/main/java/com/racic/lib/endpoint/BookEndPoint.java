package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.gs_ws.*;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Work;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;


import java.util.ArrayList;
import java.util.List;

//@EndPoint
public class BookEndPoint {

    private static final String NAMESPACE_URL = "book.client.lib.racic.com";

    @Autowired
    BookService bookService;



    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findBookbyIdRequest")
    //@RequestPayload
    public FindBookbyIdResponse findBookById (@RequestPayload FindBookbyIdRequest request) {
        FindBookbyIdResponse response = new FindBookbyIdResponse();
        BookInfo bookInfo = new BookInfo();
        BeanUtils.copyProperties(bookService.findBookbyId(request.getBookId()),bookInfo);
        response.setBook(bookInfo);
        return response;
    }



    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "updateBookRequest")
    //@RequestPayload
    public UpdateBookResponse updateBook(@RequestPayload UpdateBookRequest request) {
       UpdateBookResponse response = new UpdateBookResponse();
       Book book = new Book();
       BeanUtils.copyProperties(request.getBook(),book);
        bookService.updateBook(book);
        ServiceStatus bookServiceStatus = new ServiceStatus();
        bookServiceStatus.setStatusCode("SUCCESS");
        bookServiceStatus.setMessage("Book info is updated");
        response.setServiceStatus(bookServiceStatus);
        return response;
    }

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findAvailableBooksFromWorkRequest")
    //@RequestPayload
    public FindAvailableBooksFromWorkResponse findAvailableBooksFromWork(@RequestPayload FindAvailableBooksFromWorkRequest request) {
        FindAvailableBooksFromWorkResponse response = new FindAvailableBooksFromWorkResponse();
        List<BookInfo> bookInfoList = new ArrayList<>();
        List<Book> bookAvailableList = bookService.findAvailableBooksFromWork(request.getWorksid());
        for (int i = 0; i < bookAvailableList.size(); i++) {
            BookInfo bookInfo = new BookInfo();
            BeanUtils.copyProperties(bookAvailableList.get(i),bookInfo);
            bookInfoList.add(bookInfo);
        }
        response.getBook().addAll(bookInfoList);
        return response;
   }


}
