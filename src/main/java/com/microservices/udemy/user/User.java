package com.microservices.udemy.user;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private Integer id;
	@Size(min = 2,message = "Name should have atleast 2 characters.")
	private String userName;
	@Past(message = "Birth date should be from past.")
	private LocalDate birthDate;

	public User(Integer id, String userName, LocalDate birthDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthDate=" + birthDate + "]";
	}

}
