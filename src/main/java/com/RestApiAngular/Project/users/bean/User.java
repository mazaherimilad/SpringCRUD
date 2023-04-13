package com.RestApiAngular.Project.users.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="users_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	@Column(name="user_name")
	private String name;
	@Column(name="user_Lname")
	private String lname;
	@Column(name="user_CF")
	private String codiceFiscale;
	public User() {}
	public User(int id, String name, String lname, String codiceFiscale) {
		super();
		this.id = id;
		this.name = name;
		this.lname=lname;
		this.codiceFiscale = codiceFiscale;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String Lname) {
		this.lname = Lname;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	@Override
	public String toString() {
		return "User [id=" + id +",Lname=" + lname + ", name=" + name + ", codiceFiscale=" + codiceFiscale + "]";
	}
}
