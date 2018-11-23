package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.consumer.repository.BorrowingRepository;
import com.racic.lib.model.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BorrowingRepository borrowingRepository;
	
	
    public String addBorrowing(Borrowing borrowing) {
        borrowingRepository.save(borrowing);
    	
    	return "";
    }

    public String deleteBorrowing(Borrowing borrowing) {
        return null;
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

    public Borrowing getBorrowing(Borrowing borrowing) {
        return null;
    }

    public Borrowing getBorrowingByBorrowingId(Borrowing borrowing) {
        return null;
    }

    public List<Borrowing> borrowingList(Borrowing borrowing) {
        return null;
    }

    public List<Borrowing> borrowingListByReturnDate() {
        return null;
    }
}
