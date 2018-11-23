package com.racic.lib.business.service.contract;

import com.racic.lib.model.Book;
import com.racic.lib.model.Works;

public interface BookService {

   Book findBookbyId(String bookid);

   String findBookAvailability(Book book,String bookid);

   Works findBookWorks(Works works);
  
   
}
