package com.racic.lib.model;

import java.sql.Date;
import java.util.List;



public class Works {

    private int worksId;

    private String title;

    private String author;

    private int publicationYear;

    private String bookDescription;

    private int copies;

    private Library library;

    public Works(int worksId, String title, String author, int publicationYear, String bookDescription, int copies, Library library) {
        this.worksId = worksId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.bookDescription = bookDescription;
        this.copies = copies;
        this.library = library;
    }
    //default constructor

    public Works() {
    }

    public int getWorksId() {
        return worksId;
    }

    public void setWorksId(int worksId) {
        this.worksId = worksId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
