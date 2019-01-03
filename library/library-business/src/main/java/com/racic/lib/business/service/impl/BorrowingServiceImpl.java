package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.Util.Utils;
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
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



@Service("borrowingService")
public class BorrowingServiceImpl implements BorrowingService {

    //public static final SimpleDateFormat FRENCH_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    BookService bookService;

    @Override
    public boolean returnBorrowing(Integer borrowingid, Member member) {
        boolean returnOk;

        Borrowing borrowingToBeReturned = borrowingRepository.findById(borrowingid).get();

        if (borrowingToBeReturned.getStatus().equals(Utils.BorrowStatusEnum.ONGOING.getValue())
                || borrowingToBeReturned.getStatus().equals(Utils.BorrowStatusEnum.EXTENDED.getValue())) {
            //change the status
            borrowingToBeReturned.setStatus(Utils.BorrowStatusEnum.RETURNED.getValue());
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


    @Override
    public List<Borrowing> getNotReturnedBorrowing(Date today) {
        List<Borrowing> borrowList = borrowingRepository.findAllByReturnDateBefore(today);

        return borrowList;
    }

    public boolean extendBorrowing(Integer borrowingId, Member member) {
        boolean toreturn;
        Borrowing borrowingtoBeExtended = borrowingRepository.findById(borrowingId).get();
        Date returnDate = borrowingtoBeExtended.getReturnDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(returnDate);
        calendar.add(Calendar.WEEK_OF_MONTH,4);
        returnDate = calendar.getTime();

        if (!borrowingtoBeExtended.isExtended()) {

            System.out.println("new date : " + returnDate + " we are in method extend borrowing");

            borrowingtoBeExtended.setReturnDate(returnDate);
            borrowingtoBeExtended.setStatus(Utils.BorrowStatusEnum.EXTENDED.getValue());
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
            Date issueDate=new Date();

            borrowToBeAdded.setIssueDate(issueDate);
            //calculate the return date
           Date returnDate = issueDate;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(returnDate);
            calendar.add(Calendar.WEEK_OF_MONTH,4);
            returnDate = calendar.getTime();

           borrowToBeAdded.setReturnDate(returnDate);

            borrowToBeAdded.setStatus(Utils.BorrowStatusEnum.ONGOING.getValue());
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
        return borrowingRepository.findByMember(member);
    }

    @Override
    public Borrowing findByBorrowingId(Integer borrowingid) {
        return borrowingRepository.findById(borrowingid).get();
    }


    public boolean launchSendEmail() {
        boolean sendOk;
        String username = "stherblain.library@gmail.com";
        String password = "ABC12345BATCHSt.HerBlain";

        /*SMPT Server configuration*/
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Date today = new Date();
        List<Borrowing> borrowList = borrowingRepository.findAllByReturnDateBefore(today);

        if (borrowList.size() > 0) {
            for (Borrowing borrow : borrowList) {
                if (today.after(borrow.getReturnDate())) {
                    System.out.println(borrow.getMember().getFirstName() + " " + borrow.getBook().getWork().getTitle());
                    Session session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });

                    try {

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("stherblain.library@gmail.com"));

                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(borrow.getMember().getEmail()));

                        message.setSubject("---Returning Book--City Library---");
                        message.setText(" Dear " + borrow.getMember().getFirstName() + " ,"
                                + "\n\n you haven't returned your loan for " +
                                borrow.getBook().getWork().getTitle() +
                                " . Please return it as soon as possible or before "
                                + borrow.getReturnDate());

                        Transport.send(message);

                        System.out.println("Sent to " + borrow.getMember().getEmail() +
                                " related to their loan " + borrow.getBook().getWork().getTitle());

                        sendOk = true;
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    System.out.println("PROBLEM!!!!");
                    sendOk = false;
                }

            }
        }else {
            System.out.println("PROBLEM!!!!");
        }
        sendOk = true;
return sendOk;
    }


}