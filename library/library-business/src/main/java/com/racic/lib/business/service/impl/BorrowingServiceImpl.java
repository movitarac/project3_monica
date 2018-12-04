package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.consumer.repository.BookRepository;
import com.racic.lib.consumer.repository.BorrowingRepository;
import com.racic.lib.consumer.repository.WorksRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

	@Autowired
	BorrowingRepository borrowingRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	WorksRepository worksRepository;

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


	public boolean extendBorrowing (Integer borrowingId, Member member) {
		boolean toreturn;
		Borrowing borrowingtoBeExtended = borrowingRepository.findById(borrowingId).get();
		Date newReturnDate = borrowingtoBeExtended.getReturnDate();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newReturnDate);
		calendar.add(Calendar.WEEK_OF_MONTH,4);
		newReturnDate =calendar.getTime();
		borrowingtoBeExtended.setReturnDate(newReturnDate);

		toreturn=true;
		return  toreturn;
	}

	@Override
	public boolean borrowBook(Integer worksId, Member member) {
		boolean toReturn;

		List<Book> bookslist = bookRepository.findBooksByWorksWorksId(worksId);
		List<Book> booksAvailable = new ArrayList<>();
		for (Book book : bookslist) {
			boolean bookIsAvailable = book.isAvailable();
			if (bookIsAvailable==true) {
				booksAvailable.add(book);
			} else {
				String errormessage = "not ok";
			}
		}

		Borrowing borrowToBeSaved = new Borrowing();

		if (booksAvailable.size()>0) {
			Book bookToBeBorrowed = booksAvailable.get(0);
			borrowToBeSaved.setBook(bookToBeBorrowed);
			borrowToBeSaved.setMember(member);
			borrowToBeSaved.setIssueDate(new Date());
			Date returndate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(returndate);
			calendar.add(Calendar.WEEK_OF_MONTH, 4);
			returndate = calendar.getTime();
			borrowToBeSaved.setReturnDate(returndate);
			borrowToBeSaved.setStatus("ongoing");

			bookToBeBorrowed.setAvailable(false);
		}
		toReturn= true;
		return toReturn;
	}

	/**
	 * Create a borrowing list from several books
	 * @param booksids
	 * @return
	 */
	public boolean addBorrowing (List<String> booksids){
		boolean toReturn;
		for ( String bookid : booksids ) {
			Book bookToBorrow = bookRepository.findById(bookid).get();
			Borrowing borrowToSave = new Borrowing();
			Member m1 = new Member();
			m1.setIduser(1);
			m1.setFirstName("Lukas");
			m1.setLastName("George");

			boolean availability = bookToBorrow.isAvailable();
			if (availability) {
				borrowToSave.setBook(bookToBorrow);
				//to do replace by connected member
				borrowToSave.setMember(m1);

				borrowToSave.setIssueDate(new Date());
				// calculation of the return date!
				Date returndate= new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(returndate);
				calendar.add(Calendar.WEEK_OF_MONTH,4);
				returndate =calendar.getTime();
				borrowToSave.setReturnDate(returndate);
				borrowToSave.setStatus("ongoing");
				//save the newest borrowing
				borrowingRepository.save(borrowToSave);
				availability = false;
			} else {
				String errormessage = "Cannot borrow";
			}

		}

		toReturn = true;
		return toReturn;
	}

}
