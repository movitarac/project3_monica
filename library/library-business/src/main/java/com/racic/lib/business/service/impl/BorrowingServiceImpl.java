package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.consumer.repository.BookRepository;
import com.racic.lib.consumer.repository.BorrowingRepository;
import com.racic.lib.consumer.repository.WorkRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    BookService bookService;

    public static final SimpleDateFormat FRENCH_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public boolean returnBorrowing(Integer borrowingid, Member member) {
        boolean returnOk;

        Borrowing borrowingToBeReturned = borrowingRepository.findById(borrowingid).get();

        if (borrowingToBeReturned.getStatus().equals("ongoing") || borrowingToBeReturned.getStatus().equals("extended")) {
            //change the status
            borrowingToBeReturned.setStatus("returned");
            Book bookToBeReturned = borrowingToBeReturned.getBook();

            //modify the book availability and the borrowing id
            bookToBeReturned.setAvailable(true);
            bookToBeReturned.setBorrowing(null);

            //save the modification for book and borrowing
            bookRepository.save(bookToBeReturned);
            borrowingRepository.save(borrowingToBeReturned);

            //update the copies available
            Work bookFromWorkToBeReturned = bookToBeReturned.getWork();
            List<Book> availableBooks = bookService.findAvailableBooksFromWork(bookFromWorkToBeReturned.getWorksId());

            bookFromWorkToBeReturned.setCopiesAvailable(availableBooks.size());
            workRepository.save(bookFromWorkToBeReturned);


            System.out.println(bookToBeReturned.getBookId() + " is being returned");
            returnOk = true;
        } else {

            System.out.println("Book has been already returned");
            returnOk = false;
        }

        return returnOk;
    }


    public boolean extendBorrowing(Integer borrowingId, Member member) {
        boolean toreturn;
        Borrowing borrowingtoBeExtended = borrowingRepository.findById(borrowingId).get();
        Date returnDate = borrowingtoBeExtended.getReturnDate();

        if (!borrowingtoBeExtended.isExtended()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(returnDate);
            calendar.add(Calendar.WEEK_OF_MONTH, 4);
            returnDate = calendar.getTime();
            System.out.println("new date : " + returnDate + " we are in method extend borrowing");

            borrowingtoBeExtended.setReturnDate(returnDate);
            borrowingtoBeExtended.setStatus("extended");
            borrowingtoBeExtended.setExtended(true);
            borrowingRepository.save(borrowingtoBeExtended);

            toreturn = true;
        } else {
            System.out.println("cannot extend the borrowing");
            toreturn = false;
        }
        System.out.println(returnDate + " we are in method extend borrowing");

        return toreturn;
    }

    @Override
    public boolean verifyBoksListAvailableSize(Integer worksid) {
        boolean toReturn;
        List<Book> availableBooks = bookService.findAvailableBooksFromWork(worksid);

        if (availableBooks.size() > 0) {
            System.out.println(availableBooks.size());
            toReturn = true;
        } else {
            System.out.println("the size of this list is 0");
            toReturn = false;
        }

        return toReturn;
    }


    @Override
    public boolean borrowBook(Integer worksId, Member member) {
        boolean toReturn;

        Work workWithToBeBorrowed = workRepository.findById(worksId).get();
        //make a book list from the same work (only available books)
        List<Book> booksAvailable = bookService.findAvailableBooksFromWork(worksId);

        Borrowing borrowToBeAdded = new Borrowing();

        /**
         * if a booksavailable list isn't null
         * set new borrowing
         */
        if (booksAvailable.size() > 0) {
            borrowToBeAdded.setMember(member);

            //set Issue Date
            borrowToBeAdded.setIssueDate(new Date());
            //borrowToBeAdded.setIssueDate(FRENCH_DATE_FORMAT.format(new Date()));

            //calculate the return date
            Date returndate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(returndate);
            calendar.add(Calendar.WEEK_OF_MONTH, 4);
            returndate = calendar.getTime();
            borrowToBeAdded.setReturnDate(returndate);


            borrowToBeAdded.setStatus("ongoing");
            borrowToBeAdded.setExtended(false);

            //the latest book on the available list will be borrowed
            Book bookToBeAdded = booksAvailable.get(booksAvailable.size() - 1);
            borrowToBeAdded.setBook(bookToBeAdded);

            //save the borrowing
            borrowingRepository.save(borrowToBeAdded);

            //change the availability of this book and the borrowing
            bookToBeAdded.setAvailable(false);
            bookToBeAdded.setBorrowing(borrowToBeAdded);

            System.out.println(bookToBeAdded.getBookId() + " is "
                    + bookToBeAdded.isAvailable());
            //update and save the modification for book in database
            bookRepository.save(bookToBeAdded);

            //remove the borrowed book from the list of available books
            booksAvailable.remove(bookToBeAdded);

            //update the total of available copy for the related work
            workWithToBeBorrowed.setCopiesAvailable(booksAvailable.size());

            //save the modification
            workRepository.save(workWithToBeBorrowed);

            System.out.println("book " + bookToBeAdded.getBookId() + " is succesfully borrowed by "
                    + member.getFirstName());
        } else {
            System.out.println("problem occured");
        }
        toReturn = true;
        return toReturn;
    }


    @Override
    public List<Borrowing> findByMember(Member member) {
        //change date format for each borrow

        //setDateRestitution (FRENCH_DATE_FORMAT.format(getDateRestitution));


        return borrowingRepository.findByMember(member);
    }

    @Override
    public Borrowing findByBorrowingId(Integer borrowingid) {
        return borrowingRepository.findById(borrowingid).get();
    }


}