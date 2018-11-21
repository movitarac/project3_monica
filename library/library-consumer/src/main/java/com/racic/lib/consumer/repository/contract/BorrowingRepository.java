package com.racic.lib.consumer.repository.contract;

import com.racic.lib.model.Borrowing;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BorrowingRepository {
    String addBorrowing (Borrowing borrowing);
    String deleteBorrowing (Borrowing borrowing);
    Borrowing findByIdAndMemberId(Borrowing borrowing);
    Borrowing findByBookId (Borrowing borrowing);
    Borrowing findByBorrowingId(Borrowing borrowing);
    List<Borrowing> borrowingList(Borrowing borrowing);
    List<Borrowing> borrowingListByReturnDate();

}
