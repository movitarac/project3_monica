package com.racic.lib.business.service.contract;

import java.util.List;

import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Work;

public interface BookService {

    Book findBookbyId(String bookid);

    void updateBook(Book book);

    List<Book> findAvailableBooksFromWork(Integer worksid);
}