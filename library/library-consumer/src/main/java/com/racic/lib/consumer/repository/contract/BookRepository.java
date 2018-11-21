package com.racic.lib.consumer.repository.contract;

import com.racic.lib.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository{
    List<Book> findAll();
    Book getBookById(String bookId);
    Book findBookById(String bookid);
    String getBookAvailability(String bookId);
    Book getBook();
}
