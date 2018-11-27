package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.consumer.repository.BookRepository;
import com.racic.lib.consumer.repository.BorrowingRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BorrowingRepository borrowingRepository;
	@Autowired
	BookRepository bookRepository;

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


	public List<Borrowing> findByReturnDate(Date returnDate) {
		return borrowingRepository.findByReturnDate(returnDate);
	}


	public Borrowing findByMemberId(int memberid) {
		// TODO Auto-generated method stub
		return null;
	}


	public Borrowing findByBookId(String bookid) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Create a borrowing list from several books
	 * @param booksid
	 * @return
	 */
	public boolean addBorrowing (List<String> booksid){
		boolean toReturn;
		for ( String bookid : booksid )
		{
			Book bookToBorrow = bookRepository.findById(bookid).get();
			Borrowing borrowToSave = new Borrowing();
			borrowToSave.setBook(bookToBorrow);

			//to do replace by connected member
			Member m1 = new Member ();
			m1.setMemberId(1);
			m1.setFirstName("Lukas");
			m1.setLastName("George");
			borrowToSave.setMember(m1);

			borrowToSave.setIssueDate(new Date());
			// calculate the return date!

			//save the newest borrowing
			borrowingRepository.save(borrowToSave);
		}

		toReturn = true;
		return toReturn;
	}

}
