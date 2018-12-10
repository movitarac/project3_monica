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
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

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


    public String deleteBorrowing(Borrowing borrowing) {
        borrowingRepository.delete(borrowing);
        return "borrowing is deleted";
    }

    public String updateBorrowing(Borrowing borrowing) {
        borrowingRepository.save(borrowing);

        return "borrowing is updated";
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


    public boolean extendBorrowing(Integer borrowingId, Member member) {
        boolean toreturn;
        Borrowing borrowingtoBeExtended = borrowingRepository.findById(borrowingId).get();
        Date returnDate = borrowingtoBeExtended.getReturnDate();
        if(borrowingtoBeExtended.isExtended() == false){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(returnDate);
            calendar.add(Calendar.WEEK_OF_MONTH, 4);
            returnDate = calendar.getTime();
            borrowingtoBeExtended.setReturnDate(returnDate);
            borrowingRepository.save(borrowingtoBeExtended);
        } else {
            System.out.println("cannot extend the borrowing");
        }

        toreturn = true;
        return toreturn;
    }

    @Override
    public boolean verifyBoksListAvailableSize(Integer worksid) {
        boolean toReturn = false;
        List<Book> availableBooks = bookService.findAvailableBooksFromWork(worksid);

        if(availableBooks.size()>0)
        {
            System.out.println(availableBooks.size());
            toReturn=true;
        } else{
            System.out.println("the size of this list is 0");
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
        if (booksAvailable.size()> 0) {
            borrowToBeAdded.setMember(member);

            //set Issue Date
            borrowToBeAdded.setIssueDate(new Date());

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
            Book bookToBeAdded = booksAvailable.get(booksAvailable.size()-1);
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

            System.out.println("book " + bookToBeAdded.getBookId() +" is succesfully borrowed by "
                    + member.getFirstName());
        } else {
            System.out.println("problem occured");
        }
        toReturn = true;
        return toReturn;
    }
////////////////////TEST////////////////////////
    /**
     * Create a borrowing list from several books
     *
     * @param booksids
     * @return
     */
    public boolean addBorrowing(List<String> booksids) {
        boolean toReturn;
        for (String bookid : booksids) {
            Book bookToBorrow = bookRepository.findById(bookid).get();
            Borrowing borrowToSave = new Borrowing();
            Member m1 = new Member();
            m1.setIduser(1);
            m1.setFirstName("Lukas");
            m1.setLastName("George");

            boolean availability = bookToBorrow.isAvailable();
            if (availability == true) {
                borrowToSave.setBook(bookToBorrow);
                //to do replace by connected member
                borrowToSave.setMember(m1);
                borrowToSave.setIdborrow(2);
                borrowToSave.setIssueDate(new Date());
                // calculation of the return date!
                Date returndate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(returndate);
                calendar.add(Calendar.WEEK_OF_MONTH, 4);
                returndate = calendar.getTime();
                borrowToSave.setReturnDate(returndate);
                borrowToSave.setStatus("ongoing");
                bookToBorrow.setAvailable(false);
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

    @Override
    public List<Borrowing> findByMember(Member member) {
        return borrowingRepository.findByMember(member);
    }




}