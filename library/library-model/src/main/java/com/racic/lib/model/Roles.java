package com.racic.lib.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Roles")
public class Roles {

	@Id
	@GeneratedValue
	@Column
	private int roleid;
	@ManyToMany(mappedBy="roles")
	@JsonIgnore
	private List<Member> members;
	@Column
	private String role;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Roles(int roleid, List<Member> members, String role) {
		super();
		this.roleid = roleid;
		this.members = members;
		this.role = role;
	}
	public Roles() {
	}
	
	
}
