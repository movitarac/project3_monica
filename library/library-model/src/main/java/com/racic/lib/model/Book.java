package com.racic.lib.model;




public class Book {

    private String bookId;

    private boolean isAvailable;

    private Works works;

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
}
