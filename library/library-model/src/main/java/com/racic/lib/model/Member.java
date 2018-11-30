package com.racic.lib.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Member")
@PrimaryKeyJoinColumn(name = "iduser")
public class Member extends User{

    private String firstName;
    private String lastName;
    private String email;
    private String address;
	@OneToMany
	private List<Borrowing> borrowing;
	
	
    public Member(String firstName, String lastName, String email,
			String address, List<Borrowing> borrowing) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;

		this.email = email;

		this.address = address;
		this.borrowing = borrowing;
	}

	//default constructor

    public Member() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public List<Borrowing> getBorrowing() {
		return borrowing;
	}

	public void setBorrowing(List<Borrowing> borrowing) {
		this.borrowing = borrowing;
	}


}
