package com.racic.lib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="Library")
public class Library {

	@Id
	@GeneratedValue
	@Column
    private int libId;
	@Column
    private String libraryName;
	@Column
    private String city;
	@OneToMany(mappedBy="library", cascade = CascadeType.ALL)
	private List<Works> works;
	
	
    public Library() {
    }

    public Library(int libId, String libraryName, String city) {
        this.libId = libId;
        this.libraryName = libraryName;
        this.city = city;
    }

    public int getLibId() {
        return libId;
    }

    public void setLibId(int libId) {
        this.libId = libId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
