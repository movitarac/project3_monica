package com.racic.lib.consumer.repository.impl;

import com.racic.lib.consumer.repository.contract.BorrowingRepository;
import com.racic.lib.model.Borrowing;

import java.util.List;

public class BorrowingRepositoryImpl implements BorrowingRepository {
    public String addBorrowing(Borrowing borrowing) {

        return "Book with id " + borrowing.getBookid() + " has been added to your borrowing list";
    }

    public String deleteBorrowing(Borrowing borrowing) {
        return "Book with id " + borrowing.getBookid() + " has been deleted fro; your borrowing list";
    }

    public Borrowing findByIdAndMemberId(Borrowing borrowing) {
        return null;
    }

    public Borrowing findByBookId(Borrowing borrowing) {
        return null;
    }

    public Borrowing findByBorrowingId(Borrowing borrowing) {
        return null;
    }

    public List<Borrowing> borrowingList(Borrowing borrowing) {
        return null;
    }

    public List<Borrowing> borrowingListByReturnDate() {
        return null;
    }


}
