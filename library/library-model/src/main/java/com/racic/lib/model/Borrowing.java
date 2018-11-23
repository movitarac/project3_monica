package com.racic.lib.model;

import java.util.Date;

import javax.persistence.*;
import com.racic.lib.model.Member;

@Entity(name="Borrowing")
public class Borrowing {
	@Id
	private int idborrow;
	@ManyToOne
   	@JoinColumn(name="idmember")
    private Member member;
   	@ManyToOne
   	@JoinColumn(name="idbook")
    private Book book;
    @Column
    private Date issueDate;
    @Column
    private Date returnDate;
    @Column
    private boolean isExtended;

    public Borrowing() {
    }



    public int getIdborrow() {
        return idborrow;
    }

    public void setIdborrow(int idborrow) {
        this.idborrow = idborrow;
    }

  

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public Borrowing(int idborrow, Member member, Book book, Date issueDate, Date returnDate, boolean isExtended) {
        this.idborrow = idborrow;
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.isExtended = isExtended;
    }
}
