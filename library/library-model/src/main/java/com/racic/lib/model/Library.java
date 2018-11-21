package com.racic.lib.model;

import java.util.ArrayList;
import java.util.List;


public class Library {


    private int libId;

    private String libraryName;

    private String city;

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
