package com.racic.lib.consumer.repository.impl;

import com.racic.lib.consumer.repository.contract.BookRepository;
import com.racic.lib.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    public List<Book> findAll() {
        return null;
    }

    public Book getBook() {

                return null;
    }

    public Book getBookById(String bookId) {

        return null;
    }

    public Book findBookById(String bookid) {
        Book book1 = new Book ("nar1",true);
        return book1;
    }

    public String getBookAvailability(String bookId) {
        return null;
    }
}
