package com.racic.lib.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Member")
public class Member {
	@Id
	@GeneratedValue
	@Column
    private int memberId;
	@Column
    private String firstName;
	@Column
    private String lastName;
	@Column
	private String username;
	@Column
    private String email;
	@Column
    private String password;
	@Column
    private String address;
	@OneToMany(mappedBy="member")
	@JsonIgnore
	private List<Borrowing> borrowing;
	
	
    public Member(int memberId, String firstName, String lastName, String username, String email, String password,
			String address, List<Borrowing> borrowing) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.borrowing = borrowing;
	}

	//default constructor

    public Member() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
