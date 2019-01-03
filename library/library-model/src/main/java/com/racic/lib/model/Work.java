package com.racic.lib.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Work")
public class Work {
    @Id @GeneratedValue(generator="gen_works", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="gen_works", sequenceName="seq_works", allocationSize=1)
    private Integer worksId;
    private String title;
    private String author;
    private int copiesAvailable;
    private int publicationYear;
    private String bookDescription;
    private String imageUrl;
   @ManyToOne
    @JoinColumn(name="idlibrary")
    private Library library;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> books;



    public Work(String title, String author, int publicationYear, String bookDescription, int copiesAvailable, String imageUrl, Library library, List<Book> books) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.bookDescription = bookDescription;
        this.copiesAvailable = copiesAvailable;
        this.imageUrl = imageUrl;
        //this.library = library;
        this.books = books;
    }
//default constructor

    public Work() {
        super();
    }

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
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

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
