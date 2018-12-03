package com.racic.lib.business.service.contract;

import java.util.List;

import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Works;

public interface BookService {

   Book findBookbyId(String bookid);

   String findBookAvailability(String bookid);

   Works findWorksByBookId(String bookid);
  
   Borrowing findBorrowingByBookId(String bookid);

   //List<Book> findBooksByWorks(Works works);
   List<Book> findBooksByWorksWorksId(Integer worksid);
}
