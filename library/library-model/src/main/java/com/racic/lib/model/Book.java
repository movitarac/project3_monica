package com.racic.lib.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Book")
public class Book {
    @Id
    private String bookId;
    private boolean isAvailable;
    @ManyToOne
    private Work work;
    @OneToOne
    private Borrowing borrowing;

    public Book(String bookId, boolean isAvailable) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }

    public Book(String bookId, boolean isAvailable, Work work) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.work = work;
    }

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @XmlTransient
    public Borrowing getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }

}
