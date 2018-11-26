package com.racic.lib.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.racic.lib.model.Works;

@Entity(name="Book")    
public class Book {
	@Id
    private String bookId;
	@Column
    private boolean isAvailable;
	@ManyToOne
	@JoinColumn(name="idworks")
    private Works works;
	@OneToOne(mappedBy="book")
	@JsonIgnore
	private Borrowing borrowing;
	
    public Book(String bookId, boolean isAvailable) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }

    public Book(String bookId, boolean isAvailable, Works works) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.works = works;
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

    public Works getWorks() {
        return works;
    }

    public void setWorks(Works works) {
        this.works = works;
    }

	public Borrowing getBorrowing() {
		return borrowing;
	}

	public void setBorrowing(Borrowing borrowing) {
		this.borrowing = borrowing;
	}
    
}
