package com.racic.lib.model;

import java.util.List;

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
    private Integer libId;
	@Column
    private String libraryName;
	@Column
    private String city;
	@OneToMany
	private List<Works> works;
	
	
    public Library() {
    }

    public Library(Integer libId, String libraryName, String city) {
        this.libId = libId;
        this.libraryName = libraryName;
        this.city = city;
    }

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
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

	public List<Works> getWorks() {
		return works;
	}

	public void setWorks(List<Works> works) {
		this.works = works;
	}
    
    
}
