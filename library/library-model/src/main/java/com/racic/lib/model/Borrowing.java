package com.racic.lib.model;

import java.util.Date;

public class Borrowing {

    private int idborrow;
    private int memberid;
    private Member member;
    private String bookid;
    private Book book;
    private Date issueDate;
    private Date returnDate;
    private boolean isExtended;

    public Borrowing() {
    }



    public int getIdborrow() {
        return idborrow;
    }

    public void setIdborrow(int idborrow) {
        this.idborrow = idborrow;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isExtended() {
        return isExtended;
    }

    public void setExtended(boolean extended) {
        isExtended = extended;
    }

    public Borrowing(int idborrow, int memberid, Member member, String bookid, Book book, Date issueDate, Date returnDate, boolean isExtended) {
        this.idborrow = idborrow;
        this.memberid = memberid;
        this.member = member;
        this.bookid = bookid;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.isExtended = isExtended;
    }
}
