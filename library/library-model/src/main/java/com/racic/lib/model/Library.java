package com.racic.lib.model;

import java.util.List;

import javax.persistence.*;


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

   /* public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

*/
}
