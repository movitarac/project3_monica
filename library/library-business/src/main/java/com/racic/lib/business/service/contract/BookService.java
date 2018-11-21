package com.racic.lib.business.service.contract;

import com.racic.lib.model.Book;

public interface BookService {

    Book findBookbyId(String bookid);

    String findBookAvailability(Book book,String bookid);


}
