package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.consumer.repository.BorrowingRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BorrowingRepository borrowingRepository;

	public String addBorrowing(Borrowing borrowing) {
		borrowingRepository.save(borrowing);

		return "borrowing is saved";
	}

	public String deleteBorrowing(Borrowing borrowing) {
		borrowingRepository.delete(borrowing);
		return "borrowing is deleted";
	}

	public String updateBorrowing(Borrowing borrowing) {
		borrowingRepository.save(borrowing);

		return "borrowing is updated";
	}

	public Borrowing findByMember(Member member) {
		return borrowingRepository.findByMember(member);
	}

	public List<Borrowing> borrowingList(Borrowing borrowing) {
		return borrowingRepository.findAll();
	}

	@Override
	public Borrowing findByBorrowingId(int borrowingid) {
		return borrowingRepository.findById(borrowingid).get();
	}

	public String borrowingStatus(Borrowing borrowing, int borrowingid) {

		String borrowStatus = borrowingRepository.findById(borrowingid).get().getStatus();
		return "your borrowing status is " + borrowStatus;
	}

	public String isExtended(Borrowing borrowing, int borrowingid) {
		boolean status = borrowingRepository.findById(borrowingid).get().isExtended();
		if (status == true) {
			return "Your borrowing is extended ";
		} else {
			return "Your borrowing is not extended";
		}

	}

	public List<Borrowing> findByStatus(String status) {
		return borrowingRepository.findByStatus(status);
	}

	@Override
	public List<Borrowing> findByReturnDate(Date returnDate) {
		return borrowingRepository.findByReturnDate(returnDate);
	}

	@Override
	public Borrowing findByMemberId(int memberid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Borrowing findByBookId(String bookid) {
		// TODO Auto-generated method stub
		return null;
	}

}
