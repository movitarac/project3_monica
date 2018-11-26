package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.Book;

import java.sql.Date;
import java.util.List;

public interface BorrowingService {
    String addBorrowing (Borrowing borrowing);
    String deleteBorrowing (Borrowing borrowing);
    String updateBorrowing (Borrowing borrowing);
    Borrowing findByMemberId(int memberid);
    Borrowing findByBookId (String bookid);
    Borrowing findByBorrowingId(int borrowingid);
    List<Borrowing> findByReturnDate(Date returnDate);
    List<Borrowing> findByStatus(String status);
    String borrowingStatus (Borrowing borrowing, int borrowingid);
    String isExtended(Borrowing borrowing, int borrowingid);
}
