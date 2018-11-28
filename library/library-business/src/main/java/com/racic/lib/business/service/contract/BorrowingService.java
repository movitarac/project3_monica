package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.Book;
import java.util.Date;
import java.util.List;

public interface BorrowingService {
    String addBorrowing (Borrowing borrowing);
    boolean addBorrowing (List<String> booksid);
    String deleteBorrowing (Borrowing borrowing);
    String updateBorrowing (Borrowing borrowing);
    Borrowing findByBorrowingId(int borrowingid);
    List<Borrowing> findByReturnDate(Date returnDate);
    List<Borrowing> findByStatus(String status);
    String borrowingStatus (Borrowing borrowing, int borrowingid);
    String isExtended(Borrowing borrowing, int borrowingid);
}
