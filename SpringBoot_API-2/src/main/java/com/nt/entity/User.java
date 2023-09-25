package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_DITL")
public class User {
 
	@Id
	@Column(name = "User_Id")
	private Integer user_Id; 
	
	@Column(name = "USER_NAME")
	private String user_Name;
	
	@Column(name = "USER_AGE")
	private Integer user_age;
	
	@Column(name = "USER_PHNO")
	private Integer user_Phno;
	
	@Column(name = "USER_COUNTRY")
	private String user_Country;
	
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public Integer getUser_age() {
		return user_age;
	}
	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}
	public Integer getUser_Phno() {
		return user_Phno;
	}
	public void setUser_Phno(Integer user_Phno) {
		this.user_Phno = user_Phno;
	}
	public String getUser_Country() {
		return user_Country;
	}
	public void setUser_Country(String user_Country) {
		this.user_Country = user_Country;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_Name=" + user_Name + ", user_age=" + user_age + ", user_Phno="
				+ user_Phno + ", user_Country=" + user_Country + "]";
	}
}
