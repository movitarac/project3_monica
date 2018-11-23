package com.racic.lib.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;



@Entity(name="Works")
public class Works {
	@Id
	@Column
    private int worksId;
	@Column
    private String title;
	@Column
    private String author;
	@Column
    private int publicationYear;
	@Column
    private String bookDescription;
	@Column
    private int copies;
	@ManyToOne
	@JoinColumn(name="idlibrary")
    private Library library;
	@OneToMany(mappedBy="works")
	private List<Book> books;

   
    public Works(int worksId, String title, String author, int publicationYear, String bookDescription, int copies,
			Library library, List<Book> books) {
		super();
		this.worksId = worksId;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.bookDescription = bookDescription;
		this.copies = copies;
		this.library = library;
		this.books = books;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
}
