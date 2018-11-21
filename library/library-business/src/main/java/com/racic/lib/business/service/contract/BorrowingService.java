package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;

import java.util.List;

public interface BorrowingService {
    String addBorrowing (Borrowing borrowing);
    String deleteBorrowing (Borrowing borrowing);
    Borrowing findByIdAndMemberId(Borrowing borrowing);
    Borrowing findByBookId (Borrowing borrowing);
    Borrowing findByBorrowingId(Borrowing borrowing);
    List<Borrowing> borrowingList(Borrowing borrowing);
    List<Borrowing> borrowingListByReturnDate();
}
